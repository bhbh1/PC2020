/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej1;

import Utiles.IO;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author b h
 */
public class Comedor {

    private int id;
    //Controla para que solo una especie bloquee a la otra
    private Semaphore semGeneral;
    //Controlan la cantidad de animales que pueden entrar
    private Semaphore semGatos;
    private Semaphore semPerros;
    private int capacidad;
    private LinkedList animales;
//    private int cantGatosEspera = 0;
//    private int cantPerrosEspera = 0;

    public Comedor(int id, int capacidad) {
        this.id = id;
        this.semGeneral = new Semaphore(1);
        this.semGatos = new Semaphore(capacidad);
        this.semPerros = new Semaphore(capacidad);
        this.capacidad = capacidad;
        this.animales = new LinkedList();
    }

    public int getId() {
        return id;
    }

    public Semaphore getSem(boolean esGato) {
        Semaphore sem;
        if (esGato) {
            sem = this.semGatos;
        } else {
            sem = this.semPerros;
        }
        return sem;
    }

    public Semaphore getSemGeneral() {
        return semGeneral;
    }

    public Semaphore getSemGatos() {
        return semGatos;
    }

    public Semaphore getSemPerros() {
        return semPerros;
    }

    public int usar(Animal anim, boolean esGato)
            throws InterruptedException {
        //Semaforo de la especie correspondiente
        Semaphore semC;
        int idC = -1;

        if (esGato) {
            semC = semGatos;
        } else {
            semC = semPerros;
        }
        //Intenta bloquear la otra especie
        bloquearAnimal(esGato);
        //Adquiere cuando hay espacio en el comedor
        if (semC.tryAcquire(1, TimeUnit.SECONDS)) {
            animales.add(anim);
            idC = this.id;
        } else {
            //Se cancela porque esta lleno 
            //o se bloqueo su especie
            IO.sColFijoP(anim.getTipo(), anim.getId(),
                    "Cancelo la entrada en: " + this.id);
        }

        return idC;
    }

    public void bloquearAnimal(boolean esGato) throws InterruptedException {
        Semaphore semOtraEspecie;
        int tipo;
        try {
            //Obtiene el semaforo de la OTRA especie
            if (esGato) {
                semOtraEspecie = semPerros;
                tipo = 0;
            } else {
                semOtraEspecie = semGatos;
                tipo = 1;
            }
            if (semOtraEspecie.tryAcquire(this.capacidad)) {
                IO.sColFijoP(6, id, "Bloquea " + IO.getMarcador(tipo));
            }
        } finally {
            semGeneral.release();
        }

    }

    public void salir(Animal anim, boolean esGato)
            throws InterruptedException {
        Semaphore semC, semOtraEspecie;
        //Si su semaforo tiene todos los permisos
        //libera los permisos del otro
        if (esGato) {
            semC = this.semGatos;
            semOtraEspecie = this.semPerros;
        } else {
            semC = this.semPerros;
            semOtraEspecie = this.semGatos;
        }
        try {
            animales.remove(anim);
        } finally {
            semC.release();
            IO.sColFijoP(anim.getTipo(), anim.getId(),
                    "Salio del comedor: " + id);
            try {
                semC.release(this.capacidad);
            } finally {
                //Intenta obtener todos los permisos propios
                if (semC.tryAcquire(this.capacidad)) {
                    //No hay animales en el comedor
                    //Libera a la otra especie
                    desbloquearAnimal(semC, semOtraEspecie);
                }
            }
        }

    }

    public void desbloquearAnimal(Semaphore semC, Semaphore semOtraEspecie)
            throws InterruptedException {
        try {
            IO.sColFijoP(6, id, "Desbloquea ambas especies");
        } finally {
            semC.release(this.capacidad);
        }
    }

}
