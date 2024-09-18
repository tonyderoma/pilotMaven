package it.eng.pilot;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import org.jboss.logging.Logger;

/**
 * Interfaccia che implementa tutti i metodi Pilot. Per la documentazione vedere
 * i corrispondenti metodi della classe Pilot.
 * 
 * @author Antonio Corinaldi
 *
 */
public interface Pilotable {

	public static int SQL_STRING = Pilot.SQL_STRING;
	public static int SQL_CHAR = Pilot.SQL_CHAR;
	public static int SQL_LONG = Pilot.SQL_LONG;
	public static int SQL_INTEGER = Pilot.SQL_INTEGER;
	public static int SQL_DOUBLE = Pilot.SQL_DOUBLE;
	public static int SQL_FLOAT = Pilot.SQL_FLOAT;
	public static int SQL_DATE = Pilot.SQL_DATE;
	public static int SQL_TIMESTAMP = Pilot.SQL_TIMESTAMP;
	public static int SQL_BIGDECIMAL = Pilot.SQL_BIGDECIMAL;
	public static int SQL_BYTEARRAY = Pilot.SQL_BYTEARRAY;

	// short versions
	public static int _S = Pilot._S;
	public static int _C = Pilot._C;
	public static int _L = Pilot._L;
	public static int _I = Pilot._I;
	public static int _D = Pilot._D;
	public static int _F = Pilot._F;
	public static int _DT = Pilot._DT;
	public static int _TS = Pilot._TS;
	public static int _BIG = Pilot._BIG;
	public static int _BARR = Pilot._BARR;

	public static final String ATTIVO = Pilot.ATTIVO;
	public static final String DISATTIVO = Pilot.DISATTIVO;
	public static final String S = Pilot.S;
	public static final String N = Pilot.N;
	public static final BigDecimal ZERO = Pilot.ZERO;
	public static final BigDecimal ONE = Pilot.ONE;
	public static final String SPACE = Pilot.SPACE;
	public static final String THREE_SPACE = Pilot.THREE_SPACE;

	public Pilot p = new Pilot();

	default void aggiungiTimeCount() {
		LapTime lt = getClass().getAnnotation(LapTime.class);
		if (notNull(lt)) {
			String[] timeCouters = lt.timeCounters();
			for (String tc : timeCouters) {
				aggiungiTimeCount(tc);
			}
		}
	}

	default void setLog(Logger log) {
		p.setLog(log);
	}

	default Logger getLog() {
		return p.getLog();
	}

	default String lf() {
		return p.lf();
	}

	default String lf2() {
		return str(lf(), lf());
	}

	default String tab() {
		return p.tab();
	}

	default String tab2() {
		return str(tab(), tab());
	}

	default String tabn(Integer n) {
		return p.tabn(n);
	}

	default String lfn(Integer n) {
		return p.lfn(n);
	}

	default String str(Object... k) {
		return p.getString(k);
	}

	default void log(Object... k) {
		p.log(k);
	}

	default void logError(Object... k) {
		p.logError(k);
	}

	default String strSpaced(Object... k) {
		return p.strSpaced(k);
	}

	default String strSep(String sep, Object... k) {
		return p.strSep(sep, k);
	}

	default boolean Null(Object... values) {
		return p.Null(values);
	}

	default boolean notNull(Object... values) {
		return p.notNull(values);
	}

	default boolean is(Object campo, Object... value) {
		return p.is(campo, value);
	}

	default boolean isNot(Object campo, Object... value) {
		return p.isNot(campo, value);
	}

	default <K> PList<K> toPList(List<K> l) {
		return p.toPList(l);
	}

	default <K> List<K> safe(List<K> elenco) {
		return p.safe(elenco);
	}

	default boolean maggioreZero(BigDecimal d) {
		return p.maggioreZero(d);
	}

	default boolean minoreZero(BigDecimal d) {
		return p.minoreZero(d);
	}

	default boolean maggioreUgualeZero(BigDecimal d) {
		return p.maggioreUgualeZero(d);
	}

	default boolean minoreUgualeZero(BigDecimal d) {
		return p.minoreUgualeZero(d);
	}

	default BigDecimal moltiplica(BigDecimal b1, BigDecimal b2) {
		return p.moltiplica(b1, b2);
	}

	default BigDecimal moneyToBigDecimal(String importo) {
		return p.moneyToBigDecimal(importo);
	}

	default java.sql.Date nowSql() {
		return p.nowSql();
	}

	default boolean startsWith(String s, String... vals) {
		return p.startsWith(s, vals);
	}

	default PList<BigDecimal> toListBigDecimal(List<String> l) {
		return p.toListBigDecimal(l);
	}

