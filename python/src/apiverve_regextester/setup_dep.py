from setuptools import setup, find_packages

setup(
    name='apiverve_regextester',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Regex Tester tests regular expressions against input strings across operations like match, search, replace, and split. It reports compilation validity, syntax error details, execution timing, and structural pattern analysis.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/regextester?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
