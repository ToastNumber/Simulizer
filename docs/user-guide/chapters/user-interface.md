# User Interface #
The user interface is designed to be as configurable as possible, so that the application can fulfil your needs. Don't need to visualise the internals of the CPU? Just close the CPU visualiser. Need to make the editor a bit bigger? Then resize the editor. It's very simple.

## Menu Bar ##

- **File**: Contains the standard settings found in most applications

    - **New** (`CTRL+N`): Creates a new blank program and opens the Editor Internal Window.

    - **Open** (`CTRL+O`): Opens an existing program and puts it in the Editor.

    - **Save** (`CTRL+S`): Saves the current program to the file loaded in the Editor.

    - **Save as**: Saves the current program to a new file.

    - **Options**: Opens the Options Internal Window.

    - **Exit**: Exits Simulizer.

- **Simulation**:

    - **Assemble and Run** (`F5`): Assembles the SIMP Program and (if it is a valid program) executes it. On an invalid program, hints to what went wrong will be displayed in the Editor.

    - **Pause/Resume Simulation** (`F6`): Pauses or Resumes the currently running/paused SIMP program.

    - **Single Step** (`F7`): On a paused SIMP program, this option completes one cycle of the simulated CPU.

    - **End Simulation** (`F8`): Completely ends the simulation and resets the CPU to it's initial state.

    - **Toggle CPU Pipelining**: Switches between the pipelined and non-pipelined CPU.

    - **Set clock speed**: Opens a dialog box so that you can change at what speed the simulated CPU is running at. Note: this is measured in Hertz, and setting this value too high may have performance issue.

- **Windows**: This contains a sub-menu with all the Internal Windows. This allows you to open and close each Internal Windows more easily.

    - **Close All**: Closes all open Internal Windows

- **Layouts**: Contains a list of all layouts saved in the layouts folder. This allows you to easily switch between different common workspace layouts.

    - **Save Layout**: Saves the current workspace layout to a new file

    - **Refresh Layouts**: Refreshes the list of layouts

- **Help**:

- **Debug**:

## Internal Windows ##
Each pane inside the application is called an Internal Window. This section will give a brief description of what all the different Internal Windows are for, and why you might want to use them.

### CPU Visualisation ###
CPU visualisation is for demonstrating how the MIPS processor fetches, decodes and executes assembly instructions. To use this view, you must set the clock speed to below 2Hz [(see clock speed)](#clockspeed).

![CPU Visualisation executing an R type instruction](segments/cpu-visualisation.png){width=60%}

For more information about the CPU Visualiser other low level visualisation see [Low Level Visualisations](#low-level)

### Editor ###
The editor is the place to write assembly code. The program that is contained in the Editor is the one to be run on the MIPS processor. You will most likely want to keep this window open (as without it, you can't run any assembly code).

![Editor with the binary search assembly code open](segments/editor.png){width=60%}

### High Level Visualisation ###
The High Level Visualisation window is where visualisations from the [annotations](#annotations) are displayed. There purpose is to demonstrate what your SIMP program is actually doing from a more human understandable view.

![High Level Visualiser with Towers of Hanoi open](segments/high-level.png){width=60%}

For more information about the different data structures Simulizer can visualise, see [High Level Visualisation](#high-level)

### Labels ###
$\TODO{write section}$

### Program I/O ###
$\TODO{write section}$

### Memory View ###
$\TODO{write section}$

### Options ###
$\TODO{write section}$

### Pipeline View ###
$\TODO{write section}$

### Registers ###
$\TODO{write section}$

## Layouts ##
Layouts determine the configuration that all the Internal Windows are in. They allow you to quickly switch between different arrangements to optimise your workflow.

### Loading a Layout ###
$\TODO{write section}$

### Saving a Layout ###
If none of the included layouts are up to your standards then why not make your own. Add/Remove and rearrangement the Internal Windows until it is in a configuration that you are happy with. You can then save the layout by clicking Layouts $\to$ Save Layout.

![Saving a Layout](segments/save-layout.png){width=60%}

Enter a name for this new layout. In this case we called the layout `XXX`. Now click the save button and that new layout should show up on the Layouts drop down menu.

## Themes ##

$\TODO{write section}$