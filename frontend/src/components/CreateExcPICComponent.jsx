import React, { Component } from 'react'
import ExcPICService from '../services/ExcPICService';

class CreateExcPICComponent extends Component {
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
            ExcPICService.getExcPICById(this.state.id).then( (res) =>{
                let excPIC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcPIC = (e) => {
        e.preventDefault();
        let excPIC = {
                excPICId: this.state.id,
            };
        console.log('excPIC => ' + JSON.stringify(excPIC));

        // step 5
        if(this.state.id === '_add'){
            excPIC.excPICId=''
            ExcPICService.createExcPIC(excPIC).then(res =>{
                this.props.history.push('/excPICs');
            });
        }else{
            ExcPICService.updateExcPIC(excPIC).then( res => {
                this.props.history.push('/excPICs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excPICs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcPIC</h3>
        }else{
            return <h3 className="text-center">Update ExcPIC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcPIC}>Save</button>
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

export default CreateExcPICComponent
