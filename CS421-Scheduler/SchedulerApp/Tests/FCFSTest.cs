﻿using System;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SchedulerApp.Container_Classes;

namespace Tests
{
    [TestClass]
    public class FCFSTest
    {
        [TestMethod]
        public void ScheduleFCFS()
        {
            Process p1 = new Process
            {
                ProcessId = 1,
                ArrivalTime = 0,
                OriginalArrivalTime = 0,
                CpuTime = new Queue<int>(new[] { 7, 5, 8, 12, 8 }),
                IOTime = new Queue<int>(new[] { 9, 8, 6, 5 })
            };

            Process p2 = new Process
            {
                ProcessId = 2,
                ArrivalTime = 3,
                OriginalArrivalTime = 3,
                CpuTime = new Queue<int>(new[] { 9, 10, 10, 5, 7 }),
                IOTime = new Queue<int>(new[] { 8, 9, 6, 5 })
            };

            Process p3 = new Process
            {
                ProcessId = 3,
                ArrivalTime = 12,
                OriginalArrivalTime = 12,
                CpuTime = new Queue<int>(new[] { 12, 11, 9, 8 }),
                IOTime = new Queue<int>(new[] { 6, 7, 8 })
            };

            Queue<Process> processes = new Queue<Process>(new [] {p1, p2, p3});
            FCFS fcfs = new FCFS {Processes = processes};

            fcfs.Generate();
            Console.WriteLine(fcfs.ToString());
        }
    }
}
