# Integrity-Verification-System-Emulation

Project Description:
This project explores Merkle Trees, a crucial tree data structure with applications in cryptography, networking, and blockchain technology like Bitcoin. Merkle Trees ensure data authenticity using cryptographic hash functions, making them valuable for detecting tampering.

Problem Statement:
Imagine a user storing files in a cloud service but wanting to verify the downloaded files' integrity. We need a way to prove that a downloaded file matches the original. This project utilizes Merkle Trees to provide this proof.

Merkle Trees Basics:
Merkle Trees are binary trees.
Each leaf node stores a file.
Non-leaf nodes store hashes of their children.
Depth = log₂(number of files).

Input files are represented as strings for abstraction. After creating a Merkel tree with the input files, any tampering with the files would cause the root hash to change signifying that the files are not secure.
