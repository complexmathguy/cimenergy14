import React, { Component } from 'react'
import ACLineSegmentService from '../services/ACLineSegmentService';

class UpdateACLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateACLineSegment = this.updateACLineSegment.bind(this);

    }

    componentDidMount(){
        ACLineSegmentService.getACLineSegmentById(this.state.id).then( (res) =>{
            let aCLineSegment = res.data;
            this.setState({
            });
        });
    }

    updateACLineSegment = (e) => {
        e.preventDefault();
        let aCLineSegment = {
            aCLineSegmentId: this.state.id,
        };
        console.log('aCLineSegment => ' + JSON.stringify(aCLineSegment));
        console.log('id => ' + JSON.stringify(this.state.id));
        ACLineSegmentService.updateACLineSegment(aCLineSegment).then( res => {
            this.props.history.push('/aCLineSegments');
        });
    }


    cancel(){
        this.props.history.push('/aCLineSegments');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ACLineSegment</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateACLineSegment}>Save</button>
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

export default UpdateACLineSegmentComponent
