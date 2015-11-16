package scrollsexplorer.simpleclient.scenegraph;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Group;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

import nif.NifJ3dVisRoot;
import nif.NifToJ3d;
import nif.gui.util.ControllerInvokerThread;
import nif.j3d.J3dNiAVObject;
import scrollsexplorer.GameConfig;
import utils.source.MediaSources;

public class LoadScreen extends BranchGroup
{
	private GameConfig gameConfig;

	private MediaSources mediaSources;

	private BranchGroup currentLoadScreenBG;

	private TransformGroup currentLoadScreenTG;

	public LoadScreen(GameConfig gameConfig, MediaSources mediaSources)
	{
		this.gameConfig = gameConfig;
		this.mediaSources = mediaSources;
		this.setCapability(Group.ALLOW_CHILDREN_WRITE);
		this.setCapability(Group.ALLOW_CHILDREN_EXTEND);

	}

	public void setShowLoadScreen(boolean show)
	{
		if (!show)
		{
			if (currentLoadScreenBG != null)
			{
				currentLoadScreenBG.detach();
				currentLoadScreenBG = null;
			}
		}
		else
		{
			currentLoadScreenBG = new BranchGroup();
			currentLoadScreenBG.setCapability(BranchGroup.ALLOW_DETACH);

			currentLoadScreenTG = new TransformGroup();

			Vector3f v = new Vector3f();
			v.z = -4;

			Quat4f q = new Quat4f(0, 0, 0, 1);

			Transform3D t = new Transform3D();
			t.set(q, v, 1f);

			currentLoadScreenTG.setTransform(t);

			currentLoadScreenBG.addChild(currentLoadScreenTG);

			if (!loadScene(gameConfig.loadScreen))

				//TODO: note not on strucutre behavior, trouble?
				addChild(currentLoadScreenBG);
		}

	}

	private boolean loadScene(String nifFile)
	{
		if (mediaSources.getMeshSource().nifFileExists(nifFile))
		{
			NifJ3dVisRoot nif = NifToJ3d.loadShapes(nifFile, mediaSources.getMeshSource(), mediaSources.getTextureSource());
			if (nif != null)
			{
				J3dNiAVObject j3dNiAVObject = nif.getVisualRoot();

				if (j3dNiAVObject != null)
				{

					if (nif.getVisualRoot().getJ3dNiControllerManager() != null)
					{
						//note self cleaning uping
						ControllerInvokerThread controllerInvokerThread = new ControllerInvokerThread(nif.getVisualRoot().getName(), nif
								.getVisualRoot().getJ3dNiControllerManager(), null);
						controllerInvokerThread.start();
					}
					return true;
				}
			}
		}

		return false;
	}
}
