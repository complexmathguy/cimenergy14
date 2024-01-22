import React, { Component } from 'react'
import OverexcLim2Service from '../services/OverexcLim2Service';

class CreateOverexcLim2Component extends Component {
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
            OverexcLim2Service.getOverexcLim2ById(this.state.id).then( (res) =>{
                let overexcLim2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateOverexcLim2 = (e) => {
        e.preventDefault();
        let overexcLim2 = {
                overexcLim2Id: this.state.id,
            };
        console.log('overexcLim2 => ' + JSON.stringify(overexcLim2));

        // step 5
        if(this.state.id === '_add'){
            overexcLim2.overexcLim2Id=''
            OverexcLim2Service.createOverexcLim2(overexcLim2).then(res =>{
                this.props.history.push('/overexcLim2s');
            });
        }else{
            OverexcLim2Service.updateOverexcLim2(overexcLim2).then( res => {
                this.props.history.push('/overexcLim2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/overexcLim2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcLim2</h3>
        }else{
            return <h3 className="text-center">Update OverexcLim2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcLim2}>Save</button>
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

export default CreateOverexcLim2Component