	default PList<Integer> toListInteger(String s, String separator) {
		return p.toListInteger(s, separator);
	}

	default <K, V> PMap<K, V> getPMap() {
		return p.getPMap();
	}

	default <K, V> PMap<K, PList<V>> getPMapList() {
		return p.getPMapList();
	}

	default String concatenaListaStringhe(List<String> l) {
		return p.concatenaListaStringhe(l);
	}

	default PList<Long> toLongList(List<String> l) {
		return p.toLongList(l);
	}

	default PList<Integer> toListInteger(List<String> l) {
		return p.toListInteger(l);
	}

	default Date toDate(String s) {
		return p.toDate(s);
	}

	default Date toDate(String s, String format) {
		return p.toDate(s, format);
	}

	default Date getInfiniteDate() throws ParseException {
		return p.getInfiniteDate();
	}

	default String money(BigDecimal bd) {
		return p.money(bd);
	}

	default boolean zero(BigDecimal d) {
		return p.zero(d);
	}

	default boolean zero(Long d) {
		return p.zero(d);
	}

	default java.sql.Date getSQLDate(Date d) {
		return p.getSQLDate(d);
	}

	default BigDecimal zeroIfNull(BigDecimal val) {
		return p.zeroIfNull(val);
	}

	default Long zeroIfNull(Long val) {
		return p.zeroIfNull(val);
	}

	default Integer zeroIfNull(Integer val) {
		return p.zeroIfNull(val);
	}

	default String concatenaListaStringhe(List<String> l, String car) {
		return p.concatenaListaStringhe(l, car);
	}

	default BigDecimal getBigDecimal(Long val) {
		return p.getBigDecimal(val);
	}

	default BigDecimal getBigDecimal(Long val, Integer precision) {
		return p.getBigDecimal(val, precision);
	}

	default String getTitle(String title, Integer lunghezza, String car) {
		return p.getTitle(title, lunghezza, car);
	}

	default Integer getYear(Date d) {
		return p.getYear(d);
	}

	default <K> PList<K> safe(PList<K> elenco) {
		return p.safe(elenco);
	}

	default boolean isDateAfter(Date d, Date limite) {
		return p.isDateAfter(d, limite);
	}

	default boolean isDateBefore(Date d, Date limite) {
		return p.isDateBefore(d, limite);
	}

	default boolean isDateBetween(Date d, Date start, Date end) {
		return p.isDateBetween(d, start, end);
	}

	default boolean isDateBetweenEx(Date d, Date start, Date end) {
		return p.isDateBetweenEx(d, start, end);
	}

	default PList<Long> toListLong(String s, String separator) {
		return p.toListLong(s, separator);
	}

	default String substring(String s, String start, boolean compresoStart, boolean lastStart, String end, boolean compresoEnd, boolean lastEnd) {
		return p.substring(s, start, compresoStart, lastStart, end, compresoEnd, lastEnd);
	}

	default <T> T valIfNull(T... val) {
		return p.valIfNull(val);
	}

	default boolean zero(Integer d) {
		return p.zero(d);
	}

	default boolean tutte(Boolean... b) {
		return p.tutte(b);
	}

	default boolean almenoUna(Boolean... b) {
		return p.almenoUna(b);
	}

	default boolean isLike(Object campo, Object... value) {
		return p.isLike(campo, value);
	}

	default <K> PList<K> getPList() {
		return p.getPList();
	}

	default <K> PList<K> getPList(Integer limite) {
		return p.getPList(limite);
	}

	default Integer getInteger(String val) {
		return p.getInteger(val);
	}

	default BigDecimal getBigDecimal(String val) {
		return p.getBigDecimal(val);
	}

	default BigDecimal getBigDecimal(String val, Integer precision) {
		return p.getBigDecimal(val, precision);
	}

	default PList<String> toListString(String s, String separator) {
		return p.toListString(s, separator);
	}

	default Object get(Object bean, String prop) throws Exception {
		return p.get(bean, prop);
	}

	default PList<String> getPListString() {
		return p.getPListString();
	}

	default String getYear(String d) {
		return p.getYear(d);
	}

	default String nowString() {
		return p.nowString();
	}

	default Date now() {
		return p.now();
	}

	default Date nowLessWeeks(Integer n) {
		return p.nowLessWeeks(n);
	}

	default Date nowLessDays(Integer n) {
		return p.nowLessDays(n);
	}

	default Date nowLessMonths(Integer n) {
		return p.nowLessMonths(n);
	}

	default Date nowLessYears(Integer n) {
		return p.nowLessYears(n);
	}

	default Date nowAddWeeks(Integer n) {
		return p.nowAddWeeks(n);
	}

