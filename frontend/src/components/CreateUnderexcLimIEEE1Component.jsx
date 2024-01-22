import React, { Component } from 'react'
import UnderexcLimIEEE1Service from '../services/UnderexcLimIEEE1Service';

class CreateUnderexcLimIEEE1Component extends Component {
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
            UnderexcLimIEEE1Service.getUnderexcLimIEEE1ById(this.state.id).then( (res) =>{
                let underexcLimIEEE1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateUnderexcLimIEEE1 = (e) => {
        e.preventDefault();
        let underexcLimIEEE1 = {
                underexcLimIEEE1Id: this.state.id,
            };
        console.log('underexcLimIEEE1 => ' + JSON.stringify(underexcLimIEEE1));

        // step 5
        if(this.state.id === '_add'){
            underexcLimIEEE1.underexcLimIEEE1Id=''
            UnderexcLimIEEE1Service.createUnderexcLimIEEE1(underexcLimIEEE1).then(res =>{
                this.props.history.push('/underexcLimIEEE1s');
            });
        }else{
            UnderexcLimIEEE1Service.updateUnderexcLimIEEE1(underexcLimIEEE1).then( res => {
                this.props.history.push('/underexcLimIEEE1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/underexcLimIEEE1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLimIEEE1</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLimIEEE1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLimIEEE1}>Save</button>
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

export default CreateUnderexcLimIEEE1Component
