export interface IArticleData {
  id: number
  status: string
  title: string
  abstractContent: string
  fullContent: string
  sourceURL: string
  imageURL: string
  timestamp: string | number
  platforms: string[]
  disableComment: boolean
  importance: number
  author: string
  reviewer: string
  type: string
  pageviews: number
}

export interface IHouseData {
  id:number
  name:string
  description:string;
  deletedAt?:null;
  createdAt:string;
  updatedAt:string;
}

export interface IBuildData {
  name:string;
  layer:number;
  sequenceInLayer:number;
  price:number;
  state:string;
}