	default Date nowAddDays(Integer n) {
		return p.nowAddDays(n);
	}

	default Date nowAddMonths(Integer n) {
		return p.nowAddMonths(n);
	}

	default Date nowAddYears(Integer n) {
		return p.nowAddYears(n);
	}

	default <T> PList<T> arrayToList(T[] a) {
		return p.arrayToList(a);
	}

	default <K> Set<K> safe(Set<K> elenco) {
		return p.safe(elenco);
	}

	default boolean notNullOR(Object... values) {
		return p.notNullOR(values);
	}

	default boolean NullOR(Object... values) {
		return p.NullOR(values);
	}

	default boolean si(String value) {
		return p.si(value);
	}

	default boolean no(String value) {
		return p.no(value);
	}

	default boolean diverso(BigDecimal d, BigDecimal d1) {
		return p.diverso(d, d1);
	}

	default boolean uguale(BigDecimal d, BigDecimal d1) {
		return p.uguale(d, d1);
	}

	default Timestamp nowTS() {
		return p.nowTS();
	}

	default Long getLong(String val) {
		return p.getLong(val);
	}

	default Double getDouble(String val) {
		return p.getDouble(val);
	}

	default Float getFloat(String val) {
		return p.getFloat(val);
	}

	default Short getShort(String val) {
		return p.getShort(val);
	}

	default int countChar(String s, char ch) {
		return p.countChar(s, ch);
	}

	default <K> K getFirstElement(List<K> l) {
		return p.getFirstElement(l);
	}

	default <K> K getLastElement(List<K> l) {
		return p.getLastElement(l);
	}

	default boolean one(BigDecimal d) {
		return p.one(d);
	}

	default boolean one(Long d) {
		return p.one(d);
	}

	default boolean one(Integer d) {
		return p.one(d);
	}

	default String replace(String s, String old, String nuova) {
		return p.replace(s, old, nuova);
	}

	default String replaceLast(String string, String toReplace, String replacement) {
		return p.replaceLast(string, toReplace, replacement);
	}

	default String cut(String s, Integer n) {
		return p.cut(s, n);
	}

	default String cutLast(String s) {
		return p.cutLast(s);
	}

	default String cutLast(StringBuffer s) {
		return p.cutLast(s);
	}

	default String cutLast(StringBuilder s) {
		return p.cutLast(s);
	}

	default boolean maggioreZero(Long d) {
		return p.maggioreZero(d);
	}

	default <K, T> void aggiungi(Map<K, T> mappa, K elem, T o) {
		p.aggiungi(mappa, elem, o);
	}

	default <K, T> void rimuovi(Map<K, T> mappa, K elem) {
		p.rimuovi(mappa, elem);
	}

	default <K, T> void rimuoviMappaLista(Map<K, List<T>> mappa, K elem, T o) throws Exception {
		p.rimuoviMappaLista(mappa, elem, o);
	}

	default BigDecimal aggiungi(BigDecimal... vals) {
		return p.aggiungi(vals);
	}

	default BigDecimal sottrai(BigDecimal b1, BigDecimal b2) {
		return p.sottrai(b1, b2);
	}

	default String capFirstLetter(String s) {
		return p.capFirstLetter(s);
	}

	default String decapFirstLetter(String s) {
		return p.decapFirstLetter(s);
	}

	default String dateToString(Date d) {
		return p.dateToString(d);
	}

	default String dateToStringhhmmss(Date d) {
		return p.dateToStringhhmmss(d);
	}

	default String dateToString(Date d, String format) {
		return p.dateToString(d, format);
	}

	default String elapsedTime(Date startDate) {
		return p.elapsedTime(startDate);
	}

	default String elapsedTime(Date startDate, Date endDate) {
		return p.elapsedTime(startDate, endDate);
	}

	default String toCamelCase(String s, String separatore) {
		return p.toCamelCase(s, separatore);
	}

	default BigDecimal getBigDecimal(BigDecimal val) {
		return p.getBigDecimal(val);
	}

	default BigDecimal getBigDecimal(BigDecimal val, Integer precision) {
		return p.getBigDecimal(val, precision);
	}

	default String emptyIfNull(String s) {
		return p.emptyIfNull(s);
	}

	default String apiceString(String s) {
		return p.apiceString(s);
	}

	default Date addDays(Date data, Integer numeroGiorni) {
		return p.addDays(data, numeroGiorni);
	}

	default Date addHours(Date data, Integer numeroOre) {
		return p.addHours(data, numeroOre);
	}

	default Date addMinutes(Date data, Integer numeroMinuti) {
		return p.addMinutes(data, numeroMinuti);
	}

