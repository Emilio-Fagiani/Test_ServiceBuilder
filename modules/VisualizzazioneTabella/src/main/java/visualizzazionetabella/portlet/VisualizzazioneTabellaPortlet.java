package visualizzazionetabella.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;
import serviceesame.model.Esame;
import serviceesame.service.EsameLocalServiceUtil;
import visualizzazionetabella.constants.VisualizzazioneTabellaPortletKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Utente
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=VisualizzazioneTabella",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + VisualizzazioneTabellaPortletKeys.VISUALIZZAZIONETABELLA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class VisualizzazioneTabellaPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		// Recuperiamo la lista degli esami aggiunti tramite il metodo addEsame
		List<Esame> esamiList;
		try {
			esamiList = EsameLocalServiceUtil.getEsames(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			throw new PortletException(e);
		}

		// Passiamo i dati alla JSP
		renderRequest.setAttribute("esamiList", esamiList);

		// Reindirizziamo alla JSP per visualizzare i dati degli esami
		super.doView(renderRequest, renderResponse);
	}

}