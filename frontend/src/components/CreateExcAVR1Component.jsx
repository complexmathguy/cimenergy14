import React, { Component } from 'react'
import ExcAVR1Service from '../services/ExcAVR1Service';

class CreateExcAVR1Component extends Component {
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
            ExcAVR1Service.getExcAVR1ById(this.state.id).then( (res) =>{
                let excAVR1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAVR1 = (e) => {
        e.preventDefault();
        let excAVR1 = {
                excAVR1Id: this.state.id,
            };
        console.log('excAVR1 => ' + JSON.stringify(excAVR1));

        // step 5
        if(this.state.id === '_add'){
            excAVR1.excAVR1Id=''
            ExcAVR1Service.createExcAVR1(excAVR1).then(res =>{
                this.props.history.push('/excAVR1s');
            });
        }else{
            ExcAVR1Service.updateExcAVR1(excAVR1).then( res => {
                this.props.history.push('/excAVR1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAVR1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAVR1</h3>
        }else{
            return <h3 className="text-center">Update ExcAVR1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAVR1}>Save</button>
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

export default CreateExcAVR1Component
