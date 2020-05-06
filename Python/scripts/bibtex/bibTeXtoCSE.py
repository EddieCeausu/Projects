import bibtexparser
'''
bibtex = @article{gilbert2018statistical,
  title={Statistical learning methods to determine immune correlates of herpes zoster in vaccine efficacy trials},
  author={Gilbert, Peter B and Luedtke, Alexander R},
  journal={The Journal of infectious diseases},
  volume={218},
  number={suppl\_2},
  pages={S99--S101},
  year={2018},
  publisher={Oxford University Press US}
}
'''
with open('scholar.bib') as bibtex:
    bibData = bibtexparser.load(bibtex)

# print(bibData.entries[0])

bibDataEntries = bibData.entries[0]

cse = bibDataEntries['author'] + '. ' + '(' + bibDataEntries['year'] + ') ' + bibDataEntries['title'] + '. ' + bibDataEntries['journal'] + ' ' + bibDataEntries['volume'] + ', ' + bibDataEntries['pages']

print('\n', cse)
