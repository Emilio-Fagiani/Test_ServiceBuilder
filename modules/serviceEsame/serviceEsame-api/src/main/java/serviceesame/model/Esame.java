/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Esame service. Represents a row in the &quot;ESAME_Esame&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EsameModel
 * @generated
 */
@ImplementationClassName("serviceesame.model.impl.EsameImpl")
@ProviderType
public interface Esame extends EsameModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>serviceesame.model.impl.EsameImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Esame, Long> ESAME_ID_ACCESSOR =
		new Accessor<Esame, Long>() {

			@Override
			public Long get(Esame esame) {
				return esame.getEsameId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Esame> getTypeClass() {
				return Esame.class;
			}

		};

}