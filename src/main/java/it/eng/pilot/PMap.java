package it.eng.pilot;

import java.util.Map;

import org.jboss.logging.Logger;

/**
 * Interfaccia che definisce i metodi disponibili per la classe PHashMap.
 * 
 * @author Antonio Corinaldi
 * 
 * @param <K>
 *            K key
 * @param <V>
 *            V value
 * 
 */
public interface PMap<K, V> extends Map<K, V> {

	/**
	 * Inserisce il valore v corrispondente alla chiave k
	 * 
	 * @param k
	 *            key
	 * @param v
	 *            value
	 * @return V
	 */
	V put(K k, V v);

	/**
	 * Recupera il value corrispondente alla chiave key passata
	 * 
	 * @param key
	 *            key
	 * @return V
	 */
	V getValue(K key);

	/**
	 * Ritorna il numero di chiavi della mappa
	 * 
	 * @return Integer
	 */
	Integer keys();

	/**
	 * Rimuove l'elemento o dalla lista di elementi corrispondente alla chiave
	 * elem
	 * 
	 * @param <K>
	 *            K
	 * 
	 * @param <V>
	 *            value
	 * 
	 * @param elem
	 *            e
	 * @param o
	 *            value
	 * @throws Exception
	 *             ex
	 */
	<K, V> void rimuoviMappaLista(K elem, V o) throws Exception;

	/**
	 * Aggiunge l'elemento o alla lista di elementi corrispondente alla chiave
	 * elem
	 * 
	 * 
	 * @param <K>
	 *            key
	 * 
	 * @param <V>
	 *            value
	 * 
	 * @param elem
	 *            key
	 * @param o
	 *            value
	 */
	<K, V> void aggiungiMappaLista(K elem, V o);

	/**
	 * Aggiunge l'elemento o di tipo Entity alla lista di elementi
	 * corrispondente alla chiave elem solo se non c'è conflitto di chiave
	 * primaria (usato per DaoHelper con inMemory=true)
	 * 
	 * 
	 * @param <K>
	 *            key
	 * 
	 * @param <V>
	 *            value
	 * 
	 * @param elem
	 *            key
	 * @param o
	 *            value
	 * @throws Exception
	 *             ex
	 */
	<K, V extends BaseDaoEntity> void aggiungiMappaListaEnt(K elem, V o) throws Exception;

	/**
	 * Aggiunge l'elemento o alla lista di elementi corrispondente alla chiave
	 * elem fino a un massimo di elementi limite
	 * 
	 * 
	 * @param <K>
	 *            key
	 * 
	 * @param <V>
	 *            value
	 * 
	 * @param elem
	 *            key
	 * @param o
	 *            value
	 * @param limite
	 *            l
	 */
	<K, V> void aggiungiMappaLista(K elem, V o, Integer limite);

	/**
	 * Imposta il log passato
	 * 
	 * @param log
	 *            log
	 * @return PMap
	 */
	PHashMap<K, V> setLog(Logger log);

	/**
	 * Rimuove dalla mappa la lista o corrispondente alla chiave elem
	 * 
	 * @param <K>
	 *            key
	 * 
	 * @param <V>
	 *            value
	 * 
	 * 
	 * @param elem
	 *            key
	 * @param o
	 *            value
	 * @throws Exception
	 *             ex
	 */
	<K, V extends BaseDaoEntity> void rimuoviMappaListaEnt(K elem, PList<V> o) throws Exception;

	/**
	 * Aggiunge una intera lista alla lista corrispondente alla chiave elem
	 * 
	 * @param <K>
	 *            key
	 * 
	 * @param <V>
	 *            value
	 * 
	 * 
	 * @param elem
	 *            key
	 * @param listaDaAggiungere
	 *            value
	 */
	public <K, V> void aggiungiMappaLista(K elem, PList<V> listaDaAggiungere);

	/**
	 * 
	 * Ritorna la lista complessiva formata dalla concatenazione di tutte le
	 * liste valore delle chiavi della mappa
	 * 
	 * 
	 * @return PList[V]
	 */
	PList<V> collectAll();

}
