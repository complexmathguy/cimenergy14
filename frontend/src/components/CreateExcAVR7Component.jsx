import React, { Component } from 'react'
import ExcAVR7Service from '../services/ExcAVR7Service';

class CreateExcAVR7Component extends Component {
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
            ExcAVR7Service.getExcAVR7ById(this.state.id).then( (res) =>{
                let excAVR7 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAVR7 = (e) => {
        e.preventDefault();
        let excAVR7 = {
                excAVR7Id: this.state.id,
            };
        console.log('excAVR7 => ' + JSON.stringify(excAVR7));

        // step 5
        if(this.state.id === '_add'){
            excAVR7.excAVR7Id=''
            ExcAVR7Service.createExcAVR7(excAVR7).then(res =>{
                this.props.history.push('/excAVR7s');
            });
        }else{
            ExcAVR7Service.updateExcAVR7(excAVR7).then( res => {
                this.props.history.push('/excAVR7s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAVR7s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAVR7</h3>
        }else{
            return <h3 className="text-center">Update ExcAVR7</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAVR7}>Save</button>
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

export default CreateExcAVR7Component
