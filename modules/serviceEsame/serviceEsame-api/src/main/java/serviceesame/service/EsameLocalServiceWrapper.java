/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EsameLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EsameLocalService
 * @generated
 */
public class EsameLocalServiceWrapper
	implements EsameLocalService, ServiceWrapper<EsameLocalService> {

	public EsameLocalServiceWrapper() {
		this(null);
	}

	public EsameLocalServiceWrapper(EsameLocalService esameLocalService) {
		_esameLocalService = esameLocalService;
	}

	/**
	 * Adds the esame to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EsameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param esame the esame
	 * @return the esame that was added
	 */
	@Override
	public serviceesame.model.Esame addEsame(serviceesame.model.Esame esame) {
		return _esameLocalService.addEsame(esame);
	}

	/**
	 * Creates a new esame with the primary key. Does not add the esame to the database.
	 *
	 * @param esameId the primary key for the new esame
	 * @return the new esame
	 */
	@Override
	public serviceesame.model.Esame createEsame(long esameId) {
		return _esameLocalService.createEsame(esameId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _esameLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the esame from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EsameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param esame the esame
	 * @return the esame that was removed
	 */
	@Override
	public serviceesame.model.Esame deleteEsame(
		serviceesame.model.Esame esame) {

		return _esameLocalService.deleteEsame(esame);
	}

	/**
	 * Deletes the esame with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EsameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame that was removed
	 * @throws PortalException if a esame with the primary key could not be found
	 */
	@Override
	public serviceesame.model.Esame deleteEsame(long esameId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _esameLocalService.deleteEsame(esameId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _esameLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _esameLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _esameLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esameLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _esameLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>serviceesame.model.impl.EsameModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _esameLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>serviceesame.model.impl.EsameModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _esameLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _esameLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _esameLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public serviceesame.model.Esame fetchEsame(long esameId) {
		return _esameLocalService.fetchEsame(esameId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _esameLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the esame with the primary key.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame
	 * @throws PortalException if a esame with the primary key could not be found
	 */
	@Override
	public serviceesame.model.Esame getEsame(long esameId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _esameLocalService.getEsame(esameId);
	}

	/**
	 * Returns a range of all the esames.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>serviceesame.model.impl.EsameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @return the range of esames
	 */
	@Override
	public java.util.List<serviceesame.model.Esame> getEsames(
		int start, int end) {

		return _esameLocalService.getEsames(start, end);
	}

	/**
	 * Returns the number of esames.
	 *
	 * @return the number of esames
	 */
	@Override
	public int getEsamesCount() {
		return _esameLocalService.getEsamesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _esameLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _esameLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _esameLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the esame in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EsameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param esame the esame
	 * @return the esame that was updated
	 */
	@Override
	public serviceesame.model.Esame updateEsame(
		serviceesame.model.Esame esame) {

		return _esameLocalService.updateEsame(esame);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _esameLocalService.getBasePersistence();
	}

	@Override
	public EsameLocalService getWrappedService() {
		return _esameLocalService;
	}

	@Override
	public void setWrappedService(EsameLocalService esameLocalService) {
		_esameLocalService = esameLocalService;
	}

	private EsameLocalService _esameLocalService;

}