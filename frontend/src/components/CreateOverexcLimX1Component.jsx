import React, { Component } from 'react'
import OverexcLimX1Service from '../services/OverexcLimX1Service';

class CreateOverexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            OverexcLimX1Service.getOverexcLimX1ById(this.state.id).then( (res) =>{
                let overexcLimX1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateOverexcLimX1 = (e) => {
        e.preventDefault();
        let overexcLimX1 = {
                overexcLimX1Id: this.state.id,
            };
        console.log('overexcLimX1 => ' + JSON.stringify(overexcLimX1));

        // step 5
        if(this.state.id === '_add'){
            overexcLimX1.overexcLimX1Id=''
            OverexcLimX1Service.createOverexcLimX1(overexcLimX1).then(res =>{
                this.props.history.push('/overexcLimX1s');
            });
        }else{
            OverexcLimX1Service.updateOverexcLimX1(overexcLimX1).then( res => {
                this.props.history.push('/overexcLimX1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/overexcLimX1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcLimX1</h3>
        }else{
            return <h3 className="text-center">Update OverexcLimX1</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcLimX1}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateOverexcLimX1Component
