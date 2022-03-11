import React from 'react'

export default function Film({filmName, releaseDate, money}) {
  return (
    <>
        <h1>{filmName}</h1>
        <h1>{releaseDate}</h1>
        <h1>{money}</h1>
    </>
  )
}
