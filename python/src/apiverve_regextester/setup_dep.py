from setuptools import setup, find_packages

setup(
    name='apiverve_regextester',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Regex Tester is a comprehensive tool for testing and validating regular expressions. It supports multiple operations (test, match, search, replace, split) with detailed performance analysis and pattern suggestions.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
