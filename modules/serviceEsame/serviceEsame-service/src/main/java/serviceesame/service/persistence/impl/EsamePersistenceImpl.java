/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import serviceesame.exception.NoSuchEsameException;

import serviceesame.model.Esame;
import serviceesame.model.EsameTable;
import serviceesame.model.impl.EsameImpl;
import serviceesame.model.impl.EsameModelImpl;

import serviceesame.service.persistence.EsamePersistence;
import serviceesame.service.persistence.EsameUtil;
import serviceesame.service.persistence.impl.constants.ESAMEPersistenceConstants;

/**
 * The persistence implementation for the esame service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EsamePersistence.class)
public class EsamePersistenceImpl
	extends BasePersistenceImpl<Esame> implements EsamePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EsameUtil</code> to access the esame persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EsameImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByNomeEsame;
	private FinderPath _finderPathWithoutPaginationFindByNomeEsame;
	private FinderPath _finderPathCountByNomeEsame;

	/**
	 * Returns all the esames where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @return the matching esames
	 */
	@Override
	public List<Esame> findByNomeEsame(String nomeEsame) {
		return findByNomeEsame(
			nomeEsame, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Esame> findByNomeEsame(String nomeEsame, int start, int end) {
		return findByNomeEsame(nomeEsame, start, end, null);
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
	@Override
	public List<Esame> findByNomeEsame(
		String nomeEsame, int start, int end,
		OrderByComparator<Esame> orderByComparator) {

		return findByNomeEsame(nomeEsame, start, end, orderByComparator, true);
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
	@Override
	public List<Esame> findByNomeEsame(
		String nomeEsame, int start, int end,
		OrderByComparator<Esame> orderByComparator, boolean useFinderCache) {

		nomeEsame = Objects.toString(nomeEsame, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNomeEsame;
				finderArgs = new Object[] {nomeEsame};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNomeEsame;
			finderArgs = new Object[] {
				nomeEsame, start, end, orderByComparator
			};
		}

		List<Esame> list = null;

		if (useFinderCache) {
			list = (List<Esame>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Esame esame : list) {
					if (!nomeEsame.equals(esame.getNomeEsame())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ESAME_WHERE);

			boolean bindNomeEsame = false;

			if (nomeEsame.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMEESAME_NOMEESAME_3);
			}
			else {
				bindNomeEsame = true;

				sb.append(_FINDER_COLUMN_NOMEESAME_NOMEESAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EsameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeEsame) {
					queryPos.add(nomeEsame);
				}

				list = (List<Esame>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	@Override
	public Esame findByNomeEsame_First(
			String nomeEsame, OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		Esame esame = fetchByNomeEsame_First(nomeEsame, orderByComparator);

		if (esame != null) {
			return esame;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeEsame=");
		sb.append(nomeEsame);

		sb.append("}");

		throw new NoSuchEsameException(sb.toString());
	}

	/**
	 * Returns the first esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	@Override
	public Esame fetchByNomeEsame_First(
		String nomeEsame, OrderByComparator<Esame> orderByComparator) {

		List<Esame> list = findByNomeEsame(nomeEsame, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	@Override
	public Esame findByNomeEsame_Last(
			String nomeEsame, OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		Esame esame = fetchByNomeEsame_Last(nomeEsame, orderByComparator);

		if (esame != null) {
			return esame;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeEsame=");
		sb.append(nomeEsame);

		sb.append("}");

		throw new NoSuchEsameException(sb.toString());
	}

	/**
	 * Returns the last esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	@Override
	public Esame fetchByNomeEsame_Last(
		String nomeEsame, OrderByComparator<Esame> orderByComparator) {

		int count = countByNomeEsame(nomeEsame);

		if (count == 0) {
			return null;
		}

		List<Esame> list = findByNomeEsame(
			nomeEsame, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Esame[] findByNomeEsame_PrevAndNext(
			long esameId, String nomeEsame,
			OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		nomeEsame = Objects.toString(nomeEsame, "");

		Esame esame = findByPrimaryKey(esameId);

		Session session = null;

		try {
			session = openSession();

			Esame[] array = new EsameImpl[3];

			array[0] = getByNomeEsame_PrevAndNext(
				session, esame, nomeEsame, orderByComparator, true);

			array[1] = esame;

			array[2] = getByNomeEsame_PrevAndNext(
				session, esame, nomeEsame, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Esame getByNomeEsame_PrevAndNext(
		Session session, Esame esame, String nomeEsame,
		OrderByComparator<Esame> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ESAME_WHERE);

		boolean bindNomeEsame = false;

		if (nomeEsame.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOMEESAME_NOMEESAME_3);
		}
		else {
			bindNomeEsame = true;

			sb.append(_FINDER_COLUMN_NOMEESAME_NOMEESAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EsameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNomeEsame) {
			queryPos.add(nomeEsame);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(esame)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Esame> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the esames where nomeEsame = &#63; from the database.
	 *
	 * @param nomeEsame the nome esame
	 */
	@Override
	public void removeByNomeEsame(String nomeEsame) {
		for (Esame esame :
				findByNomeEsame(
					nomeEsame, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(esame);
		}
	}

	/**
	 * Returns the number of esames where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @return the number of matching esames
	 */
	@Override
	public int countByNomeEsame(String nomeEsame) {
		nomeEsame = Objects.toString(nomeEsame, "");

		FinderPath finderPath = _finderPathCountByNomeEsame;

		Object[] finderArgs = new Object[] {nomeEsame};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ESAME_WHERE);

			boolean bindNomeEsame = false;

			if (nomeEsame.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMEESAME_NOMEESAME_3);
			}
			else {
				bindNomeEsame = true;

				sb.append(_FINDER_COLUMN_NOMEESAME_NOMEESAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeEsame) {
					queryPos.add(nomeEsame);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NOMEESAME_NOMEESAME_2 =
		"esame.nomeEsame = ?";

	private static final String _FINDER_COLUMN_NOMEESAME_NOMEESAME_3 =
		"(esame.nomeEsame IS NULL OR esame.nomeEsame = '')";

	private FinderPath _finderPathWithPaginationFindByDataEsame;
	private FinderPath _finderPathWithoutPaginationFindByDataEsame;
	private FinderPath _finderPathCountByDataEsame;

	/**
	 * Returns all the esames where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @return the matching esames
	 */
	@Override
	public List<Esame> findByDataEsame(Date dataEsame) {
		return findByDataEsame(
			dataEsame, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Esame> findByDataEsame(Date dataEsame, int start, int end) {
		return findByDataEsame(dataEsame, start, end, null);
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
	@Override
	public List<Esame> findByDataEsame(
		Date dataEsame, int start, int end,
		OrderByComparator<Esame> orderByComparator) {

		return findByDataEsame(dataEsame, start, end, orderByComparator, true);
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
	@Override
	public List<Esame> findByDataEsame(
		Date dataEsame, int start, int end,
		OrderByComparator<Esame> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataEsame;
				finderArgs = new Object[] {_getTime(dataEsame)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataEsame;
			finderArgs = new Object[] {
				_getTime(dataEsame), start, end, orderByComparator
			};
		}

		List<Esame> list = null;

		if (useFinderCache) {
			list = (List<Esame>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Esame esame : list) {
					if (!Objects.equals(dataEsame, esame.getDataEsame())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ESAME_WHERE);

			boolean bindDataEsame = false;

			if (dataEsame == null) {
				sb.append(_FINDER_COLUMN_DATAESAME_DATAESAME_1);
			}
			else {
				bindDataEsame = true;

				sb.append(_FINDER_COLUMN_DATAESAME_DATAESAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EsameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataEsame) {
					queryPos.add(new Timestamp(dataEsame.getTime()));
				}

				list = (List<Esame>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	@Override
	public Esame findByDataEsame_First(
			Date dataEsame, OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		Esame esame = fetchByDataEsame_First(dataEsame, orderByComparator);

		if (esame != null) {
			return esame;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataEsame=");
		sb.append(dataEsame);

		sb.append("}");

		throw new NoSuchEsameException(sb.toString());
	}

	/**
	 * Returns the first esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	@Override
	public Esame fetchByDataEsame_First(
		Date dataEsame, OrderByComparator<Esame> orderByComparator) {

		List<Esame> list = findByDataEsame(dataEsame, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	@Override
	public Esame findByDataEsame_Last(
			Date dataEsame, OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		Esame esame = fetchByDataEsame_Last(dataEsame, orderByComparator);

		if (esame != null) {
			return esame;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataEsame=");
		sb.append(dataEsame);

		sb.append("}");

		throw new NoSuchEsameException(sb.toString());
	}

	/**
	 * Returns the last esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	@Override
	public Esame fetchByDataEsame_Last(
		Date dataEsame, OrderByComparator<Esame> orderByComparator) {

		int count = countByDataEsame(dataEsame);

		if (count == 0) {
			return null;
		}

		List<Esame> list = findByDataEsame(
			dataEsame, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Esame[] findByDataEsame_PrevAndNext(
			long esameId, Date dataEsame,
			OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		Esame esame = findByPrimaryKey(esameId);

		Session session = null;

		try {
			session = openSession();

			Esame[] array = new EsameImpl[3];

			array[0] = getByDataEsame_PrevAndNext(
				session, esame, dataEsame, orderByComparator, true);

			array[1] = esame;

			array[2] = getByDataEsame_PrevAndNext(
				session, esame, dataEsame, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Esame getByDataEsame_PrevAndNext(
		Session session, Esame esame, Date dataEsame,
		OrderByComparator<Esame> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ESAME_WHERE);

		boolean bindDataEsame = false;

		if (dataEsame == null) {
			sb.append(_FINDER_COLUMN_DATAESAME_DATAESAME_1);
		}
		else {
			bindDataEsame = true;

			sb.append(_FINDER_COLUMN_DATAESAME_DATAESAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EsameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDataEsame) {
			queryPos.add(new Timestamp(dataEsame.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(esame)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Esame> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the esames where dataEsame = &#63; from the database.
	 *
	 * @param dataEsame the data esame
	 */
	@Override
	public void removeByDataEsame(Date dataEsame) {
		for (Esame esame :
				findByDataEsame(
					dataEsame, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(esame);
		}
	}

	/**
	 * Returns the number of esames where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @return the number of matching esames
	 */
	@Override
	public int countByDataEsame(Date dataEsame) {
		FinderPath finderPath = _finderPathCountByDataEsame;

		Object[] finderArgs = new Object[] {_getTime(dataEsame)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ESAME_WHERE);

			boolean bindDataEsame = false;

			if (dataEsame == null) {
				sb.append(_FINDER_COLUMN_DATAESAME_DATAESAME_1);
			}
			else {
				bindDataEsame = true;

				sb.append(_FINDER_COLUMN_DATAESAME_DATAESAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataEsame) {
					queryPos.add(new Timestamp(dataEsame.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DATAESAME_DATAESAME_1 =
		"esame.dataEsame IS NULL";

	private static final String _FINDER_COLUMN_DATAESAME_DATAESAME_2 =
		"esame.dataEsame = ?";

	private FinderPath _finderPathWithPaginationFindByNomeInsegnante;
	private FinderPath _finderPathWithoutPaginationFindByNomeInsegnante;
	private FinderPath _finderPathCountByNomeInsegnante;

	/**
	 * Returns all the esames where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @return the matching esames
	 */
	@Override
	public List<Esame> findByNomeInsegnante(String nomeInsegnante) {
		return findByNomeInsegnante(
			nomeInsegnante, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end) {

		return findByNomeInsegnante(nomeInsegnante, start, end, null);
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
	@Override
	public List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end,
		OrderByComparator<Esame> orderByComparator) {

		return findByNomeInsegnante(
			nomeInsegnante, start, end, orderByComparator, true);
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
	@Override
	public List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end,
		OrderByComparator<Esame> orderByComparator, boolean useFinderCache) {

		nomeInsegnante = Objects.toString(nomeInsegnante, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNomeInsegnante;
				finderArgs = new Object[] {nomeInsegnante};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNomeInsegnante;
			finderArgs = new Object[] {
				nomeInsegnante, start, end, orderByComparator
			};
		}

		List<Esame> list = null;

		if (useFinderCache) {
			list = (List<Esame>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Esame esame : list) {
					if (!nomeInsegnante.equals(esame.getNomeInsegnante())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ESAME_WHERE);

			boolean bindNomeInsegnante = false;

			if (nomeInsegnante.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMEINSEGNANTE_NOMEINSEGNANTE_3);
			}
			else {
				bindNomeInsegnante = true;

				sb.append(_FINDER_COLUMN_NOMEINSEGNANTE_NOMEINSEGNANTE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EsameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeInsegnante) {
					queryPos.add(nomeInsegnante);
				}

				list = (List<Esame>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	@Override
	public Esame findByNomeInsegnante_First(
			String nomeInsegnante, OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		Esame esame = fetchByNomeInsegnante_First(
			nomeInsegnante, orderByComparator);

		if (esame != null) {
			return esame;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeInsegnante=");
		sb.append(nomeInsegnante);

		sb.append("}");

		throw new NoSuchEsameException(sb.toString());
	}

	/**
	 * Returns the first esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	@Override
	public Esame fetchByNomeInsegnante_First(
		String nomeInsegnante, OrderByComparator<Esame> orderByComparator) {

		List<Esame> list = findByNomeInsegnante(
			nomeInsegnante, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	@Override
	public Esame findByNomeInsegnante_Last(
			String nomeInsegnante, OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		Esame esame = fetchByNomeInsegnante_Last(
			nomeInsegnante, orderByComparator);

		if (esame != null) {
			return esame;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeInsegnante=");
		sb.append(nomeInsegnante);

		sb.append("}");

		throw new NoSuchEsameException(sb.toString());
	}

	/**
	 * Returns the last esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	@Override
	public Esame fetchByNomeInsegnante_Last(
		String nomeInsegnante, OrderByComparator<Esame> orderByComparator) {

		int count = countByNomeInsegnante(nomeInsegnante);

		if (count == 0) {
			return null;
		}

		List<Esame> list = findByNomeInsegnante(
			nomeInsegnante, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Esame[] findByNomeInsegnante_PrevAndNext(
			long esameId, String nomeInsegnante,
			OrderByComparator<Esame> orderByComparator)
		throws NoSuchEsameException {

		nomeInsegnante = Objects.toString(nomeInsegnante, "");

		Esame esame = findByPrimaryKey(esameId);

		Session session = null;

		try {
			session = openSession();

			Esame[] array = new EsameImpl[3];

			array[0] = getByNomeInsegnante_PrevAndNext(
				session, esame, nomeInsegnante, orderByComparator, true);

			array[1] = esame;

			array[2] = getByNomeInsegnante_PrevAndNext(
				session, esame, nomeInsegnante, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Esame getByNomeInsegnante_PrevAndNext(
		Session session, Esame esame, String nomeInsegnante,
		OrderByComparator<Esame> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ESAME_WHERE);

		boolean bindNomeInsegnante = false;

		if (nomeInsegnante.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOMEINSEGNANTE_NOMEINSEGNANTE_3);
		}
		else {
			bindNomeInsegnante = true;

			sb.append(_FINDER_COLUMN_NOMEINSEGNANTE_NOMEINSEGNANTE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EsameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNomeInsegnante) {
			queryPos.add(nomeInsegnante);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(esame)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Esame> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the esames where nomeInsegnante = &#63; from the database.
	 *
	 * @param nomeInsegnante the nome insegnante
	 */
	@Override
	public void removeByNomeInsegnante(String nomeInsegnante) {
		for (Esame esame :
				findByNomeInsegnante(
					nomeInsegnante, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(esame);
		}
	}

	/**
	 * Returns the number of esames where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @return the number of matching esames
	 */
	@Override
	public int countByNomeInsegnante(String nomeInsegnante) {
		nomeInsegnante = Objects.toString(nomeInsegnante, "");

		FinderPath finderPath = _finderPathCountByNomeInsegnante;

		Object[] finderArgs = new Object[] {nomeInsegnante};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ESAME_WHERE);

			boolean bindNomeInsegnante = false;

			if (nomeInsegnante.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMEINSEGNANTE_NOMEINSEGNANTE_3);
			}
			else {
				bindNomeInsegnante = true;

				sb.append(_FINDER_COLUMN_NOMEINSEGNANTE_NOMEINSEGNANTE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeInsegnante) {
					queryPos.add(nomeInsegnante);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NOMEINSEGNANTE_NOMEINSEGNANTE_2 =
		"esame.nomeInsegnante = ?";

	private static final String _FINDER_COLUMN_NOMEINSEGNANTE_NOMEINSEGNANTE_3 =
		"(esame.nomeInsegnante IS NULL OR esame.nomeInsegnante = '')";

	public EsamePersistenceImpl() {
		setModelClass(Esame.class);

		setModelImplClass(EsameImpl.class);
		setModelPKClass(long.class);

		setTable(EsameTable.INSTANCE);
	}

	/**
	 * Caches the esame in the entity cache if it is enabled.
	 *
	 * @param esame the esame
	 */
	@Override
	public void cacheResult(Esame esame) {
		entityCache.putResult(EsameImpl.class, esame.getPrimaryKey(), esame);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the esames in the entity cache if it is enabled.
	 *
	 * @param esames the esames
	 */
	@Override
	public void cacheResult(List<Esame> esames) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (esames.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Esame esame : esames) {
			if (entityCache.getResult(EsameImpl.class, esame.getPrimaryKey()) ==
					null) {

				cacheResult(esame);
			}
		}
	}

	/**
	 * Clears the cache for all esames.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EsameImpl.class);

		finderCache.clearCache(EsameImpl.class);
	}

	/**
	 * Clears the cache for the esame.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Esame esame) {
		entityCache.removeResult(EsameImpl.class, esame);
	}

	@Override
	public void clearCache(List<Esame> esames) {
		for (Esame esame : esames) {
			entityCache.removeResult(EsameImpl.class, esame);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EsameImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EsameImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new esame with the primary key. Does not add the esame to the database.
	 *
	 * @param esameId the primary key for the new esame
	 * @return the new esame
	 */
	@Override
	public Esame create(long esameId) {
		Esame esame = new EsameImpl();

		esame.setNew(true);
		esame.setPrimaryKey(esameId);

		esame.setCompanyId(CompanyThreadLocal.getCompanyId());

		return esame;
	}

	/**
	 * Removes the esame with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame that was removed
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	@Override
	public Esame remove(long esameId) throws NoSuchEsameException {
		return remove((Serializable)esameId);
	}

	/**
	 * Removes the esame with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the esame
	 * @return the esame that was removed
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	@Override
	public Esame remove(Serializable primaryKey) throws NoSuchEsameException {
		Session session = null;

		try {
			session = openSession();

			Esame esame = (Esame)session.get(EsameImpl.class, primaryKey);

			if (esame == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEsameException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(esame);
		}
		catch (NoSuchEsameException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Esame removeImpl(Esame esame) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esame)) {
				esame = (Esame)session.get(
					EsameImpl.class, esame.getPrimaryKeyObj());
			}

			if (esame != null) {
				session.delete(esame);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (esame != null) {
			clearCache(esame);
		}

		return esame;
	}

	@Override
	public Esame updateImpl(Esame esame) {
		boolean isNew = esame.isNew();

		if (!(esame instanceof EsameModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(esame.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(esame);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in esame proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Esame implementation " +
					esame.getClass());
		}

		EsameModelImpl esameModelImpl = (EsameModelImpl)esame;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (esame.getCreateDate() == null)) {
			if (serviceContext == null) {
				esame.setCreateDate(date);
			}
			else {
				esame.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!esameModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				esame.setModifiedDate(date);
			}
			else {
				esame.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(esame);
			}
			else {
				esame = (Esame)session.merge(esame);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EsameImpl.class, esameModelImpl, false, true);

		if (isNew) {
			esame.setNew(false);
		}

		esame.resetOriginalValues();

		return esame;
	}

	/**
	 * Returns the esame with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the esame
	 * @return the esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	@Override
	public Esame findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEsameException {

		Esame esame = fetchByPrimaryKey(primaryKey);

		if (esame == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEsameException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return esame;
	}

	/**
	 * Returns the esame with the primary key or throws a <code>NoSuchEsameException</code> if it could not be found.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	@Override
	public Esame findByPrimaryKey(long esameId) throws NoSuchEsameException {
		return findByPrimaryKey((Serializable)esameId);
	}

	/**
	 * Returns the esame with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame, or <code>null</code> if a esame with the primary key could not be found
	 */
	@Override
	public Esame fetchByPrimaryKey(long esameId) {
		return fetchByPrimaryKey((Serializable)esameId);
	}

	/**
	 * Returns all the esames.
	 *
	 * @return the esames
	 */
	@Override
	public List<Esame> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Esame> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Esame> findAll(
		int start, int end, OrderByComparator<Esame> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Esame> findAll(
		int start, int end, OrderByComparator<Esame> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Esame> list = null;

		if (useFinderCache) {
			list = (List<Esame>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ESAME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ESAME;

				sql = sql.concat(EsameModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Esame>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the esames from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Esame esame : findAll()) {
			remove(esame);
		}
	}

	/**
	 * Returns the number of esames.
	 *
	 * @return the number of esames
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ESAME);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "esameId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ESAME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EsameModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the esame persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByNomeEsame = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeEsame",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nomeEsame"}, true);

		_finderPathWithoutPaginationFindByNomeEsame = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeEsame",
			new String[] {String.class.getName()}, new String[] {"nomeEsame"},
			true);

		_finderPathCountByNomeEsame = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeEsame",
			new String[] {String.class.getName()}, new String[] {"nomeEsame"},
			false);

		_finderPathWithPaginationFindByDataEsame = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataEsame",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"dataEsame"}, true);

		_finderPathWithoutPaginationFindByDataEsame = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataEsame",
			new String[] {Date.class.getName()}, new String[] {"dataEsame"},
			true);

		_finderPathCountByDataEsame = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataEsame",
			new String[] {Date.class.getName()}, new String[] {"dataEsame"},
			false);

		_finderPathWithPaginationFindByNomeInsegnante = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeInsegnante",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nomeInsegnante"}, true);

		_finderPathWithoutPaginationFindByNomeInsegnante = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeInsegnante",
			new String[] {String.class.getName()},
			new String[] {"nomeInsegnante"}, true);

		_finderPathCountByNomeInsegnante = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeInsegnante",
			new String[] {String.class.getName()},
			new String[] {"nomeInsegnante"}, false);

		EsameUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EsameUtil.setPersistence(null);

		entityCache.removeCache(EsameImpl.class.getName());
	}

	@Override
	@Reference(
		target = ESAMEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ESAMEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ESAMEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_ESAME =
		"SELECT esame FROM Esame esame";

	private static final String _SQL_SELECT_ESAME_WHERE =
		"SELECT esame FROM Esame esame WHERE ";

	private static final String _SQL_COUNT_ESAME =
		"SELECT COUNT(esame) FROM Esame esame";

	private static final String _SQL_COUNT_ESAME_WHERE =
		"SELECT COUNT(esame) FROM Esame esame WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "esame.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Esame exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Esame exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EsamePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}