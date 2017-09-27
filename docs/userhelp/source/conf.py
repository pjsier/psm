# -*- coding: utf-8 -*-
#
# Provider Screening Module documentation build configuration file, created by
# sphinx-quickstart on Fri Jul 21 14:09:29 2017.
#
# This file is execfile()d with the current directory set to its
# containing dir.
#
# Note that not all possible configuration values are present in this
# autogenerated file.
#
# All configuration values have a default; values that are commented out
# serve to show the default.

# If extensions (or modules to document with autodoc) are in another directory,
# add these directories to sys.path here. If the directory is relative to the
# documentation root, use os.path.abspath to make it absolute, like shown here.
# sys.path.insert(0, os.path.abspath('.'))
import os
import sys

# -- General configuration ------------------------------------------------

# If your documentation needs a minimal Sphinx version, state it here.
#
# needs_sphinx = '1.0'

# Add any Sphinx extension module names here, as strings. They can be
# extensions coming with Sphinx (named 'sphinx.ext.*') or your custom
# ones.
extensions = ['sphinx.ext.autodoc',
    'sphinx.ext.doctest',
    'sphinx.ext.intersphinx',
    'sphinx.ext.todo',
    'sphinx.ext.coverage',
    'sphinx.ext.ifconfig',
    'sphinx.ext.viewcode',
    'sphinx.ext.githubpages']

# Add any paths that contain templates here, relative to this directory.

# The suffix(es) of source filenames.
# You can specify multiple suffix as a list of string:
#
# source_suffix = ['.rst', '.md']
source_suffix = '.rst'

# The master toctree document.
master_doc = 'index'

# General information about the project.
project = u'Provider Screening Module user manual'
copyright = u'2017, Open Tech Strategies, LLC'
author = u'Open Tech Strategies, LLC'

# The version info for the project you're documenting, acts as replacement for
# |version| and |release|, also used in various other places throughout the
# built documents.
#
# The short X.Y version.
version = u'1.0'
# The full version, including alpha/beta/rc tags.
release = u'1.0'

# The language for content autogenerated by Sphinx. Refer to documentation
# for a list of supported languages.
#
# This is also used if you do content translation via gettext catalogs.
# Usually you set "language" from the command line for these cases.
language = None

# List of patterns, relative to source directory, that match files and
# directories to ignore when looking for source files.
# This patterns also effect to html_static_path and html_extra_path
exclude_patterns = []

# The name of the Pygments (syntax highlighting) style to use.
pygments_style = 'sphinx'

# If true, `todo` and `todoList` produce output, else they produce nothing.
todo_include_todos = False


# -- Options for HTML output ----------------------------------------------

# The theme to use for HTML and HTML Help pages.  See the documentation for
# a list of builtin themes.
#
html_theme = 'bizstyle'

# Theme options are theme-specific and customize the look and feel of a theme
# further.  For a list of options available for each theme, see the
# documentation.
#
# html_theme_options = {}

# Add any paths that contain custom static files (such as style sheets) here,
# relative to this directory. They are copied after the builtin static files,
# so a file named "default.css" will overwrite the builtin "default.css".

# Custom sidebar templates, must be a dictionary that maps document names
# to template names.
#
# This is required for the alabaster theme
# refs: http://alabaster.readthedocs.io/en/latest/installation.html#sidebars
html_sidebars = {
    '**': [
#        'about.html',
#        'navigation.html',
         'relations.html',  # needs 'show_related': True theme option to display
         'searchbox.html',
    ]
}

html_logo = os.path.join(os.path.abspath(os.pardir),
                         os.pardir,
                         os.pardir,
                         "psm-app/cms-web/WebContent/i/psm-logo-small.png")

# -- Options for HTMLHelp output ------------------------------------------

# Output file base name for HTML help builder.
htmlhelp_basename = 'ProviderScreeningModuledoc'


# -- Options for manual page output ---------------------------------------

# One entry per manual page. List of tuples
# (source start file, name, description, authors, manual section).
man_pages = [
    (master_doc, 'providerscreeningmodule', u'Provider Screening Module Documentation',
     [author], 1)
]


# -- Options for Texinfo output -------------------------------------------

# Grouping the document tree into Texinfo files. List of tuples
# (source start file, target name, title, author,
#  dir menu entry, description, category)
texinfo_documents = [
    (master_doc, 'ProviderScreeningModule',
     u'Provider Screening Module Documentation',
     author,
     'ProviderScreeningModule',
     'This open source Provider Screening Module (PSM) is designed to work within a Medicare/Medicaid Information System (MMIS) environment to provide a portal for screening service providers as part of the provider enrollment process.',
     'Miscellaneous'),
]


# -- Options for LaTeX output ---------------------------------------------

latex_show_pagerefs = True

latex_show_urls = 'footnote'

latex_logo = os.path.join(os.path.abspath(os.pardir),
                          os.pardir,
                          os.pardir,
                          "psm-app/cms-web/WebContent/i/psm-logo.png")

latex_toplevel_sectioning = 'chapter'

# -- Options for Epub output ----------------------------------------------

# Bibliographic Dublin Core info.
epub_title = "Provider Service Module user manual"
epub_author = "Open Tech Strategies"
epub_publisher = "Open Tech Strategies https://github.com/OpenTechStrategies/psm/"
epub_copyright = copyright

# The unique identifier of the text. This can be a ISBN number
# or the project homepage.
#
# epub_identifier = 'PSM'

# A unique identification for the text.

epub_uid = 'psm-documentation'

# A list of files that should not be packed into the epub file.
epub_exclude_files = ['search.html']

epub_show_urls = 'footnote'

epub_use_index = True

# Example configuration for intersphinx: refer to the Python standard library.
intersphinx_mapping = {'https://docs.python.org/': None}
