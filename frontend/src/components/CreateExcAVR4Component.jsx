import React, { Component } from 'react'
import ExcAVR4Service from '../services/ExcAVR4Service';

class CreateExcAVR4Component extends Component {
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
            ExcAVR4Service.getExcAVR4ById(this.state.id).then( (res) =>{
                let excAVR4 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAVR4 = (e) => {
        e.preventDefault();
        let excAVR4 = {
                excAVR4Id: this.state.id,
            };
        console.log('excAVR4 => ' + JSON.stringify(excAVR4));

        // step 5
        if(this.state.id === '_add'){
            excAVR4.excAVR4Id=''
            ExcAVR4Service.createExcAVR4(excAVR4).then(res =>{
                this.props.history.push('/excAVR4s');
            });
        }else{
            ExcAVR4Service.updateExcAVR4(excAVR4).then( res => {
                this.props.history.push('/excAVR4s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAVR4s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAVR4</h3>
        }else{
            return <h3 className="text-center">Update ExcAVR4</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAVR4}>Save</button>
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

export default CreateExcAVR4Component
