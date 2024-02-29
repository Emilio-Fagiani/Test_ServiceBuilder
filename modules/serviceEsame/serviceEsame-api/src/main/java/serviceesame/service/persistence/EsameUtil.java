/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import serviceesame.model.Esame;

/**
 * The persistence utility for the esame service. This utility wraps <code>serviceesame.service.persistence.impl.EsamePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EsamePersistence
 * @generated
 */
public class EsameUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Esame esame) {
		getPersistence().clearCache(esame);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Esame> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Esame> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Esame> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Esame> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Esame> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Esame update(Esame esame) {
		return getPersistence().update(esame);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Esame update(Esame esame, ServiceContext serviceContext) {
		return getPersistence().update(esame, serviceContext);
	}

	/**
	 * Returns all the esames where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @return the matching esames
	 */
	public static List<Esame> findByNomeEsame(String nomeEsame) {
		return getPersistence().findByNomeEsame(nomeEsame);
	}

	/**
	 * Returns a range of all the esames where nomeEsame = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param nomeEsame the nome esame
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @return the range of matching esames
	 */
	public static List<Esame> findByNomeEsame(
		String nomeEsame, int start, int end) {

		return getPersistence().findByNomeEsame(nomeEsame, start, end);
	}

	/**
	 * Returns an ordered range of all the esames where nomeEsame = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param nomeEsame the nome esame
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching esames
	 */
	public static List<Esame> findByNomeEsame(
		String nomeEsame, int start, int end,
		OrderByComparator<Esame> orderByComparator) {

		return getPersistence().findByNomeEsame(
			nomeEsame, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the esames where nomeEsame = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param nomeEsame the nome esame
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching esames
	 */
	public static List<Esame> findByNomeEsame(
		String nomeEsame, int start, int end,
		OrderByComparator<Esame> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNomeEsame(
			nomeEsame, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public static Esame findByNomeEsame_First(
			String nomeEsame, OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByNomeEsame_First(
			nomeEsame, orderByComparator);
	}

	/**
	 * Returns the first esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public static Esame fetchByNomeEsame_First(
		String nomeEsame, OrderByComparator<Esame> orderByComparator) {

		return getPersistence().fetchByNomeEsame_First(
			nomeEsame, orderByComparator);
	}

	/**
	 * Returns the last esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public static Esame findByNomeEsame_Last(
			String nomeEsame, OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByNomeEsame_Last(
			nomeEsame, orderByComparator);
	}

	/**
	 * Returns the last esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public static Esame fetchByNomeEsame_Last(
		String nomeEsame, OrderByComparator<Esame> orderByComparator) {

		return getPersistence().fetchByNomeEsame_Last(
			nomeEsame, orderByComparator);
	}

	/**
	 * Returns the esames before and after the current esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param esameId the primary key of the current esame
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public static Esame[] findByNomeEsame_PrevAndNext(
			long esameId, String nomeEsame,
			OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByNomeEsame_PrevAndNext(
			esameId, nomeEsame, orderByComparator);
	}

	/**
	 * Removes all the esames where nomeEsame = &#63; from the database.
	 *
	 * @param nomeEsame the nome esame
	 */
	public static void removeByNomeEsame(String nomeEsame) {
		getPersistence().removeByNomeEsame(nomeEsame);
	}

	/**
	 * Returns the number of esames where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @return the number of matching esames
	 */
	public static int countByNomeEsame(String nomeEsame) {
		return getPersistence().countByNomeEsame(nomeEsame);
	}

	/**
	 * Returns all the esames where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @return the matching esames
	 */
	public static List<Esame> findByDataEsame(Date dataEsame) {
		return getPersistence().findByDataEsame(dataEsame);
	}

	/**
	 * Returns a range of all the esames where dataEsame = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param dataEsame the data esame
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @return the range of matching esames
	 */
	public static List<Esame> findByDataEsame(
		Date dataEsame, int start, int end) {

		return getPersistence().findByDataEsame(dataEsame, start, end);
	}

	/**
	 * Returns an ordered range of all the esames where dataEsame = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param dataEsame the data esame
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching esames
	 */
	public static List<Esame> findByDataEsame(
		Date dataEsame, int start, int end,
		OrderByComparator<Esame> orderByComparator) {

		return getPersistence().findByDataEsame(
			dataEsame, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the esames where dataEsame = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param dataEsame the data esame
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching esames
	 */
	public static List<Esame> findByDataEsame(
		Date dataEsame, int start, int end,
		OrderByComparator<Esame> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDataEsame(
			dataEsame, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public static Esame findByDataEsame_First(
			Date dataEsame, OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByDataEsame_First(
			dataEsame, orderByComparator);
	}

	/**
	 * Returns the first esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public static Esame fetchByDataEsame_First(
		Date dataEsame, OrderByComparator<Esame> orderByComparator) {

		return getPersistence().fetchByDataEsame_First(
			dataEsame, orderByComparator);
	}

	/**
	 * Returns the last esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public static Esame findByDataEsame_Last(
			Date dataEsame, OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByDataEsame_Last(
			dataEsame, orderByComparator);
	}

	/**
	 * Returns the last esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public static Esame fetchByDataEsame_Last(
		Date dataEsame, OrderByComparator<Esame> orderByComparator) {

		return getPersistence().fetchByDataEsame_Last(
			dataEsame, orderByComparator);
	}

	/**
	 * Returns the esames before and after the current esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param esameId the primary key of the current esame
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public static Esame[] findByDataEsame_PrevAndNext(
			long esameId, Date dataEsame,
			OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByDataEsame_PrevAndNext(
			esameId, dataEsame, orderByComparator);
	}

	/**
	 * Removes all the esames where dataEsame = &#63; from the database.
	 *
	 * @param dataEsame the data esame
	 */
	public static void removeByDataEsame(Date dataEsame) {
		getPersistence().removeByDataEsame(dataEsame);
	}

	/**
	 * Returns the number of esames where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @return the number of matching esames
	 */
	public static int countByDataEsame(Date dataEsame) {
		return getPersistence().countByDataEsame(dataEsame);
	}

	/**
	 * Returns all the esames where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @return the matching esames
	 */
	public static List<Esame> findByNomeInsegnante(String nomeInsegnante) {
		return getPersistence().findByNomeInsegnante(nomeInsegnante);
	}

	/**
	 * Returns a range of all the esames where nomeInsegnante = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @return the range of matching esames
	 */
	public static List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end) {

		return getPersistence().findByNomeInsegnante(
			nomeInsegnante, start, end);
	}

	/**
	 * Returns an ordered range of all the esames where nomeInsegnante = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching esames
	 */
	public static List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end,
		OrderByComparator<Esame> orderByComparator) {

		return getPersistence().findByNomeInsegnante(
			nomeInsegnante, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the esames where nomeInsegnante = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching esames
	 */
	public static List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end,
		OrderByComparator<Esame> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNomeInsegnante(
			nomeInsegnante, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public static Esame findByNomeInsegnante_First(
			String nomeInsegnante, OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByNomeInsegnante_First(
			nomeInsegnante, orderByComparator);
	}

	/**
	 * Returns the first esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public static Esame fetchByNomeInsegnante_First(
		String nomeInsegnante, OrderByComparator<Esame> orderByComparator) {

		return getPersistence().fetchByNomeInsegnante_First(
			nomeInsegnante, orderByComparator);
	}

	/**
	 * Returns the last esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public static Esame findByNomeInsegnante_Last(
			String nomeInsegnante, OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByNomeInsegnante_Last(
			nomeInsegnante, orderByComparator);
	}

	/**
	 * Returns the last esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public static Esame fetchByNomeInsegnante_Last(
		String nomeInsegnante, OrderByComparator<Esame> orderByComparator) {

		return getPersistence().fetchByNomeInsegnante_Last(
			nomeInsegnante, orderByComparator);
	}

	/**
	 * Returns the esames before and after the current esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param esameId the primary key of the current esame
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public static Esame[] findByNomeInsegnante_PrevAndNext(
			long esameId, String nomeInsegnante,
			OrderByComparator<Esame> orderByComparator)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByNomeInsegnante_PrevAndNext(
			esameId, nomeInsegnante, orderByComparator);
	}

	/**
	 * Removes all the esames where nomeInsegnante = &#63; from the database.
	 *
	 * @param nomeInsegnante the nome insegnante
	 */
	public static void removeByNomeInsegnante(String nomeInsegnante) {
		getPersistence().removeByNomeInsegnante(nomeInsegnante);
	}

	/**
	 * Returns the number of esames where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @return the number of matching esames
	 */
	public static int countByNomeInsegnante(String nomeInsegnante) {
		return getPersistence().countByNomeInsegnante(nomeInsegnante);
	}

	/**
	 * Caches the esame in the entity cache if it is enabled.
	 *
	 * @param esame the esame
	 */
	public static void cacheResult(Esame esame) {
		getPersistence().cacheResult(esame);
	}

	/**
	 * Caches the esames in the entity cache if it is enabled.
	 *
	 * @param esames the esames
	 */
	public static void cacheResult(List<Esame> esames) {
		getPersistence().cacheResult(esames);
	}

	/**
	 * Creates a new esame with the primary key. Does not add the esame to the database.
	 *
	 * @param esameId the primary key for the new esame
	 * @return the new esame
	 */
	public static Esame create(long esameId) {
		return getPersistence().create(esameId);
	}

	/**
	 * Removes the esame with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame that was removed
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public static Esame remove(long esameId)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().remove(esameId);
	}

	public static Esame updateImpl(Esame esame) {
		return getPersistence().updateImpl(esame);
	}

	/**
	 * Returns the esame with the primary key or throws a <code>NoSuchEsameException</code> if it could not be found.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public static Esame findByPrimaryKey(long esameId)
		throws serviceesame.exception.NoSuchEsameException {

		return getPersistence().findByPrimaryKey(esameId);
	}

	/**
	 * Returns the esame with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame, or <code>null</code> if a esame with the primary key could not be found
	 */
	public static Esame fetchByPrimaryKey(long esameId) {
		return getPersistence().fetchByPrimaryKey(esameId);
	}

	/**
	 * Returns all the esames.
	 *
	 * @return the esames
	 */
	public static List<Esame> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the esames.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @return the range of esames
	 */
	public static List<Esame> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the esames.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of esames
	 */
	public static List<Esame> findAll(
		int start, int end, OrderByComparator<Esame> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the esames.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of esames
	 * @param end the upper bound of the range of esames (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of esames
	 */
	public static List<Esame> findAll(
		int start, int end, OrderByComparator<Esame> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the esames from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of esames.
	 *
	 * @return the number of esames
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EsamePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EsamePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EsamePersistence _persistence;

}