	default Date addSeconds(Date data, Integer numeroSecondi) {
		return p.addSeconds(data, numeroSecondi);
	}

	default Date addMilliseconds(Date data, Integer numeroMillisecondi) {
		return p.addMilliseconds(data, numeroMillisecondi);
	}

	default Date addTimeToDate(Date start, Time t) {
		return p.addTimeToDate(start, t);
	}

	default Date addMonths(Date data, Integer numeroMesi) {
		return p.addMonths(data, numeroMesi);
	}

	default Date addYears(Date data, Integer numeroAnni) {
		return p.addYears(data, numeroAnni);
	}

	default BigDecimal getBigDecimal(Integer val) {
		return p.getBigDecimal(val);
	}

	default BigDecimal getBigDecimal(Integer val, Integer precision) {
		return p.getBigDecimal(val, precision);
	}

	default BigDecimal getBigDecimal(Double val) {
		return p.getBigDecimal(val);
	}

	default BigDecimal getBigDecimal(Double val, Integer precision) {
		return p.getBigDecimal(val, precision);
	}

	default BigDecimal dividi(BigDecimal b1, BigDecimal b2) {
		return p.dividi(b1, b2);
	}

	default Integer howManyChars(String s, char t) {
		return p.howManyChars(s, t);
	}

	default <T> T[] toArray(List<T> list, Class<T> clazz) {
		return p.toArray(list, clazz);
	}

	default String despaceString(String s) {
		return p.despaceString(s);
	}

	default <K> PList<K> getPList(K... items) {
		return p.getPList(items);
	}

	default <K extends Comparable<K>> K max(Collection<K> l) {
		return p.max(l);
	}

	default <K extends Comparable<K>> K min(Collection<K> l) {
		return p.min(l);
	}

	default <T> T maxBean(List<T> l1, String... prop) throws Exception {
		return p.maxBean(l1, prop);
	}

	default <T> T minBean(List<T> l1, String... prop) throws Exception {
		return p.minBean(l1, prop);
	}

	default <K extends Comparable<K>> boolean insideInterval(K val, K start, K end) {
		return p.insideInterval(val, start, end);
	}

	default <K extends Comparable<K>> boolean insideInterval(K val1, K val2, K start, K end) {
		return p.insideInterval(val1, val2, start, end);
	}

	default <K> PList<K> mockList(Class<K> c, Integer n) throws Exception {
		return p.mockList(c, n);
	}

	default <K> K mock(Class<K> c) throws Exception {
		return p.mock(c);
	}

	default void writeFile(String path, List<String> data) {
		p.writeFile(path, data);
	}

	default <K> K mask(K k, String... fields) throws Exception {
		return p.mask(k, fields);
	}

	default <K> PList<K> maskList(PList<K> lista, String... campi) throws Exception {
		return p.maskList(lista, campi);
	}

	default <K, T> void aggiungiMappaLista(Map<K, List<T>> mappa, K elem, T o) {
		p.aggiungiMappaLista(mappa, elem, o);
	}

	default String getUniqueName() {
		return p.getUniqueName();
	}

	default <K> List<K> intersection(List<K> l1, List<K>... liste) {
		return p.intersection(l1, liste);
	}

	default <K> List<K> inverti(List<K> l) {
		return p.inverti(l);
	}

	default <T> PList<T> setToList(Set<T> a) {
		return p.setToList(a);
	}

	default Integer sommaInt(String... vals) {
		return p.sommaInt(vals);
	}

	default Long sommaLong(String... vals) {
		return p.sommaLong(vals);
	}

	default <K> K[] modificaLunghezzaArray(K[] arr, Integer i) {
		return p.modificaLunghezzaArray(arr, i);
	}

	default Long sommaLong(Long... vals) {
		return p.sommaLong(vals);
	}

	default Integer sommaInt(Integer... vals) {
		return p.sommaInt(vals);
	}

	default <K extends Number> PList<String> toListString(List<K> l) {
		return p.toListString(l);
	}

	default void printList(String title, Integer length, List<String> container) {
		p.printList(title, length, container);
	}

	default void printList(String title, Integer length, String prefixBeforeItem, List<String> container) {
		p.printList(title, length, prefixBeforeItem, container);
	}

	/**
	 * Alias di getPList()
	 * 
	 * @return PList[K]
	 */
	default <K> PList<K> pl() {
		return getPList();
	}

	/**
	 * Alias di getPList(Integer)
	 * 
	 * 
	 * @param limite
	 * @return PList[K]
	 */
	default <K> PList<K> pl(Integer limite) {
		return getPList(limite);
	}

