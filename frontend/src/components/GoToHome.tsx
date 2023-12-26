import { useNavigate } from 'react-router-dom'

export const GoToHome = () => {
    const router = useNavigate()
    const handleHome = () => {
        router("/")
    }
  return (
    <button onClick={handleHome} className='p-3 bg-black text-white'>Go Home</button>
  )
}
