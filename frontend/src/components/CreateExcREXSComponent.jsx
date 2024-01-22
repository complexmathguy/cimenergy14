import React, { Component } from 'react'
import ExcREXSService from '../services/ExcREXSService';

class CreateExcREXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                fbf: ''
        }
        this.changeFbfHandler = this.changeFbfHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcREXSService.getExcREXSById(this.state.id).then( (res) =>{
                let excREXS = res.data;
                this.setState({
                    fbf: excREXS.fbf
                });
            });
        }        
    }
    saveOrUpdateExcREXS = (e) => {
        e.preventDefault();
        let excREXS = {
                excREXSId: this.state.id,
                fbf: this.state.fbf
            };
        console.log('excREXS => ' + JSON.stringify(excREXS));

        // step 5
        if(this.state.id === '_add'){
            excREXS.excREXSId=''
            ExcREXSService.createExcREXS(excREXS).then(res =>{
                this.props.history.push('/excREXSs');
            });
        }else{
            ExcREXSService.updateExcREXS(excREXS).then( res => {
                this.props.history.push('/excREXSs');
            });
        }
    }
    
    changeFbfHandler= (event) => {
        this.setState({fbf: event.target.value});
    }

    cancel(){
        this.props.history.push('/excREXSs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcREXS</h3>
        }else{
            return <h3 className="text-center">Update ExcREXS</h3>
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
                                            <label> Fbf: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcREXS}>Save</button>
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

export default CreateExcREXSComponent
