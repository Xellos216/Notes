#!/bin/bash

if [ -z "$1" ]; then
  echo "❌ Please enter a problem number or 'random'."
  echo "📘 Usage: ./typer.sh [problem_number|random]"
  exit 1
fi

PROBLEM_NUM="$1"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROBLEMS_DIR="$SCRIPT_DIR/Problems"

if [ "$1" = "random" ]; then
  RANDOM_DIR=$(ls -d "$PROBLEMS_DIR"/[0-9][0-9]_*/ 2>/dev/null | shuf -n1)
  PROBLEM_NUM=$(basename "$RANDOM_DIR" | cut -d_ -f1)
  echo ""
  echo "🎲 Random Question: $(basename "$RANDOM_DIR")"
fi

BASE_DIR=$(find "$PROBLEMS_DIR" -maxdepth 1 -type d -name "${PROBLEM_NUM}*" | head -n 1)
README_FILE="$BASE_DIR/README.md"
TMP_FILE="/tmp/typer_input_$$.txt"

echo ""
if [ -f "$README_FILE" ]; then
  awk '/^## 🧠 Problem/,/^---/' "$README_FILE"
  echo ""
else
  echo "❌ README.md not found in: $BASE_DIR"
  exit 1
fi

echo "✍️  [Enter your code below, then press Ctrl + D to submit]"
cat > "$TMP_FILE"
echo ""
echo ""
echo "---"

echo ""
echo "✅ [Reference Code]"
REF_FILE=$(find "$BASE_DIR" -maxdepth 1 -type f -name "*_answer.py" | head -n 1)
if [ -f "$REF_FILE" ]; then
  cat "$REF_FILE"
else
  awk '/^```python/{flag=1; next} /^```/{flag=0} flag' "$README_FILE"
fi

echo ""
echo "📝 [Your Input]"
cat "$TMP_FILE"

echo ""
rm "$TMP_FILE"
echo ""

