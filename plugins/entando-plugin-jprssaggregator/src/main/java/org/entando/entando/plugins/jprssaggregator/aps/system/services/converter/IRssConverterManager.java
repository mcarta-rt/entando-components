/*
 * Copyright 2015-Present Entando Inc. (http://www.entando.com) All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.entando.entando.plugins.jprssaggregator.aps.system.services.converter;

import java.util.List;
import java.util.Set;

import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.plugins.jacms.aps.system.services.content.model.Content;
import org.entando.entando.plugins.jprssaggregator.aps.system.services.aggregator.ApsAggregatorItem;
import com.rometools.rome.feed.synd.SyndEntry;

/**
 * Base interface for the service that builds contents from a rss feed.
 */
public interface IRssConverterManager {

	/**
	 * Returns a list of feeds
	 * @param feedType the type of feed. Es: rss_2.0
	 * @param url The remote URL containing the feed
	 * @return a list of SyndEntryImpl
	 * @throws ApsSystemException if an error occurs
	 */
	public List<SyndEntry> getRssEntries(String feedType, String url) throws ApsSystemException;

	/**
	 * Ping the source and returns a List of contents according with the configuration
	 * @param item the ApsaggregatorItem
	 * @return a List of contents. 
	 * @throws ApsSystemException if an error occurs
	 */
	public List<Content> getContents(ApsAggregatorItem item) throws ApsSystemException;
	

	/**
	 * @return a Set containing the contentType codes that are configured to be
	 * generated by a feed.
	 */
	public Set<String> getMappings();
	
	/**
	 * Return the mapping configuration for the given contentType
	 * @param contentType string typecode
	 * @return the AggregatorConfig for the contentType provided as parameter
	 */
	public AggregatorConfig getAggregatorConfig(String contentType);
	
	/**
	 * Config item name for the service configuration.
	 */
	public static final String CONFIG_ITEM = "jprssaggregator";
	
	public static final String RSS_2_0 = "rss_2.0";
	
}