	/**
	 * Alias di getPMap()
	 * 
	 * @return PMap[K, V]
	 */
	default <K, V> PMap<K, V> pmap() {
		return getPMap();
	}

	/**
	 * Alias di getPMapList()
	 * 
	 * @return PMap[K, PList[V[]
	 */
	default <K, V> PMap<K, PList<V>> pmapl() {
		return getPMapList();
	}

	/**
	 * Alias di getPListString()
	 * 
	 * @return PList[String]
	 */
	default PList<String> plstr() {
		return getPListString();
	}

	default <K> PList<K> getPList(Collection<K> list) {
		return p.getPList(list);
	}

	/**
	 * Alias di getPList(Collection[K] list)
	 * 
	 * @param list
	 * @return Collection[K]
	 */
	default <K> PList<K> pl(Collection<K> list) {
		return p.pl(list);
	}

	/**
	 * Alias di getPList(K...items)
	 * 
	 * @param items
	 * @return PList[K]
	 */
	default <K> PList<K> pl(K... items) {
		return getPList(items);
	}

	default <K> K[] estendiLunghezzaArrayDi(K[] arr, Integer i) {
		return p.estendiLunghezzaArrayDi(arr, i);
	}

	default <K> K[] safe(K[] arr, Class<K> c) throws Exception {
		return p.safe(arr, c);
	}

	default PList<String> readFile(String path) {
		return p.readFile(path);
	}

	default <T> PList<String> readFileAsResource(Class<T> c, String nomeFile) throws Exception {
		return p.readFileAsResource(c, nomeFile);
	}

	default <T> byte[] readFileAsResourceToByteArray(Class<T> c, String nomeFile) throws Exception {
		return p.readFileAsResourceToByteArray(c, nomeFile);
	}

	default byte[] readFileIntoByteArray(String path) {
		return p.readFileIntoByteArray(path);
	}

	default String capFirstLetterAfterSpace(String s) {
		return p.capFirstLetterAfterSpace(s);
	}

	default String decapFirstLetterAfterSpace(String s) {
		return p.decapFirstLetterAfterSpace(s);
	}

	default Set<File> getFiles(String path, String like, String notLike, String estensione, String data, boolean ricorsivo) throws IOException {
		return p.getFiles(path, like, notLike, estensione, data, ricorsivo);
	}

	default <K> String concatenaLista(PList<K> l, String car, boolean apici) {
		return p.concatenaLista(l, car, apici);
	}

	default void serializeToFile(Object o, String file) {
		p.serializeToFile(o, file);
	}

	default Object deserializeFromFile(String file) {
		return p.deserializeFromFile(file);
	}

	default void removeFile(String pathFile) {
		p.removeFile(pathFile);
	}

	default boolean fileExists(String pathFile) {
		return p.fileExists(pathFile);
	}

	default Integer getMonth(Date d) {
		return p.getMonth(d);
	}

	default Integer getDay(Date d) {
		return p.getDay(d);
	}

	default int monthsBetweenDates(Date startDate, Date endDate) {
		return p.monthsBetweenDates(startDate, endDate);
	}

	default int yearsBetweenDates(Date first, Date last) {
		return p.yearsBetweenDates(first, last);
	}

	default PList<Integer> iterateOverDates(Date d1, Date d2) {
		return p.iterateOverDates(d1, d2);
	}

	default boolean isLastDayOfMonth(Date d) {
		return p.isLastDayOfMonth(d);
	}

	default <K> List<K> toArrayList(PList<K> lista) {
		return p.toArrayList(lista);
	}

	default <K extends Comparable<K>> boolean maggioreDi(K d, K d1) {
		return p.maggioreDi(d, d1);
	}

	default <K extends Comparable<K>> boolean minoreDi(K d, K d1) {
		return p.minoreDi(d, d1);
	}

	default <K extends Comparable<K>> boolean maggioreUgualeDi(K d, K d1) {
		return p.maggioreUgualeDi(d, d1);
	}

	default <K extends Comparable<K>> boolean minoreUgualeDi(K d, K d1) {
		return p.minoreDi(d, d1);
	}

	default String cutToFirstOccurence(String s, String elemento) {
		return p.cutToFirstOccurence(s, elemento);
	}

	default String cutToLastOccurence(String s, String elemento) {
		return p.cutToLastOccurence(s, elemento);
	}

	default BigDecimal percentuale(BigDecimal b1, BigDecimal b2) {
		return p.percentuale(b1, b2);
	}

	default BigDecimal percentualeToValore(BigDecimal numero, BigDecimal percentuale) {
		return p.percentualeToValore(numero, percentuale);
	}

	default <K extends Comparable<K>> K limiteInferiore(K val, K limite) {
		return p.limiteInferiore(val, limite);
	}

