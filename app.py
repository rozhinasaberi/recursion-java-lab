import streamlit as st


def star_pattern(n: int) -> str:
    up = ["*" * i for i in range(1, n + 1)]
    down = ["*" * i for i in range(n - 1, 0, -1)]
    return "\n".join(up + down)


def count_vowels(text: str) -> int:
    return sum(1 for ch in text.lower() if ch in "aeiou")


def search_tree(tree: dict, target: str, path: str = "") -> list[str]:
    matches = []
    for name, child in tree.items():
        current = f"{path}/{name}" if path else name
        if name == target:
            matches.append(current)
        if isinstance(child, dict):
            matches.extend(search_tree(child, target, current))
    return matches


SAMPLE_TREE = {
    "Documents": {
        "notes.txt": None,
        "Projects": {
            "lab3": {"report.docx": None, "notes.txt": None},
            "images": {"photo.png": None},
        },
    }
}

st.set_page_config(page_title="Recursion Tutor", page_icon="🔁", layout="wide")

st.title("🔁 Recursion Tutor")
st.write(
    "This tutor app explains the recursive thinking used in COMP254 Lab 3 through patterns, text processing, and file-search style traversal."
)

tab1, tab2, tab3 = st.tabs(["Pattern Builder", "Vowel Counter", "File Search Simulator"])

with tab1:
    n = st.slider("Maximum stars", 1, 10, 5)
    st.code(star_pattern(n), language="text")
    st.info("The recursive idea is: solve the smaller pattern first, then add the current row.")

with tab2:
    text = st.text_input("Enter text", "Hello recursion world")
    total = count_vowels(text)
    st.metric("Vowels found", total)
    st.write("The Java version checks one character, then calls itself on the rest of the string.")

with tab3:
    target = st.text_input("File name to search for", "notes.txt")
    matches = search_tree(SAMPLE_TREE, target)
    st.write("Sample directory tree:")
    st.json(SAMPLE_TREE)
    if matches:
        st.success(f"Matches: {', '.join(matches)}")
    else:
        st.warning("No matches found in the sample tree.")
    st.caption("This mirrors the Java lab idea of recursively exploring folders and collecting all matching paths.")
