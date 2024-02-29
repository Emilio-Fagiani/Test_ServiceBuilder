/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package serviceesame.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

import serviceesame.exception.NoSuchEsameException;

import serviceesame.model.Esame;

/**
 * The persistence interface for the esame service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EsameUtil
 * @generated
 */
@ProviderType
public interface EsamePersistence extends BasePersistence<Esame> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EsameUtil} to access the esame persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the esames where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @return the matching esames
	 */
	public java.util.List<Esame> findByNomeEsame(String nomeEsame);

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
	public java.util.List<Esame> findByNomeEsame(
		String nomeEsame, int start, int end);

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
	public java.util.List<Esame> findByNomeEsame(
		String nomeEsame, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

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
	public java.util.List<Esame> findByNomeEsame(
		String nomeEsame, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public Esame findByNomeEsame_First(
			String nomeEsame,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Returns the first esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public Esame fetchByNomeEsame_First(
		String nomeEsame,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

	/**
	 * Returns the last esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public Esame findByNomeEsame_Last(
			String nomeEsame,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Returns the last esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public Esame fetchByNomeEsame_Last(
		String nomeEsame,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

	/**
	 * Returns the esames before and after the current esame in the ordered set where nomeEsame = &#63;.
	 *
	 * @param esameId the primary key of the current esame
	 * @param nomeEsame the nome esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public Esame[] findByNomeEsame_PrevAndNext(
			long esameId, String nomeEsame,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Removes all the esames where nomeEsame = &#63; from the database.
	 *
	 * @param nomeEsame the nome esame
	 */
	public void removeByNomeEsame(String nomeEsame);

	/**
	 * Returns the number of esames where nomeEsame = &#63;.
	 *
	 * @param nomeEsame the nome esame
	 * @return the number of matching esames
	 */
	public int countByNomeEsame(String nomeEsame);

	/**
	 * Returns all the esames where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @return the matching esames
	 */
	public java.util.List<Esame> findByDataEsame(Date dataEsame);

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
	public java.util.List<Esame> findByDataEsame(
		Date dataEsame, int start, int end);

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
	public java.util.List<Esame> findByDataEsame(
		Date dataEsame, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

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
	public java.util.List<Esame> findByDataEsame(
		Date dataEsame, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public Esame findByDataEsame_First(
			Date dataEsame,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Returns the first esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public Esame fetchByDataEsame_First(
		Date dataEsame,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

	/**
	 * Returns the last esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public Esame findByDataEsame_Last(
			Date dataEsame,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Returns the last esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public Esame fetchByDataEsame_Last(
		Date dataEsame,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

	/**
	 * Returns the esames before and after the current esame in the ordered set where dataEsame = &#63;.
	 *
	 * @param esameId the primary key of the current esame
	 * @param dataEsame the data esame
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public Esame[] findByDataEsame_PrevAndNext(
			long esameId, Date dataEsame,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Removes all the esames where dataEsame = &#63; from the database.
	 *
	 * @param dataEsame the data esame
	 */
	public void removeByDataEsame(Date dataEsame);

	/**
	 * Returns the number of esames where dataEsame = &#63;.
	 *
	 * @param dataEsame the data esame
	 * @return the number of matching esames
	 */
	public int countByDataEsame(Date dataEsame);

	/**
	 * Returns all the esames where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @return the matching esames
	 */
	public java.util.List<Esame> findByNomeInsegnante(String nomeInsegnante);

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
	public java.util.List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end);

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
	public java.util.List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

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
	public java.util.List<Esame> findByNomeInsegnante(
		String nomeInsegnante, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public Esame findByNomeInsegnante_First(
			String nomeInsegnante,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Returns the first esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public Esame fetchByNomeInsegnante_First(
		String nomeInsegnante,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

	/**
	 * Returns the last esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame
	 * @throws NoSuchEsameException if a matching esame could not be found
	 */
	public Esame findByNomeInsegnante_Last(
			String nomeInsegnante,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Returns the last esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esame, or <code>null</code> if a matching esame could not be found
	 */
	public Esame fetchByNomeInsegnante_Last(
		String nomeInsegnante,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

	/**
	 * Returns the esames before and after the current esame in the ordered set where nomeInsegnante = &#63;.
	 *
	 * @param esameId the primary key of the current esame
	 * @param nomeInsegnante the nome insegnante
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public Esame[] findByNomeInsegnante_PrevAndNext(
			long esameId, String nomeInsegnante,
			com.liferay.portal.kernel.util.OrderByComparator<Esame>
				orderByComparator)
		throws NoSuchEsameException;

	/**
	 * Removes all the esames where nomeInsegnante = &#63; from the database.
	 *
	 * @param nomeInsegnante the nome insegnante
	 */
	public void removeByNomeInsegnante(String nomeInsegnante);

	/**
	 * Returns the number of esames where nomeInsegnante = &#63;.
	 *
	 * @param nomeInsegnante the nome insegnante
	 * @return the number of matching esames
	 */
	public int countByNomeInsegnante(String nomeInsegnante);

	/**
	 * Caches the esame in the entity cache if it is enabled.
	 *
	 * @param esame the esame
	 */
	public void cacheResult(Esame esame);

	/**
	 * Caches the esames in the entity cache if it is enabled.
	 *
	 * @param esames the esames
	 */
	public void cacheResult(java.util.List<Esame> esames);

	/**
	 * Creates a new esame with the primary key. Does not add the esame to the database.
	 *
	 * @param esameId the primary key for the new esame
	 * @return the new esame
	 */
	public Esame create(long esameId);

	/**
	 * Removes the esame with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame that was removed
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public Esame remove(long esameId) throws NoSuchEsameException;

	public Esame updateImpl(Esame esame);

	/**
	 * Returns the esame with the primary key or throws a <code>NoSuchEsameException</code> if it could not be found.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame
	 * @throws NoSuchEsameException if a esame with the primary key could not be found
	 */
	public Esame findByPrimaryKey(long esameId) throws NoSuchEsameException;

	/**
	 * Returns the esame with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esameId the primary key of the esame
	 * @return the esame, or <code>null</code> if a esame with the primary key could not be found
	 */
	public Esame fetchByPrimaryKey(long esameId);

	/**
	 * Returns all the esames.
	 *
	 * @return the esames
	 */
	public java.util.List<Esame> findAll();

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
	public java.util.List<Esame> findAll(int start, int end);

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
	public java.util.List<Esame> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator);

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
	public java.util.List<Esame> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Esame>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the esames from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of esames.
	 *
	 * @return the number of esames
	 */
	public int countAll();

}