	default <K extends Comparable<K>> K limiteSuperiore(K val, K limite) {
		return p.limiteSuperiore(val, limite);
	}

	default <K extends Comparable<K>> K between(K val, K start, K end) {
		return p.between(val, start, end);
	}

	default <K> PList<K> mockList(Class<K> c) throws Exception {
		return p.mockList(c);
	}

	default <K extends Serializable> K copyObj(K o) {
		return p.copyObj(o);
	}

	default <K extends Serializable> K clone(K o) {
		return copyObj(o);
	}

	default BigDecimal bd(BigDecimal val) {
		return p.bd(val);
	}

	default BigDecimal bd(Double val) {
		return p.bd(val);
	}

	default BigDecimal bd(Integer val) {
		return p.bd(val);
	}

	default BigDecimal bd(Long val) {
		return p.bd(val);
	}

	default BigDecimal bd(String val) {
		return p.bd(val);
	}

	default BigDecimal bd(BigDecimal val, Integer precision) {
		return p.bd(val, precision);
	}

	default BigDecimal bd(Double val, Integer precision) {
		return p.bd(val, precision);
	}

	default BigDecimal bd(Integer val, Integer precision) {
		return p.bd(val, precision);
	}

	default BigDecimal bd(Long val, Integer precision) {
		return p.bd(val, precision);
	}

	default BigDecimal bd(String val, Integer precision) {
		return p.bd(val, precision);
	}

	default boolean endsWith(String s, String... vals) {
		return p.endsWith(s, vals);
	}

	default <K> PList<K> toList(String s, String separator, Class<K> c) {
		return p.toList(s, separator, c);
	}

	default void setPropertyFile(String propertyFile) {
		p.setPropertyFile(propertyFile);
	}

	default String getKey(String key) {
		return p.getKey(key);
	}

	default String getKey(String key, String defaultValue) {
		return p.getKey(key, defaultValue);
	}

	default boolean toBool(String s) {
		return p.toBool(s);
	}

	default Boolean getKeyBool(String key) {
		return p.getKeyBool(key);
	}

	default Boolean getKeyBool(String key, boolean defaultValue) {
		return p.getKeyBool(key, defaultValue);
	}

	default PList<String> getKeyList(String key) {
		return p.getKeyList(key);
	}

	default PList<String> getKeyList(String key, String separator) {
		return p.getKeyList(key, separator);
	}

	default PList<Integer> getKeyListInt(String key) {
		return p.getKeyListInt(key);
	}

	default PList<Integer> getKeyListInt(String key, String separator) {
		return p.getKeyListInt(key, separator);
	}

	default PList<Long> getKeyListLong(String key) {
		return p.getKeyListLong(key);
	}

	default PList<Long> getKeyListLong(String key, String separator) {
		return p.getKeyListLong(key, separator);
	}

	default PList<Double> getKeyListDouble(String key) {
		return p.getKeyListDouble(key);
	}

	default PList<Double> getKeyListDouble(String key, String separator) {
		return p.getKeyListDouble(key, separator);
	}

	default Integer getKeyInt(String key) {
		return p.getKeyInt(key);
	}

	default Long getKeyLong(String key) {
		return p.getKeyLong(key);
	}

	default Integer getKeyInt(String key, Integer defaultValue) {
		return p.getKeyInt(key, defaultValue);
	}

	default Long getKeyLong(String key, Long defaultValue) {
		return p.getKeyLong(key, defaultValue);
	}

	default void writeFile(String path, String data) {
		p.writeFile(path, data);
	}

	default <T extends BaseEntity> void writeFile(String path, T data) {
		p.writeFile(path, data);
	}

	default <T extends BaseEntity> void writeFile(String path, PList<T> data) {
		p.writeFile(path, data);
	}

	default String getUniqueNamehhmmss() {
		return p.getUniqueNamehhmmss();
	}

	default <K> String toStr(K o) {
		return p.toStr(o);
	}

	default <K extends BaseEntity> String toStrEntity(K o) {
		return p.toStrEntity(o);
	}

	default String zeroStart(int num) {
		return p.zeroStart(num);
	}

	default Time elapsed(Date startDate) {
		return p.elapsed(startDate);
	}

	default Time elapsed(Date startDate, Date endDate) {
		return p.elapsed(startDate, endDate);
	}

	default String elapsedTime(Long milliseconds) {
		return p.elapsedTime(milliseconds);
	}

	default Time elapsedTimeTime(Long milliseconds) {
		return p.elapsedTimeTime(milliseconds);
	}

	default void aggiungiTimeCount(String name) {
		p.aggiungiTimeCount(name);
	}

