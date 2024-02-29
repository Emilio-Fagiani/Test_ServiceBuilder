package fileproperties.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PropsUtil;

import fileproperties.constants.FilePropertiesPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;

/**
 * @author Utente
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FileProperties",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FilePropertiesPortletKeys.FILEPROPERTIES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FilePropertiesPortlet extends MVCPortlet {



	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String mail = PropsUtil.get("my.custom.mail");
		String phone = PropsUtil.get("my.custom.phone");
		System.out.println(mail + phone);

		renderRequest.setAttribute("mail", mail);
		renderRequest.setAttribute("phone", phone);

		super.doView(renderRequest, renderResponse);
	}

/*	@Override
	protected boolean callResourceMethod(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {



		return super.callResourceMethod(resourceRequest, resourceResponse);
	}*/

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String img = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcreate.vista.com%2Fvectors%2Fhtml-coding%2F&psig=AOvVaw2EtZJAjuEAfFZNk09tdRUQ&ust=1708183911310000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCLjp3IuXsIQDFQAAAAAdAAAAABAI";
		String imgg = PropsUtil.get(img);

		resourceRequest.setAttribute("img", imgg);
		super.serveResource(resourceRequest, resourceResponse);
	}
}