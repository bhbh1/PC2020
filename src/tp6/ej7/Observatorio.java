/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author b h
 */
public class Observatorio {

    private int cantMax = 0;
    private int cantOcup = 0;
    private int espVis = 0;
    private int espMan = 0;
    private ReentrantLock lockEntrar = new ReentrantLock();
    private Condition hayVis;
    private Condition hayMant;
    private Condition hayInv;
}