	default void rimuoviTimeCount(String name) {
		p.rimuoviTimeCount(name);
	}

	default void resetTimeCount() {
		p.resetTimeCount();
	}

	default void addTimeToTimeCount(String name, Time t) {
		p.addTimeToTimeCount(name, t);
	}

	default String getTimeCountInfo(String name) {
		return p.getTimeCountInfo(name);
	}

	default String getLastAddedTimeInTimeCount(String name) {
		return p.getLastAddedTimeInTimeCount(name);
	}

	default void addTimeToTimeCount(String name, Date startDate) {
		p.addTimeToTimeCount(name, startDate);
	}

	default String getTimeCountTotalInfo() {
		return p.getTimeCountTotalInfo();
	}

	default String getLap(String name) {
		return p.getLap(name);
	}

	default void lap(String name, Time t) {
		p.lap(name, t);
	}

	default void lap(String name, Date startDate) {
		p.lap(name, startDate);
	}

	default String getLapTotalInfo() {
		return p.getLapTotalInfo();
	}

	default void lapAndLog(String prefix, String timeCounter, Date start) {
		p.lapAndLog(prefix, timeCounter, start);
	}

	default String repeat(Integer l, String car) {
		return p.repeat(l, car);
	}

	default String getInfoFramed(String title, Integer length, String car, Integer tabIndent, PList<String> container) {
		return p.getInfoFramed(title, length, car, tabIndent, container);
	}

	default String getInfoFramed(String title, PList<String> container) {
		return p.getInfoFramed(title, container);
	}

	default String frame(String title, PList<String> container) {
		return getInfoFramed(title, container);
	}

	default String frame(String title, Integer length, String car, Integer tabIndent, PList<String> container) {
		return getInfoFramed(title, length, car, tabIndent, container);
	}

	default PList<String> plstr(String... items) {
		return p.plstr(items);
	}

	default <K extends Execution> Future stacca(final K o) {
		return p.stacca(o);
	}

	default String convertToStringRepresentation(long value) {
		return p.convertToStringRepresentation(value);
	}

	default void hw() {
		p.hw();
	}

	default String elimina(String s, String... vals) {
		return p.elimina(s, vals);
	}

	default String primoGiornoDelMese(Date d) {
		return p.primoGiornoDelMese(d);
	}

	default Date primoGiornoDelMeseDate(Date d) {
		return p.primoGiornoDelMeseDate(d);
	}

	default boolean nessuna(Boolean... b) {
		return p.nessuna(b);
	}

	default PList<KeyValue<String, String>> getQueryString(String s) {
		return p.getQueryString(s);
	}

	default PList<String> split(String input, String delimiter) {
		return p.split(input, delimiter);
	}

	default String getLast(String s) {
		return p.getLast(s);
	}

	default String getFirst(String s) {
		return p.getFirst(s);
	}

	default String pluraleSingolare(int num, String s) {
		return p.pluraleSingolare(num, s);
	}

	default String strSepDash(Object... values) {
		return p.strSepDash(values);
	}

	default String strSepComma(Object... values) {
		return p.strSepComma(values);
	}

	default String strSepPipe(Object... values) {
		return p.strSepPipe(values);
	}

	default String strSepSpace(Object... values) {
		return p.strSepSpace(values);
	}

	default String concatenaDashListaStringhe(List<String> l) {
		return p.concatenaDashListaStringhe(l);
	}

	default String concatenaCommaListaStringhe(List<String> l) {
		return p.concatenaCommaListaStringhe(l);
	}

	default String concatenaPipeListaStringhe(List<String> l) {
		return p.concatenaPipeListaStringhe(l);
	}

	default String concatenaSpaceListaStringhe(List<String> l) {
		return p.concatenaSpaceListaStringhe(l);
	}

	default <K> PList<K> toListDashSep(String s, Class<K> c) {
		return p.toListDashSep(s, c);
	}

	default <K> PList<K> toListCommaSep(String s, Class<K> c) {
		return p.toListCommaSep(s, c);
	}

	default <K> PList<K> toListPipeSep(String s, Class<K> c) {
		return p.toListPipeSep(s, c);
	}

	default <K> Set<K> toSetDashSep(String s, Class<K> c) {
		return p.toSetDashSep(s, c);
	}

	default <K> Set<K> toSetCommaSep(String s, Class<K> c) {
		return p.toSetCommaSep(s, c);
	}

	default <K> Set<K> toSetPipeSep(String s, Class<K> c) {
		return p.toSetPipeSep(s, c);
	}

	/**
	 * Da un oggetto Date ritorna un oggetto PDate
	 * 
	 * @param d
	 * @return PDate
	 */
	default PDate pd(Date d) {
		return p.pd(d);
	}

