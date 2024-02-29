package gestioneesame.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import gestioneesame.constants.GestioneEsamePortletKeys;
import org.osgi.service.component.annotations.Component;
import serviceesame.model.Esame;
import serviceesame.service.EsameLocalServiceUtil;

import javax.portlet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Utente
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GestioneEsame",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GestioneEsamePortletKeys.GESTIONEESAME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GestioneEsamePortlet extends MVCPortlet {

	@ProcessAction(name = "addEsame")
	public void addExam(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

			ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String insegnante = td.getUser().getFullName();

			int esameCount = EsameLocalServiceUtil.getEsamesCount();
			Esame esame = EsameLocalServiceUtil.createEsame(esameCount + 1);

			String nome = ParamUtil.getString(actionRequest, "nomeEsame");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date data = ParamUtil.getDate(actionRequest, "data", dateFormat);


			esame.setNomeEsame(nome);
			esame.setDataEsame(data);
			esame.setNomeInsegnante(insegnante);

			// Utilizzare il servizio EsameLocalService per inserire il nuovo esame nel sist
			EsameLocalServiceUtil.addEsame(esame);
			System.out.println(esame);
			System.out.println(nome);
	}
}