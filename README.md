# 3D Renderer

**⚠️ This project is no longer actively maintained. ⚠️**

## Overview

This project is a 3D graphics renderer built from the ground up in Java, utilizing only 2D graphics libraries (AWT). The primary goal was to implement the entire rendering pipeline, including matrix math and perspective projection algorithms, to convert 3D objects into 2D representations on a screen.

## Features Implemented

* **Camera Controls:** Full normalized camera movement and rotation.
* **Perspective Projection:** Algorithm to project 3D scenes onto a 2D plane.
* **3D Objects:** Capability to define and render 3D objects.
* **Triangle Assembly:** Construction of 3D models using triangles.
* **Rasterization:** Process of converting vector graphics into raster images (pixels) for display.

## Screenshots

<p>
  <img src="https://github.com/user-attachments/assets/08db439f-6e51-42c6-bb58-e253086c735f" alt="screenshot 1"  width="400"/>
  <img src="https://github.com/user-attachments/assets/14871d5a-43b8-4f28-9c06-9e63e223d5f2" alt="screenshot 2" width="400"/>
</p>

## Original Next Step

The planned next step for this project was to implement proper Z-buffering for correct depth handling in scenes.

## How to Use

You can download the 'RendererApp.jar' file and run it.

### Controls

* **Camera Position (WASD):**
    * **W:** Move Forward
    * **S:** Move Backward
    * **A:** Move Left
    * **D:** Move Right
* **Camera Altitude:**
    * **Spacebar:** Move Up
    * **Shift:** Move Down
* **Camera Tilt (Arrow Keys):**
    * **Up Arrow:** Tilt Up
    * **Down Arrow:** Tilt Down
    * **Left Arrow:** Tilt Left
    * **Right Arrow:** Tilt Right
