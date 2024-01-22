import React, { Component } from 'react'
import OverexcLimIEEEService from '../services/OverexcLimIEEEService';

class CreateOverexcLimIEEEComponent extends Component {
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
            OverexcLimIEEEService.getOverexcLimIEEEById(this.state.id).then( (res) =>{
                let overexcLimIEEE = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateOverexcLimIEEE = (e) => {
        e.preventDefault();
        let overexcLimIEEE = {
                overexcLimIEEEId: this.state.id,
            };
        console.log('overexcLimIEEE => ' + JSON.stringify(overexcLimIEEE));

        // step 5
        if(this.state.id === '_add'){
            overexcLimIEEE.overexcLimIEEEId=''
            OverexcLimIEEEService.createOverexcLimIEEE(overexcLimIEEE).then(res =>{
                this.props.history.push('/overexcLimIEEEs');
            });
        }else{
            OverexcLimIEEEService.updateOverexcLimIEEE(overexcLimIEEE).then( res => {
                this.props.history.push('/overexcLimIEEEs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/overexcLimIEEEs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcLimIEEE</h3>
        }else{
            return <h3 className="text-center">Update OverexcLimIEEE</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcLimIEEE}>Save</button>
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

export default CreateOverexcLimIEEEComponent
