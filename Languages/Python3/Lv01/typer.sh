#!/bin/bash

if [ -z "$1" ]; then
  echo "❌ Please enter a problem number or 'random'."
  echo "📘 Usage: ./typer.sh [problem_number|random]"
  exit 1
fi

PROBLEM_NUM=$1

if [ "$1" = "random" ]; then
  RANDOM_DIR=$(ls -d [0-9][0-9]_*/ 2>/dev/null | shuf -n1)
  PROBLEM_NUM=$(echo "$RANDOM_DIR" | cut -d_ -f1)
  echo ""
  echo "🎲 Random Question: $RANDOM_DIR"
fi

BASE_DIR=$(find . -maxdepth 1 -type d -name "${PROBLEM_NUM}_*" | head -n 1)
README_FILE="$BASE_DIR/README.md"
TMP_FILE="/tmp/typer_input_$$.txt"

echo ""
if [ -f "$README_FILE" ]; then
  awk '/^## 🧠 Problem/,/^---/' "$README_FILE"
  echo ""
fi

echo "✍️  [Enter your code below, then press Ctrl + D to submit]"
cat > "$TMP_FILE"
echo ""
echo "---"

echo ""
echo "✅ [Reference Code]"
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
