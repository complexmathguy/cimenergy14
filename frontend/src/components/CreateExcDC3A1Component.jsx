import React, { Component } from 'react'
import ExcDC3A1Service from '../services/ExcDC3A1Service';

class CreateExcDC3A1Component extends Component {
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
            ExcDC3A1Service.getExcDC3A1ById(this.state.id).then( (res) =>{
                let excDC3A1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcDC3A1 = (e) => {
        e.preventDefault();
        let excDC3A1 = {
                excDC3A1Id: this.state.id,
            };
        console.log('excDC3A1 => ' + JSON.stringify(excDC3A1));

        // step 5
        if(this.state.id === '_add'){
            excDC3A1.excDC3A1Id=''
            ExcDC3A1Service.createExcDC3A1(excDC3A1).then(res =>{
                this.props.history.push('/excDC3A1s');
            });
        }else{
            ExcDC3A1Service.updateExcDC3A1(excDC3A1).then( res => {
                this.props.history.push('/excDC3A1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excDC3A1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcDC3A1</h3>
        }else{
            return <h3 className="text-center">Update ExcDC3A1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcDC3A1}>Save</button>
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

export default CreateExcDC3A1Component
