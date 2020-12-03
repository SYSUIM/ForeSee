## 智能检索：词向量 | 段落级别

### Bert-As-Service

#### 模块功能定位

​	实现智能检索，用户输入检索词，结果返回与检索词的相似度最高的结果。

#### 实现逻辑

- 编码实现：bert模型，bert-as-servise的API
- 词向量的存储：提前将需要匹配的字段进行编码，存储
- 相似度排序：将检索词进行编码，遍历每个编码好的字段，计算相似度，排序。

#### 代码设计及解读

1. 将含有检索需要匹配信息的字段进行编码，以json格式存储。

- 编码字段
  - 公司名称 asmc
  - A股简称 agjc
  - 所属东财行业 sshy
  - 所属证监会行业 sszjhhy
  - 公司简介 gsjj
- json存储路径：/data/prj2020/EnterPriseSpider/Vector

2. 对检索词进行编码

- 输入：检索词（String格式）
- 输出：词向量（list格式）

2. 计算两个词向量之间的相似度

- 输入：两个词向量（list格式）
- 输出：相似度(float格式)

### TransformerXL

#### 模块功能定位

当前的bert模型的封装性较高，难以根据数据集的特征进行参数调整，因此，在已有的bert的基础上，用TransformerXL计算词向量，优化相似度的计算。

#### 代码框架

```python
# 加载pretrained模型/分词器
tokenizer = tokenizer_class.from_pretrained(pretrained_weights)
model = model_class.from_pretrained(pretrained_weights)

# 编码文本
index = torch.tensor([tokenizer.encode('文本')])  # 添加特殊标记
vec = model(index)
```

#### Future Work

* 根据数据和模型特征调整参数，调优模型
* 根据优化的模型得到的向量，进行模型间的向量比较和集成，得到最优向量