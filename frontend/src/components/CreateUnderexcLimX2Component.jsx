import React, { Component } from 'react'
import UnderexcLimX2Service from '../services/UnderexcLimX2Service';

class CreateUnderexcLimX2Component extends Component {
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
            UnderexcLimX2Service.getUnderexcLimX2ById(this.state.id).then( (res) =>{
                let underexcLimX2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateUnderexcLimX2 = (e) => {
        e.preventDefault();
        let underexcLimX2 = {
                underexcLimX2Id: this.state.id,
            };
        console.log('underexcLimX2 => ' + JSON.stringify(underexcLimX2));

        // step 5
        if(this.state.id === '_add'){
            underexcLimX2.underexcLimX2Id=''
            UnderexcLimX2Service.createUnderexcLimX2(underexcLimX2).then(res =>{
                this.props.history.push('/underexcLimX2s');
            });
        }else{
            UnderexcLimX2Service.updateUnderexcLimX2(underexcLimX2).then( res => {
                this.props.history.push('/underexcLimX2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/underexcLimX2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLimX2</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLimX2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLimX2}>Save</button>
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

export default CreateUnderexcLimX2Component
