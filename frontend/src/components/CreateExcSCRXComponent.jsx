import React, { Component } from 'react'
import ExcSCRXService from '../services/ExcSCRXService';

class CreateExcSCRXComponent extends Component {
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
            ExcSCRXService.getExcSCRXById(this.state.id).then( (res) =>{
                let excSCRX = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcSCRX = (e) => {
        e.preventDefault();
        let excSCRX = {
                excSCRXId: this.state.id,
            };
        console.log('excSCRX => ' + JSON.stringify(excSCRX));

        // step 5
        if(this.state.id === '_add'){
            excSCRX.excSCRXId=''
            ExcSCRXService.createExcSCRX(excSCRX).then(res =>{
                this.props.history.push('/excSCRXs');
            });
        }else{
            ExcSCRXService.updateExcSCRX(excSCRX).then( res => {
                this.props.history.push('/excSCRXs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excSCRXs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcSCRX</h3>
        }else{
            return <h3 className="text-center">Update ExcSCRX</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcSCRX}>Save</button>
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

export default CreateExcSCRXComponent
