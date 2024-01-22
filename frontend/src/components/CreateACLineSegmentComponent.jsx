import React, { Component } from 'react'
import ACLineSegmentService from '../services/ACLineSegmentService';

class CreateACLineSegmentComponent extends Component {
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
            ACLineSegmentService.getACLineSegmentById(this.state.id).then( (res) =>{
                let aCLineSegment = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateACLineSegment = (e) => {
        e.preventDefault();
        let aCLineSegment = {
                aCLineSegmentId: this.state.id,
            };
        console.log('aCLineSegment => ' + JSON.stringify(aCLineSegment));

        // step 5
        if(this.state.id === '_add'){
            aCLineSegment.aCLineSegmentId=''
            ACLineSegmentService.createACLineSegment(aCLineSegment).then(res =>{
                this.props.history.push('/aCLineSegments');
            });
        }else{
            ACLineSegmentService.updateACLineSegment(aCLineSegment).then( res => {
                this.props.history.push('/aCLineSegments');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/aCLineSegments');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ACLineSegment</h3>
        }else{
            return <h3 className="text-center">Update ACLineSegment</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateACLineSegment}>Save</button>
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

export default CreateACLineSegmentComponent
