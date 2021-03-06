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
package com.agiletec.plugins.jpfastcontentedit.aps.internalservlet.content.attribute.action.link;

import com.agiletec.plugins.jacms.apsadmin.content.attribute.action.link.helper.ILinkAttributeActionHelper;
import javax.servlet.http.HttpSession;

/**
 * @author E.Santoboni
 */
public class ContentLinkAction extends com.agiletec.plugins.jacms.apsadmin.content.attribute.action.link.ContentLinkAction {
	
	@Override
	public String joinContentLink() {
		HttpSession session = this.getRequest().getSession();
		this.setLangCode((String) session.getAttribute(ILinkAttributeActionHelper.LINK_LANG_CODE_SESSION_PARAM));
		return super.joinContentLink();
	}
	
	public String getLangTabAnchorDest() {
		return this.getLangCode() + "_tab";
	}
	
	protected String getLangCode() {
		return _langCode;
	}
	
	protected void setLangCode(String langCode) {
		this._langCode = langCode;
	}
	
	private String _langCode;
	
}