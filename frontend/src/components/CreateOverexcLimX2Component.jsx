import React, { Component } from 'react'
import OverexcLimX2Service from '../services/OverexcLimX2Service';

class CreateOverexcLimX2Component extends Component {
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
            OverexcLimX2Service.getOverexcLimX2ById(this.state.id).then( (res) =>{
                let overexcLimX2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateOverexcLimX2 = (e) => {
        e.preventDefault();
        let overexcLimX2 = {
                overexcLimX2Id: this.state.id,
            };
        console.log('overexcLimX2 => ' + JSON.stringify(overexcLimX2));

        // step 5
        if(this.state.id === '_add'){
            overexcLimX2.overexcLimX2Id=''
            OverexcLimX2Service.createOverexcLimX2(overexcLimX2).then(res =>{
                this.props.history.push('/overexcLimX2s');
            });
        }else{
            OverexcLimX2Service.updateOverexcLimX2(overexcLimX2).then( res => {
                this.props.history.push('/overexcLimX2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/overexcLimX2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcLimX2</h3>
        }else{
            return <h3 className="text-center">Update OverexcLimX2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcLimX2}>Save</button>
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

export default CreateOverexcLimX2Component
