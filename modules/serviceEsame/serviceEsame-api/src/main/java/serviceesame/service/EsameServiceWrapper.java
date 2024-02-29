/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EsameService}.
 *
 * @author Brian Wing Shun Chan
 * @see EsameService
 * @generated
 */
public class EsameServiceWrapper
	implements EsameService, ServiceWrapper<EsameService> {

	public EsameServiceWrapper() {
		this(null);
	}

	public EsameServiceWrapper(EsameService esameService) {
		_esameService = esameService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _esameService.getOSGiServiceIdentifier();
	}

	@Override
	public EsameService getWrappedService() {
		return _esameService;
	}

	@Override
	public void setWrappedService(EsameService esameService) {
		_esameService = esameService;
	}

	private EsameService _esameService;

}