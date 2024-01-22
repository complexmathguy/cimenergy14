import React, { Component } from 'react'
import UnderexcLimX1Service from '../services/UnderexcLimX1Service';

class CreateUnderexcLimX1Component extends Component {
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
            UnderexcLimX1Service.getUnderexcLimX1ById(this.state.id).then( (res) =>{
                let underexcLimX1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateUnderexcLimX1 = (e) => {
        e.preventDefault();
        let underexcLimX1 = {
                underexcLimX1Id: this.state.id,
            };
        console.log('underexcLimX1 => ' + JSON.stringify(underexcLimX1));

        // step 5
        if(this.state.id === '_add'){
            underexcLimX1.underexcLimX1Id=''
            UnderexcLimX1Service.createUnderexcLimX1(underexcLimX1).then(res =>{
                this.props.history.push('/underexcLimX1s');
            });
        }else{
            UnderexcLimX1Service.updateUnderexcLimX1(underexcLimX1).then( res => {
                this.props.history.push('/underexcLimX1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/underexcLimX1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLimX1</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLimX1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLimX1}>Save</button>
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

export default CreateUnderexcLimX1Component
