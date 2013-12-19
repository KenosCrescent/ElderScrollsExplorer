ElderScrollsExplorer

====

 

Elder Scrolls Explorer is a pure java open source engine to allow you to walk around in the Elder Scrolls games.  

 

To use this code you must have copies of the .esm and .bsa files from one (or more) of the following games:  

Oblivion  

Fallout 3  

Fallout New Vegas  

Skyrim  

 

If you don't have those game files this code will not do much for you (except be fun to read).

 

This project pulls together many other projects based around building a game engine on java3d and JBullet that imports the assets of the Bethesda games built on the Gamebryo engine.

 

I need these assets and engine components for another game project (not open source).

 

This particular project is used as a test bed but also proves the following:

 

The BSA (nif, dds, sound) and esm (game world) file loaders are working

 

The Java3d scene graphs created from them are working, including:

-Skin/bone animations  

-Regular interpolator animations  

-DDS texture loading (and an enahncement to java3d to allow direct compressed textures)  

-Sound files  

-Appearance data  

-Various LOD strategies (billboards, switches, model swap outs)  

 

but not including  

-Shaders  

-Particle Systems  

 

 

The JBullet physics simualtion created from them is working  

Including  

-Animations of kinematic features  

-Character controllers  

-Skyrim compressed meshes  

 

 

Currently you can activate doors and containers  

Doors will teleport you to other cells if appropriate  

 

 

 

It does not have:  

An avatar for your charater  

AI of any sort for NPCs/CREAs 

Load screens  

A decent interface  

An inventory or any game play elements  

DLC content is not loaded  

BSA loading priority  

Sounds running properly  

Script based objects will probably always appear  

Simple animations run run on things which can be absurb looking  

Skyrim skinning is crazy  

Shadows  

Game time  

A decent sky  

Proper water surface  

The LOD system for Skyrim and Fallout make it load too many cells so performance is always poor (15fps)  

 

 

 

To build the code you must:  

 

Download eclipse IDE http://www.eclipse.org/downloads/  

Unzip it (not into program files)  

install JDK 1.6 into eclipse http://www.oracle.com/technetwork/java/javase/downloads/index.html  

Download all the projects here  

(yes there are a lot fo them, sorry, use the zip button at the root of each)  

external_jars  

tools  

3DTools  

  

BSAManager  

ESMLoader  

  

jnif  

jnifj3d  

jnifjbullet  

  

  

ElderScrollsUtils  

esmj3d  

esmj3dfo3  

esmj3dtes4  

esmj3dtes5  

ElderScrollsExplorer  

 

Import each of them into Eclipse as a project  

You may have to fix up dependancies at this point(not sure)  

 

Once done, run the main in ElderScrollsExplorer  

scrollsecplorer.ScrollsExplorer  

With VM arguments  

-Xms512M -Xmx1200M  

 

if you get Unsupported major.minor version 51.0  

You need to project -> properties -> configure workspace settings -> Compiler compliance level:-> 1.6  

If you get a texture mip map exception change the run configuration -> classpath->ElderScrollsExplorer->edit -> only include exported entries  

Once it's running you must set your game folders (the ones containing the esm and bsa files) using File menu  

 

Then you should be good to go.

 

 

 

 

 

 


 
