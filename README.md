# Quantum Car Factory

Simple Java project that implements a car factory using interchangeable engines.

## Overview

The factory can:

- Create a car by engine type.
- Replace the engine of an existing car.

Supported engines:

- `GasEngine`
- `ElectricEngine`
- `HybridEngine` (uses electric below 50 km/h, gas at 50 km/h and above)

## Car Operations

- `start()` -> starts at speed 0
- `stop()` -> allowed only when speed is 0
- `accelerate()` -> +20 km/h up to 200 km/h
- `brake()` -> -20 km/h down to 0

When car speed changes, the car updates the installed engine speed.

## Project Structure

- `Car` -> main car behavior
- `IEngine` -> engine interface
- `GasEngine`, `ElectricEngine`, `HybridEngine` -> engine implementations
- `CarFactory` -> create/install engines
- `EngineType` -> engine options
- `Main` -> demo for all scenarios

## Demo Scenarios in Main

The `Main` class demonstrates:

- Gas car flow
- Electric car flow
- Hybrid switching behavior
- Safety check (cannot stop while moving)
- Max speed cap at 200 km/h
- Engine replacement

These scenarios match the output in `output.txt`.

## Run

Requirements:

- Java 21
- Maven

Build:

```bash
mvn compile
```

Run:

```bash
java -cp target/classes Main
```

## Output

```text
=== 1. GAS CAR ===
CarFactory Installed: GAS engine.
Gas Engine Started.
Car Started at 0 km/h.
Gas Engine Speed set to: 20 km/h
Car Accelerated to: 20 km/h
Gas Engine Speed set to: 40 km/h
Car Accelerated to: 40 km/h
Gas Engine Speed set to: 60 km/h
Car Accelerated to: 60 km/h
Gas Engine Speed set to: 40 km/h
Car Braked to: 40 km/h
Gas Engine Speed set to: 20 km/h
Car Braked to: 20 km/h
Gas Engine Speed set to: 0 km/h
Car Braked to: 0 km/h
Gas Engine Stopped.
Car Stopped.
=== 2. ELECTRIC CAR ===
CarFactory Installed: ELECTRIC engine.
Electric Engine Started.
Car Started at 0 km/h.
Electric Engine Speed set to: 20 km/h
Car Accelerated to: 20 km/h
Electric Engine Speed set to: 40 km/h
Car Accelerated to: 40 km/h
Electric Engine Speed set to: 20 km/h
Car Braked to: 20 km/h
Electric Engine Speed set to: 0 km/h
Car Braked to: 0 km/h
Electric Engine Stopped.
Car Stopped.
=== 3. HYBRID CAR ===
CarFactory Installed: HYBRID engine.
Electric Engine Started.
Hybrid Engine Started in Electric mode.
Car Started at 0 km/h.
Electric Engine Speed set to: 20 km/h
Car Accelerated to: 20 km/h
Electric Engine Speed set to: 40 km/h
Car Accelerated to: 40 km/h
Electric Engine Stopped.
Gas Engine Started.
Hybrid Engine Switched to Gas engine at 60 km/h
Gas Engine Speed set to: 60 km/h
Car Accelerated to: 60 km/h
Gas Engine Speed set to: 80 km/h
Car Accelerated to: 80 km/h
Gas Engine Speed set to: 60 km/h
Car Braked to: 60 km/h
Gas Engine Stopped.
Electric Engine Started.
Hybrid Engine Switched to Electric engine at 40 km/h
Electric Engine Speed set to: 40 km/h
Car Braked to: 40 km/h
Electric Engine Speed set to: 20 km/h
Car Braked to: 20 km/h
Electric Engine Speed set to: 0 km/h
Car Braked to: 0 km/h
Electric Engine Stopped.
Hybrid Engine Stopped.
Car Stopped.
=== 4. SAFETY CHECKS ===
CarFactory Installed: GAS engine.
Gas Engine Started.
Car Started at 0 km/h.
Gas Engine Speed set to: 20 km/h
Car Accelerated to: 20 km/h
Car Cannot stop while moving (20 km/h). Brake to 0 first.
Gas Engine Speed set to: 0 km/h
Car Braked to: 0 km/h
Gas Engine Stopped.
Car Stopped.
=== 5. MAX SPEED TEST ===
CarFactory Installed: GAS engine.
Gas Engine Started.
Car Started at 0 km/h.
Gas Engine Speed set to: 20 km/h
Car Accelerated to: 20 km/h
Gas Engine Speed set to: 40 km/h
Car Accelerated to: 40 km/h
Gas Engine Speed set to: 60 km/h
Car Accelerated to: 60 km/h
Gas Engine Speed set to: 80 km/h
Car Accelerated to: 80 km/h
Gas Engine Speed set to: 100 km/h
Car Accelerated to: 100 km/h
Gas Engine Speed set to: 120 km/h
Car Accelerated to: 120 km/h
Gas Engine Speed set to: 140 km/h
Car Accelerated to: 140 km/h
Gas Engine Speed set to: 160 km/h
Car Accelerated to: 160 km/h
Gas Engine Speed set to: 180 km/h
Car Accelerated to: 180 km/h
Gas Engine Speed set to: 200 km/h
Car Accelerated to: 200 km/h
Car Already at max speed (200 km/h).
Car Already at max speed (200 km/h).
Car Final speed: 200 km/h
=== 6. ENGINE REPLACEMENT ===
CarFactory Installed: GAS engine.
Gas Engine Started.
Car Started at 0 km/h.
Gas Engine Speed set to: 20 km/h
Car Accelerated to: 20 km/h
Gas Engine Speed set to: 0 km/h
Car Braked to: 0 km/h
Gas Engine Stopped.
Car Stopped.
CarFactory Installed: HYBRID engine.
Electric Engine Started.
Hybrid Engine Started in Electric mode.
Car Started at 0 km/h.
Electric Engine Speed set to: 20 km/h
Car Accelerated to: 20 km/h
Electric Engine Speed set to: 40 km/h
Car Accelerated to: 40 km/h
Electric Engine Stopped.
Gas Engine Started.
Hybrid Engine Switched to Gas engine at 60 km/h
Gas Engine Speed set to: 60 km/h
Car Accelerated to: 60 km/h
Gas Engine Stopped.
Electric Engine Started.
Hybrid Engine Switched to Electric engine at 40 km/h
Electric Engine Speed set to: 40 km/h
Car Braked to: 40 km/h
Electric Engine Speed set to: 20 km/h
Car Braked to: 20 km/h
Electric Engine Speed set to: 0 km/h
Car Braked to: 0 km/h
Electric Engine Stopped.
Hybrid Engine Stopped.
Car Stopped.
```
