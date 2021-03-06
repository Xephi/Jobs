/**
 * Jobs Plugin for Bukkit
 * Copyright (C) 2011 Zak Ford <zak.j.ford@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.zford.jobs.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import me.zford.jobs.Jobs;

public class JobsClassLoader extends URLClassLoader {
    
    public JobsClassLoader(Jobs core) {
        super(new URL[0], core.getClass().getClassLoader());
    }

    public void addFile(File f) throws IOException {
        addURL(f.toURI().toURL());
    }
    
    @Override
    public void addURL(URL url) {
        for (URL u : getURLs())
            if (url.sameFile(u)) return;
        
        super.addURL(url);
    }
}