	/**
	 * Ritorna un oggetto PDate con la data attuale
	 * 
	 * @return PDate
	 */
	default PDate pd() {
		return p.pd(now());
	}

	/**
	 * Dalla data in formato stringa ritorna un oggetto PDate. Se il valore
	 * passato non è una data valida secondo il formato italiano, ritorna la
	 * data odierna
	 * 
	 * @param s
	 * @return PDate
	 */
	default PDate pd(String s) {
		return p.pd().from(s);
	}

	default PList<String> splitDash(String input) {
		return p.splitDash(input);
	}

	default PList<String> splitComma(String input) {
		return p.splitComma(input);
	}

	default PList<String> splitPipe(String input) {
		return p.splitPipe(input);
	}

	default PList<String> splitSpace(String input) {
		return p.splitSpace(input);
	}

	default String getIdUnivoco() {
		return p.getIdUnivoco();
	}

	default void setState(String key, Object val) {
		p.setState(key, val);
	}

	default Object getState(String key) {
		return p.getState(key);
	}

	default String getStateStr(String key) {
		return p.getStateStr(key);
	}

	default Long getStateLong(String key) {
		return p.getStateLong(key);
	}

	default Date getStateDate(String key) {
		return p.getStateDate(key);
	}

	default void setStateEmpty() {
		p.setStateEmpty();
	}

	default void clearState(String key) {
		p.clearState(key);
	}

	default PMap<String, Object> getState() {
		return p.getState();
	}

	default void clearState() {
		setStateEmpty();
	}

	default String sn(boolean val) {
		return p.sn(val);
	}

	default String yn(boolean val) {
		return p.yn(val);
	}

	default String unozero(boolean val) {
		return p.unozero(val);
	}

	default String sn(Boolean val) {
		return p.sn(val);
	}

	default String yn(Boolean val) {
		return p.yn(val);
	}

	default String unozero(Boolean val) {
		return p.unozero(val);
	}

	default void ps(String sql, PreparedStatement ps, int[] tipi, Object... vals) throws Exception {
		p.ps(sql, ps, tipi, vals);
	}

	default boolean checkParenthesis(String s) {
		return p.checkParenthesis(s);
	}

	/**
	 * Ritorna la data di ieri
	 * 
	 * @return PDate
	 */
	default PDate ieri() {
		return p.ieri();
	}

	/**
	 * Ritorna la data di domani
	 * 
	 * @return PDate
	 */
	default PDate domani() {
		return p.domani();
	}

	/**
	 * Ritorna la data di n giorni fa a partire dalla data odierna
	 * 
	 * @param n
	 * @return PDate
	 */
	default PDate giorniFa(int n) {
		return p.giorniFa(n);
	}

	/**
	 * Ritorna la data di n settimane fa a partire dalla data odierna
	 * 
	 * @param n
	 * @return PDate
	 */
	default PDate settimaneFa(int n) {
		return p.settimaneFa(n);
	}

	/**
	 * Ritorna la data di n settimane nel futuro a partire dalla data odierna
	 * 
	 * @param n
	 * @return PDate
	 */
	default PDate settimaneFuturo(int n) {
		return p.settimaneFuturo(n);
	}

	/**
	 * Ritorna la data di n mesi fa a partire dalla data odierna
	 * 
	 * @param n
	 * @return PDate
	 */
	default PDate mesiFa(int n) {
		return p.mesiFa(n);
	}

	/**
	 * Ritorna la data di n mesi nel futuro a partire dalla data odierna
	 * 
	 * @param n
	 * @return PDate
	 */
	default PDate mesiFuturo(int n) {
		return p.mesiFuturo(n);
	}

	/**
	 * Ritorna la data di n anni fa a partire dalla data odierna
	 * 
	 * @param n
	 * @return PDate
	 */
	default PDate anniFa(int n) {
		return p.anniFa(n);
	}

	/**
	 * Ritorna la data di n anni nel futuro a partire dalla data odierna
	 * 
	 * @param n
	 * @return PDate
	 */
	default PDate anniFuturo(int n) {
		return p.anniFuturo(n);
	}

	/**
	 * Ritorna la data di n giorni nel futuro a partire dalla data odierna
	 * 
	 * @param n
	 * @return PDate
	 */
	default PDate giorniFuturo(int n) {
		return p.giorniFuturo(n);
	}

	/**
	 * Scrive su file in modalità append
	 * 
	 * @param <T>
	 * @param path
	 * @param data
	 */
	default <T> void appendFile(String path, List<T> data) {
		p.appendFile(path, data);
	}
}
