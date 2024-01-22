/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.entity;

import java.util.*

import javax.persistence.*
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery

import com.occulue.api.*;

// --------------------------------------------
// Entity Definitions
// --------------------------------------------
@Entity
data class ACDCConverter(
    @Id var aCDCConverterId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseS") var baseS: ApparentPower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "idleLoss") var idleLoss: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxUdc") var maxUdc: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minUdc") var minUdc: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "numberOfValves") var numberOfValves: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedUdc") var ratedUdc: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "resistiveLoss") var resistiveLoss: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "switchingLoss") var switchingLoss: ActivePowerPerCurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "valveU0") var valveU0: Voltage? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "converterDCSides") var converterDCSides:  Set<ACDCConverter>? = null
)

@Entity
data class ACDCConverterDCTerminal(
    @Id var aCDCConverterDCTerminalId: UUID? = null,
    @Enumerated(EnumType.STRING) var polarity: DCPolarityKind? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "dCTerminals") var dCTerminals:  Set<ACDCConverterDCTerminal>? = null
)

@Entity
data class ACDCTerminal(
    @Id var aCDCTerminalId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sequenceNumber") var sequenceNumber: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "terminal") var terminal:  Set<ACDCTerminal>? = null
)

@Entity
data class ACLineSegment(
    @Id var aCLineSegmentId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b0ch") var b0ch: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bch") var bch: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g0ch") var g0ch: Conductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gch") var gch: Conductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r0") var r0: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortCircuitEndTemperature") var shortCircuitEndTemperature: Temperature? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x") var x: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x0") var x0: Reactance? = null
)

@Entity
data class Accumulator(
     var accumulatorId: UUID? = null
)

@Entity
data class AccumulatorLimit(
    @Id var accumulatorLimitId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "limits") var limits:  Set<AccumulatorLimit>? = null
)

@Entity
data class AccumulatorLimitSet(
    @Id var accumulatorLimitSetId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "limitSets") var limitSets:  Set<AccumulatorLimitSet>? = null
)

@Entity
data class AccumulatorReset(
    @Id var accumulatorResetId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "accumulatorReset") var accumulatorReset: AccumulatorReset? = null
)

@Entity
data class AccumulatorValue(
    @Id var accumulatorValueId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "accumulatorValues") var accumulatorValues:  Set<AccumulatorValue>? = null
)

@Entity
data class ActivePower(
    @Id var activePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class ActivePowerLimit(
    @Id var activePowerLimitId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: ActivePower? = null
)

@Entity
data class ActivePowerPerCurrentFlow(
     var activePowerPerCurrentFlowId: UUID? = null
)

@Entity
data class ActivePowerPerFrequency(
    @Id var activePowerPerFrequencyId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class Analog(
    @Id var analogId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "positiveFlowIn") var positiveFlowIn: BooleanProxy? = null
)

@Entity
data class AnalogControl(
    @Id var analogControlId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxValue") var maxValue: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minValue") var minValue: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "analogControl") var analogControl: AnalogControl? = null
)

@Entity
data class AnalogLimit(
    @Id var analogLimitId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: Simple_Float? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "limits") var limits:  Set<AnalogLimit>? = null
)

@Entity
data class AnalogLimitSet(
    @Id var analogLimitSetId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "limitSets") var limitSets:  Set<AnalogLimitSet>? = null
)

@Entity
data class AnalogValue(
    @Id var analogValueId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: Simple_Float? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "analogValues") var analogValues:  Set<AnalogValue>? = null
)

@Entity
data class AngleDegrees(
    @Id var angleDegreesId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class AngleRadians(
    @Id var angleRadiansId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class ApparentPower(
    @Id var apparentPowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class ApparentPowerLimit(
    @Id var apparentPowerLimitId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: ApparentPower? = null
)

@Entity
data class Area(
    @Id var areaId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class AsynchronousMachine(
    @Id var asynchronousMachineId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "converterFedDrive") var converterFedDrive: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efficiency") var efficiency: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "iaIrRatio") var iaIrRatio: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nominalFrequency") var nominalFrequency: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nominalSpeed") var nominalSpeed: RotationSpeed? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "polePairNumber") var polePairNumber: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedMechanicalPower") var ratedMechanicalPower: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "reversible") var reversible: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rxLockedRotorRatio") var rxLockedRotorRatio: Simple_Float? = null
)

@Entity
data class AsynchronousMachineDynamics(
    @Id var asynchronousMachineDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "asynchronousMachineDynamics") var asynchronousMachineDynamics: AsynchronousMachineDynamics? = null
)

@Entity
data class AsynchronousMachineEquivalentCircuit(
    @Id var asynchronousMachineEquivalentCircuitId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rr1") var rr1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rr2") var rr2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xlr1") var xlr1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xlr2") var xlr2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xm") var xm: PU? = null
)

@Entity
data class AsynchronousMachineTimeConstantReactance(
    @Id var asynchronousMachineTimeConstantReactanceId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpo") var tpo: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tppo") var tppo: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xp") var xp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xpp") var xpp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xs") var xs: PU? = null
)

@Entity
data class AsynchronousMachineUserDefined(
    @Id var asynchronousMachineUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class BaseVoltage(
    @Id var baseVoltageId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nominalVoltage") var nominalVoltage: Voltage? = null
)

@Entity
data class BasicIntervalSchedule(
    @Id var basicIntervalScheduleId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "startTime") var startTime: DateTime? = null,
    @Enumerated(EnumType.STRING) var value1Unit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var value2Unit: UnitSymbol? = null
)

@Entity
data class Bay(
    @Id var bayId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "bays") var bays:  Set<Bay>? = null
)

@Entity
data class BooleanProxy(
     var booleanProxyId: UUID? = null
)

@Entity
data class BoundaryExtensions(
    @Id var boundaryExtensionsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "boundaryPoint") var boundaryPoint: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndIsoCode") var fromEndIsoCode: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndName") var fromEndName: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndNameTso") var fromEndNameTso: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndIsoCode") var toEndIsoCode: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndName") var toEndName: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndNameTso") var toEndNameTso: StringProxy? = null
)

@Entity
data class Breaker(
     var breakerId: UUID? = null
)

@Entity
data class BusNameMarker(
    @Id var busNameMarkerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "priority") var priority: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "busNameMarker") var busNameMarker:  Set<BusNameMarker>? = null
)

@Entity
data class BusbarSection(
    @Id var busbarSectionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ipMax") var ipMax: CurrentFlow? = null
)

@Entity
data class Capacitance(
    @Id var capacitanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class CapacitancePerLength(
    @Id var capacitancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class Command(
    @Id var commandId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "normalValue") var normalValue: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "commands") var commands:  Set<Command>? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "command") var command: Command? = null
)

@Entity
data class Conductance(
    @Id var conductanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class ConductingEquipment(
     var conductingEquipmentId: UUID? = null
)

@Entity
data class Conductor(
    @Id var conductorId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "length") var length: Length? = null
)

@Entity
data class ConformLoad(
    @Id var conformLoadId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "energyConsumers") var energyConsumers:  Set<ConformLoad>? = null
)

@Entity
data class ConformLoadGroup(
     var conformLoadGroupId: UUID? = null
)

@Entity
data class ConformLoadSchedule(
    @Id var conformLoadScheduleId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "conformLoadSchedules") var conformLoadSchedules:  Set<ConformLoadSchedule>? = null
)

@Entity
data class ConnectivityNode(
    @Id var connectivityNodeId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "boundaryPoint") var boundaryPoint: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndIsoCode") var fromEndIsoCode: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndName") var fromEndName: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndNameTso") var fromEndNameTso: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndIsoCode") var toEndIsoCode: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndName") var toEndName: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndNameTso") var toEndNameTso: StringProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "connectivityNodes") var connectivityNodes:  Set<ConnectivityNode>? = null
)

@Entity
data class ConnectivityNodeContainer(
     var connectivityNodeContainerId: UUID? = null
)

@Entity
data class Connector(
     var connectorId: UUID? = null
)

@Entity
data class Control(
    @Id var controlId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "controlType") var controlType: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "operationInProgress") var operationInProgress: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "timeStamp") var timeStamp: DateTime? = null,
    @Enumerated(EnumType.STRING) var unitMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unitSymbol: UnitSymbol? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "controls") var controls:  Set<Control>? = null
)

@Entity
data class ControlArea(
    @Id var controlAreaId: UUID? = null,
    @Enumerated(EnumType.STRING) var type: ControlAreaTypeKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "controlArea") var controlArea: ControlArea? = null
)

@Entity
data class ControlAreaGeneratingUnit(
    @Id var controlAreaGeneratingUnitId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "controlAreaGeneratingUnit") var controlAreaGeneratingUnit:  Set<ControlAreaGeneratingUnit>? = null
)

@Entity
data class CoordinateSystem(
    @Id var coordinateSystemId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "crsUrn") var crsUrn: StringProxy? = null
)

@Entity
data class CsConverter(
    @Id var csConverterId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxAlpha") var maxAlpha: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxGamma") var maxGamma: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxIdc") var maxIdc: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minAlpha") var minAlpha: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minGamma") var minGamma: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minIdc") var minIdc: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedIdc") var ratedIdc: CurrentFlow? = null
)

@Entity
data class CurrentFlow(
    @Id var currentFlowId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class CurrentLimit(
    @Id var currentLimitId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: CurrentFlow? = null
)

@Entity
data class Curve(
    @Id var curveId: UUID? = null,
    @Enumerated(EnumType.STRING) var curveStyle: CurveStyle? = null,
    @Enumerated(EnumType.STRING) var xUnit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var y1Unit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var y2Unit: UnitSymbol? = null
)

@Entity
data class CurveData(
    @Id var curveDataId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xvalue") var xvalue: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "y1value") var y1value: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "y2value") var y2value: Simple_Float? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "curveDatas") var curveDatas:  Set<CurveData>? = null
)

@Entity
data class DCBaseTerminal(
    @Id var dCBaseTerminalId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "dCTerminals") var dCTerminals:  Set<DCBaseTerminal>? = null
)

@Entity
data class DCBreaker(
     var dCBreakerId: UUID? = null
)

@Entity
data class DCBusbar(
     var dCBusbarId: UUID? = null
)

@Entity
data class DCChopper(
     var dCChopperId: UUID? = null
)

@Entity
data class DCConductingEquipment(
     var dCConductingEquipmentId: UUID? = null
)

@Entity
data class DCConverterUnit(
    @Id var dCConverterUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var operationMode: DCConverterOperatingModeKind? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "dCConverterUnit") var dCConverterUnit:  Set<DCConverterUnit>? = null
)

@Entity
data class DCDisconnector(
     var dCDisconnectorId: UUID? = null
)

@Entity
data class DCEquipmentContainer(
     var dCEquipmentContainerId: UUID? = null
)

@Entity
data class DCGround(
    @Id var dCGroundId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inductance") var inductance: Inductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: Resistance? = null
)

@Entity
data class DCLine(
    @Id var dCLineId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "dCLines") var dCLines:  Set<DCLine>? = null
)

@Entity
data class DCLineSegment(
    @Id var dCLineSegmentId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "capacitance") var capacitance: Capacitance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inductance") var inductance: Inductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "length") var length: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "resistance") var resistance: Resistance? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "dCLineSegments") var dCLineSegments:  Set<DCLineSegment>? = null
)

@Entity
data class DCNode(
    @Id var dCNodeId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "dCNodes") var dCNodes:  Set<DCNode>? = null
)

@Entity
data class DCSeriesDevice(
    @Id var dCSeriesDeviceId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inductance") var inductance: Inductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedUdc") var ratedUdc: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "resistance") var resistance: Resistance? = null
)

@Entity
data class DCShunt(
    @Id var dCShuntId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "capacitance") var capacitance: Capacitance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedUdc") var ratedUdc: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "resistance") var resistance: Resistance? = null
)

@Entity
data class DCSwitch(
     var dCSwitchId: UUID? = null
)

@Entity
data class DCTerminal(
    @Id var dCTerminalId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "dCTerminals") var dCTerminals:  Set<DCTerminal>? = null
)

@Entity
data class DCTopologicalIsland(
    @Id var dCTopologicalIslandId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dCTopologicalIsland") var dCTopologicalIsland: DCTopologicalIsland? = null
)

@Entity
data class DCTopologicalNode(
    @Id var dCTopologicalNodeId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "dCTopologicalNode") var dCTopologicalNode:  Set<DCTopologicalNode>? = null
)

@Entity
data class DateProxy(
     var dateProxyId: UUID? = null
)

@Entity
data class DateTime(
     var dateTimeId: UUID? = null
)

@Entity
data class DayType(
     var dayTypeId: UUID? = null
)

@Entity
data class DecimalProxy(
     var decimalProxyId: UUID? = null
)

@Entity
data class Diagram(
    @Id var diagramId: UUID? = null,
    @Enumerated(EnumType.STRING) var orientation: OrientationKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x1InitialView") var x1InitialView: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x2InitialView") var x2InitialView: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "y1InitialView") var y1InitialView: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "y2InitialView") var y2InitialView: Simple_Float? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "diagram") var diagram:  Set<Diagram>? = null
)

@Entity
data class DiagramLayoutVersion(
    @Id var diagramLayoutVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURI") var baseURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURI") var entsoeURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class DiagramObject(
    @Id var diagramObjectId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "drawingOrder") var drawingOrder: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "polygonFlag") var polygonFlag: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "offsetX") var offsetX: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "offsetY") var offsetY: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rotation") var rotation: AngleDegrees? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "styledObjects") var styledObjects:  Set<DiagramObject>? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "diagramElements") var diagramElements:  Set<DiagramObject>? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "diagramObjects") var diagramObjects:  Set<DiagramObject>? = null
)

@Entity
data class DiagramObjectGluePoint(
     var diagramObjectGluePointId: UUID? = null
)

@Entity
data class DiagramObjectPoint(
    @Id var diagramObjectPointId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sequenceNumber") var sequenceNumber: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xPosition") var xPosition: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "yPosition") var yPosition: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zPosition") var zPosition: Simple_Float? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "diagramObjectPoints") var diagramObjectPoints:  Set<DiagramObjectPoint>? = null
)

@Entity
data class DiagramObjectStyle(
     var diagramObjectStyleId: UUID? = null
)

@Entity
data class DiagramStyle(
     var diagramStyleId: UUID? = null
)

@Entity
data class DiscExcContIEEEDEC1A(
    @Id var discExcContIEEEDEC1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "esc") var esc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kan") var kan: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ketl") var ketl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tan") var tan: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl1") var tl1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl2") var tl2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw5") var tw5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vanmax") var vanmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vomax") var vomax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vomin") var vomin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmax") var vsmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmin") var vsmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtc") var vtc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtlmt") var vtlmt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtm") var vtm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtn") var vtn: PU? = null
)

@Entity
data class DiscExcContIEEEDEC2A(
    @Id var discExcContIEEEDEC2AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td1") var td1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td2") var td2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vdmax") var vdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vdmin") var vdmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vk") var vk: PU? = null
)

@Entity
data class DiscExcContIEEEDEC3A(
    @Id var discExcContIEEEDEC3AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdr") var tdr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtmin") var vtmin: PU? = null
)

@Entity
data class Disconnector(
     var disconnectorId: UUID? = null
)

@Entity
data class DiscontinuousExcitationControlDynamics(
    @Id var discontinuousExcitationControlDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "discontinuousExcitationControlDynamics") var discontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics? = null
)

@Entity
data class DiscontinuousExcitationControlUserDefined(
    @Id var discontinuousExcitationControlUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class Discrete(
    @Id var discreteId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "discretes") var discretes:  Set<Discrete>? = null
)

@Entity
data class DiscreteValue(
    @Id var discreteValueId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "discreteValues") var discreteValues:  Set<DiscreteValue>? = null
)

@Entity
data class DomainVersion(
    @Id var domainVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "version") var version: StringProxy? = null
)

@Entity
data class DynamicsFunctionBlock(
    @Id var dynamicsFunctionBlockId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "enabled") var enabled: BooleanProxy? = null
)

@Entity
data class DynamicsVersion(
    @Id var dynamicsVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURI") var baseURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURI") var entsoeURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class Dynamicsmodel(
     var dynamicsmodelId: UUID? = null
)

@Entity
data class ENTSOEConnectivityNode(
     var eNTSOEConnectivityNodeId: UUID? = null
)

@Entity
data class ENTSOEIdentifiedObject(
    @Id var eNTSOEIdentifiedObjectId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "energyIdentCodeEic") var energyIdentCodeEic: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class ENTSOEJunction(
     var eNTSOEJunctionId: UUID? = null
)

@Entity
data class ENTSOEOperationalLimitType(
    @Id var eNTSOEOperationalLimitTypeId: UUID? = null,
    @Enumerated(EnumType.STRING) var limitType: LimitTypeKind? = null
)

@Entity
data class ENTSOETopologicalNode(
     var eNTSOETopologicalNodeId: UUID? = null
)

@Entity
data class EarthFaultCompensator(
    @Id var earthFaultCompensatorId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: Resistance? = null
)

@Entity
data class EnergyArea(
     var energyAreaId: UUID? = null
)

@Entity
data class EnergyConsumer(
    @Id var energyConsumerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pfixed") var pfixed: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pfixedPct") var pfixedPct: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qfixed") var qfixed: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qfixedPct") var qfixedPct: PerCent? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "energyConsumer") var energyConsumer:  Set<EnergyConsumer>? = null
)

@Entity
data class EnergySchedulingType(
     var energySchedulingTypeId: UUID? = null
)

@Entity
data class EnergySource(
    @Id var energySourceId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "energySource") var energySource:  Set<EnergySource>? = null
)

@Entity
data class Equipment(
    @Id var equipmentId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "equipments") var equipments:  Set<Equipment>? = null
)

@Entity
data class EquipmentBoundaryVersion(
    @Id var equipmentBoundaryVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURI") var baseURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURIcore") var entsoeURIcore: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURIoperation") var entsoeURIoperation: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class EquipmentContainer(
     var equipmentContainerId: UUID? = null
)

@Entity
data class EquipmentVersion(
    @Id var equipmentVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURIcore") var baseURIcore: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURIoperation") var baseURIoperation: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURIshortCircuit") var baseURIshortCircuit: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURIcore") var entsoeURIcore: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURIoperation") var entsoeURIoperation: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURIshortCircuit") var entsoeURIshortCircuit: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class EquivalentBranch(
    @Id var equivalentBranchId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "negativeR12") var negativeR12: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "negativeR21") var negativeR21: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "negativeX12") var negativeX12: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "negativeX21") var negativeX21: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "positiveR12") var positiveR12: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "positiveR21") var positiveR21: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "positiveX12") var positiveX12: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "positiveX21") var positiveX21: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r21") var r21: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x") var x: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x21") var x21: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zeroR12") var zeroR12: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zeroR21") var zeroR21: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zeroX12") var zeroX12: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zeroX21") var zeroX21: Reactance? = null
)

@Entity
data class EquivalentEquipment(
    @Id var equivalentEquipmentId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "equivalentEquipments") var equivalentEquipments:  Set<EquivalentEquipment>? = null
)

@Entity
data class EquivalentInjection(
    @Id var equivalentInjectionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxP") var maxP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxQ") var maxQ: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minP") var minP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minQ") var minQ: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r0") var r0: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r2") var r2: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "regulationCapability") var regulationCapability: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x") var x: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x0") var x0: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x2") var x2: Reactance? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "equivalentInjection") var equivalentInjection:  Set<EquivalentInjection>? = null
)

@Entity
data class EquivalentNetwork(
     var equivalentNetworkId: UUID? = null
)

@Entity
data class EquivalentShunt(
    @Id var equivalentShuntId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b") var b: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g") var g: Conductance? = null
)

@Entity
data class ExcAC1A(
    @Id var excAC1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hvlvgates") var hvlvgates: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf1") var kf1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf2") var kf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcAC2A(
    @Id var excAC2AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hvgate") var hvgate: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kb") var kb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kb1") var kb1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh") var kh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl") var kl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl1") var kl1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lvgate") var lvgate: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfemax") var vfemax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vlr") var vlr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcAC3A(
    @Id var excAC3AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdn") var efdn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf1") var kf1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf2") var kf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "klv") var klv: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kn") var kn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kr") var kr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vemin") var vemin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfemax") var vfemax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vlv") var vlv: PU? = null
)

@Entity
data class ExcAC4A(
    @Id var excAC4AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcAC5A(
    @Id var excAC5AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a") var a: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf1") var tf1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf2") var tf2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf3") var tf3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcAC6A(
    @Id var excAC6AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh") var kh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th") var th: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tj") var tj: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tk") var tk: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfelim") var vfelim: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vhmax") var vhmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcAC8B(
    @Id var excAC8BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inlim") var inlim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdr") var kdr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kir") var kir: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpr") var kpr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pidlim") var pidlim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdr") var tdr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "telim") var telim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vemin") var vemin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfemax") var vfemax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vpidmax") var vpidmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vpidmin") var vpidmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtmult") var vtmult: BooleanProxy? = null
)

@Entity
data class ExcANS(
    @Id var excANSId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "blint") var blint: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ifmn") var ifmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ifmx") var ifmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kce") var kce: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "krvecc") var krvecc: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kvfif") var kvfif: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmn") var vrmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmx") var vrmx: PU? = null
)

@Entity
data class ExcAVR1(
    @Id var excAVR1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e1") var e1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e2") var e2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se1") var se1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se2") var se2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmn") var vrmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmx") var vrmx: PU? = null
)

@Entity
data class ExcAVR2(
    @Id var excAVR2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e1") var e1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e2") var e2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se1") var se1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se2") var se2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf1") var tf1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf2") var tf2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmn") var vrmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmx") var vrmx: PU? = null
)

@Entity
data class ExcAVR3(
    @Id var excAVR3Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e1") var e1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e2") var e2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se1") var se1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se2") var se2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmn") var vrmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmx") var vrmx: PU? = null
)

@Entity
data class ExcAVR4(
    @Id var excAVR4Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "imul") var imul: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kif") var kif: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1if") var t1if: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tif") var tif: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfmn") var vfmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfmx") var vfmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmn") var vrmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmx") var vrmx: PU? = null
)

@Entity
data class ExcAVR5(
    @Id var excAVR5Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rex") var rex: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null
)

@Entity
data class ExcAVR7(
    @Id var excAVR7Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a1") var a1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a2") var a2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a3") var a3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a4") var a4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a5") var a5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a6") var a6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k5") var k5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax1") var vmax1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax3") var vmax3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax5") var vmax5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin1") var vmin1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin3") var vmin3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin5") var vmin5: PU? = null
)

@Entity
data class ExcBBC(
    @Id var excBBCId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmax") var efdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmin") var efdmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "switchIt") var switchIt: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xe") var xe: PU? = null
)

@Entity
data class ExcCZ(
    @Id var excCZId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmax") var efdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmin") var efdmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcDC1A(
    @Id var excDC1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "edfmax") var edfmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmin") var efdmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exclim") var exclim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcDC2A(
    @Id var excDC2AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exclim") var exclim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf1") var tf1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtlim") var vtlim: BooleanProxy? = null
)

@Entity
data class ExcDC3A(
    @Id var excDC3AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "edfmax") var edfmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdlim") var efdlim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmin") var efdmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exclim") var exclim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kr") var kr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kv") var kv: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "trh") var trh: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcDC3A1(
    @Id var excDC3A1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exclim") var exclim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vb1max") var vb1max: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vblim") var vblim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vbmax") var vbmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcELIN1(
    @Id var excELIN1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dpnf") var dpnf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efmax") var efmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efmin") var efmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks1") var ks1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks2") var ks2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "smax") var smax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tfi") var tfi: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tnu") var tnu: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts1") var ts1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts2") var ts2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tsw") var tsw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vpi") var vpi: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vpnf") var vpnf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vpu") var vpu: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xe") var xe: PU? = null
)

@Entity
data class ExcELIN2(
    @Id var excELIN2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdbas") var efdbas: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "iefmax") var iefmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "iefmax2") var iefmax2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "iefmin") var iefmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1ec") var k1ec: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k4") var k4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd1") var kd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke2") var ke2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ketb") var ketb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pid1max") var pid1max: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb1") var tb1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te2") var te2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti1") var ti1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti3") var ti3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti4") var ti4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr4") var tr4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "upmax") var upmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "upmin") var upmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xp") var xp: PU? = null
)

@Entity
data class ExcHU(
    @Id var excHUId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ae") var ae: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ai") var ai: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "atr") var atr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emax") var emax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emin") var emin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "imax") var imax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "imin") var imin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti") var ti: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Seconds? = null
)

@Entity
data class ExcIEEEAC1A(
    @Id var excIEEEAC1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEAC2A(
    @Id var excIEEEAC2AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kb") var kb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh") var kh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfemax") var vfemax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEAC3A(
    @Id var excIEEEAC3AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdn") var efdn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kn") var kn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kr") var kr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vemin") var vemin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfemax") var vfemax: PU? = null
)

@Entity
data class ExcIEEEAC4A(
    @Id var excIEEEAC4AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEAC5A(
    @Id var excIEEEAC5AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf1") var tf1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf2") var tf2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf3") var tf3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEAC6A(
    @Id var excIEEEAC6AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh") var kh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th") var th: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tj") var tj: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tk") var tk: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfelim") var vfelim: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vhmax") var vhmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEAC7B(
    @Id var excIEEEAC7BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdr") var kdr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf1") var kf1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf2") var kf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf3") var kf3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kia") var kia: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kir") var kir: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl") var kl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpa") var kpa: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpr") var kpr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdr") var tdr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vemin") var vemin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfemax") var vfemax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEAC8B(
    @Id var excIEEEAC8BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdr") var kdr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kir") var kir: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpr") var kpr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve1") var seve1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seve2") var seve2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdr") var tdr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve1") var ve1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ve2") var ve2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vemin") var vemin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfemax") var vfemax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEDC1A(
    @Id var excIEEEDC1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exclim") var exclim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uelin") var uelin: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEDC2A(
    @Id var excIEEEDC2AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exclim") var exclim: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uelin") var uelin: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEDC3A(
    @Id var excIEEEDC3AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exclim") var exclim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kv") var kv: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "trh") var trh: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEDC4B(
    @Id var excIEEEDC4BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "oelin") var oelin: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd1") var seefd1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "seefd2") var seefd2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uelin") var uelin: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vemin") var vemin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEST1A(
    @Id var excIEEEST1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ilr") var ilr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "klr") var klr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pssin") var pssin: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb1") var tb1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc1") var tc1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @Enumerated(EnumType.STRING) var uelin: ExcIEEEST1AUELselectorKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEST2A(
    @Id var excIEEEST2AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmax") var efdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uelin") var uelin: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEST3A(
    @Id var excIEEEST3AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "km") var km: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thetap") var thetap: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tm") var tm: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vbmax") var vbmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vgmax") var vgmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmmax") var vmmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmmin") var vmmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xl") var xl: PU? = null
)

@Entity
data class ExcIEEEST4B(
    @Id var excIEEEST4BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kim") var kim: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kir") var kir: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpm") var kpm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpr") var kpr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thetap") var thetap: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vbmax") var vbmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmmax") var vmmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmmin") var vmmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xl") var xl: PU? = null
)

@Entity
data class ExcIEEEST5B(
    @Id var excIEEEST5BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kr") var kr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb1") var tb1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb2") var tb2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc1") var tc1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc2") var tc2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tob1") var tob1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tob2") var tob2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toc1") var toc1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toc2") var toc2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tub1") var tub1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tub2") var tub2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tuc1") var tuc1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tuc2") var tuc2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEST6B(
    @Id var excIEEEST6BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ilr") var ilr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kci") var kci: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kff") var kff: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kia") var kia: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "klr") var klr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "km") var km: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpa") var kpa: PU? = null,
    @Enumerated(EnumType.STRING) var oelin: ExcST6BOELselectorKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcIEEEST7B(
    @Id var excIEEEST7BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh") var kh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kia") var kia: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl") var kl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpa") var kpa: PU? = null,
    @Enumerated(EnumType.STRING) var oelin: ExcST7BOELselectorKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tia") var tia: Seconds? = null,
    @Enumerated(EnumType.STRING) var uelin: ExcST7BUELselectorKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax") var vmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin") var vmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcOEX3T(
    @Id var excOEX3TId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e1") var e1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e2") var e2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "see1") var see1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "see2") var see2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcPIC(
    @Id var excPICId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e1") var e1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e2") var e2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmax") var efdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmin") var efdmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se1") var se1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se2") var se2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta1") var ta1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta2") var ta2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta3") var ta3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta4") var ta4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf1") var tf1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf2") var tf2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vr1") var vr1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vr2") var vr2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcREXS(
    @Id var excREXSId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e1") var e1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e2") var e2: PU? = null,
    @Enumerated(EnumType.STRING) var fbf: ExcREXSFeedbackSignalKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flimf") var flimf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kefd") var kefd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh") var kh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kii") var kii: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kip") var kip: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kvi") var kvi: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kvp") var kvp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kvphz") var kvphz: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nvphz") var nvphz: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se1") var se1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "se2") var se2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb1") var tb1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb2") var tb2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc1") var tc1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc2") var tc2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf1") var tf1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf2") var tf2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vcmax") var vcmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfmax") var vfmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vfmin") var vfmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xc") var xc: PU? = null
)

@Entity
data class ExcSCRX(
    @Id var excSCRXId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cswitch") var cswitch: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emax") var emax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emin") var emin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rcrfd") var rcrfd: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tatb") var tatb: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null
)

@Entity
data class ExcSEXS(
    @Id var excSEXSId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmax") var efdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmin") var efdmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emax") var emax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emin") var emin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tatb") var tatb: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null
)

@Entity
data class ExcSK(
    @Id var excSKId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmax") var efdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmin") var efdmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emax") var emax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emin") var emin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kce") var kce: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kgob") var kgob: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kqi") var kqi: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kqob") var kqob: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kqp") var kqp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nq") var nq: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qconoff") var qconoff: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qz") var qz: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "remote") var remote: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sbase") var sbase: ApparentPower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti") var ti: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uimax") var uimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uimin") var uimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "urmax") var urmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "urmin") var urmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtmax") var vtmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vtmin") var vtmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "yp") var yp: PU? = null
)

@Entity
data class ExcST1A(
    @Id var excST1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ilr") var ilr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "klr") var klr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb1") var tb1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc1") var tc1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xe") var xe: PU? = null
)

@Entity
data class ExcST2A(
    @Id var excST2AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmax") var efdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uelin") var uelin: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcST3A(
    @Id var excST3AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdmax") var efdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kj") var kj: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "km") var km: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks1") var ks1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thetap") var thetap: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tm") var tm: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vbmax") var vbmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vgmax") var vgmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xl") var xl: PU? = null
)

@Entity
data class ExcST4B(
    @Id var excST4BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kim") var kim: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kir") var kir: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpm") var kpm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpr") var kpr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lvgate") var lvgate: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thetap") var thetap: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uel") var uel: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vbmax") var vbmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vgmax") var vgmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmmax") var vmmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmmin") var vmmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xl") var xl: PU? = null
)

@Entity
data class ExcST6B(
    @Id var excST6BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ilr") var ilr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kcl") var kcl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kff") var kff: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kia") var kia: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "klr") var klr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "km") var km: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpa") var kpa: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kvd") var kvd: PU? = null,
    @Enumerated(EnumType.STRING) var oelin: ExcST6BOELselectorKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts") var ts: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tvd") var tvd: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamax") var vamax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vamin") var vamin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vilim") var vilim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmult") var vmult: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xc") var xc: PU? = null
)

@Entity
data class ExcST7B(
    @Id var excST7BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh") var kh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kia") var kia: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl") var kl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpa") var kpa: PU? = null,
    @Enumerated(EnumType.STRING) var oelin: ExcST7BOELselectorKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tia") var tia: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts") var ts: Seconds? = null,
    @Enumerated(EnumType.STRING) var uelin: ExcST7BUELselectorKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax") var vmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin") var vmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class ExcitationSystemDynamics(
    @Id var excitationSystemDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "excitationSystemDynamics") var excitationSystemDynamics: ExcitationSystemDynamics? = null
)

@Entity
data class ExcitationSystemUserDefined(
    @Id var excitationSystemUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class ExtensionVersion(
    @Id var extensionVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceURI") var namespaceURI: StringProxy? = null
)

@Entity
data class ExternalNetworkInjection(
    @Id var externalNetworkInjectionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "governorSCD") var governorSCD: ActivePowerPerFrequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ikSecond") var ikSecond: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxInitialSymShCCurrent") var maxInitialSymShCCurrent: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxP") var maxP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxQ") var maxQ: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxR0ToX0Ratio") var maxR0ToX0Ratio: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxR1ToX1Ratio") var maxR1ToX1Ratio: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxZ0ToZ1Ratio") var maxZ0ToZ1Ratio: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minInitialSymShCCurrent") var minInitialSymShCCurrent: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minP") var minP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minQ") var minQ: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minR0ToX0Ratio") var minR0ToX0Ratio: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minR1ToX1Ratio") var minR1ToX1Ratio: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minZ0ToZ1Ratio") var minZ0ToZ1Ratio: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voltageFactor") var voltageFactor: PU? = null
)

@Entity
data class FloatProxy(
     var floatProxyId: UUID? = null
)

@Entity
data class FossilFuel(
    @Id var fossilFuelId: UUID? = null,
    @Enumerated(EnumType.STRING) var fossilFuelType: FuelType? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "fossilFuels") var fossilFuels:  Set<FossilFuel>? = null
)

@Entity
data class Frequency(
    @Id var frequencyId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class GenICompensationForGenJ(
    @Id var genICompensationForGenJId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rcij") var rcij: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xcij") var xcij: PU? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "genICompensationForGenJ") var genICompensationForGenJ:  Set<GenICompensationForGenJ>? = null
)

@Entity
data class GeneratingUnit(
    @Id var generatingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var genControlSource: GeneratorControlSource? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "governorSCD") var governorSCD: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "initialP") var initialP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "longPF") var longPF: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maximumAllowableSpinningReserve") var maximumAllowableSpinningReserve: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxOperatingP") var maxOperatingP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minOperatingP") var minOperatingP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nominalP") var nominalP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedGrossMaxP") var ratedGrossMaxP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedGrossMinP") var ratedGrossMinP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedNetMaxP") var ratedNetMaxP: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortPF") var shortPF: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "startupCost") var startupCost: Money? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "totalEfficiency") var totalEfficiency: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "variableCost") var variableCost: Money? = null
)

@Entity
data class GeographicalLocationVersion(
    @Id var geographicalLocationVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURI") var baseURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURI") var entsoeURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class GeographicalRegion(
     var geographicalRegionId: UUID? = null
)

@Entity
data class GovCT1(
    @Id var govCT1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "aset") var aset: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db") var db: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dm") var dm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdgov") var kdgov: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kigov") var kigov: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kiload") var kiload: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kimw") var kimw: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpgov") var kpgov: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpload") var kpload: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kturb") var kturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ldref") var ldref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxerr") var maxerr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minerr") var minerr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rclose") var rclose: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rdown") var rdown: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ropen") var ropen: Simple_Float? = null,
    @Enumerated(EnumType.STRING) var rselect: DroopSignalFeedbackKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rup") var rup: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tact") var tact: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdgov") var tdgov: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "teng") var teng: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tfload") var tfload: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpelec") var tpelec: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tsa") var tsa: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tsb") var tsb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax") var vmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin") var vmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wfnl") var wfnl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wfspd") var wfspd: BooleanProxy? = null
)

@Entity
data class GovCT2(
    @Id var govCT2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "aset") var aset: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db") var db: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dm") var dm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim1") var flim1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim10") var flim10: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim2") var flim2: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim3") var flim3: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim4") var flim4: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim5") var flim5: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim6") var flim6: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim7") var flim7: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim8") var flim8: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flim9") var flim9: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdgov") var kdgov: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kigov") var kigov: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kiload") var kiload: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kimw") var kimw: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpgov") var kpgov: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpload") var kpload: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kturb") var kturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ldref") var ldref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxerr") var maxerr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minerr") var minerr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim1") var plim1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim10") var plim10: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim2") var plim2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim3") var plim3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim4") var plim4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim5") var plim5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim6") var plim6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim7") var plim7: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim8") var plim8: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plim9") var plim9: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "prate") var prate: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rclose") var rclose: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rdown") var rdown: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ropen") var ropen: Simple_Float? = null,
    @Enumerated(EnumType.STRING) var rselect: DroopSignalFeedbackKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rup") var rup: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tact") var tact: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdgov") var tdgov: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "teng") var teng: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tfload") var tfload: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpelec") var tpelec: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tsa") var tsa: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tsb") var tsb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax") var vmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin") var vmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wfnl") var wfnl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wfspd") var wfspd: BooleanProxy? = null
)

@Entity
data class GovGAST(
    @Id var govGASTId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "at") var at: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dturb") var dturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kt") var kt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax") var vmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin") var vmin: PU? = null
)

@Entity
data class GovGAST1(
    @Id var govGAST1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a") var a: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b") var b: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eps") var eps: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fidle") var fidle: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv6") var gv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kt") var kt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lmax") var lmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "loadinc") var loadinc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ltrate") var ltrate: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv6") var pgv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rmax") var rmax: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tltr") var tltr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax") var vmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin") var vmin: PU? = null
)

@Entity
data class GovGAST2(
    @Id var govGAST2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a") var a: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "af1") var af1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "af2") var af2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b") var b: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bf1") var bf1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bf2") var bf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "c") var c: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cf2") var cf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ecr") var ecr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "etd") var etd: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k4") var k4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k5") var k5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k6") var k6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t") var t: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Temperature? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tcd") var tcd: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tmax") var tmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tmin") var tmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Temperature? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "trate") var trate: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "w") var w: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x") var x: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "y") var y: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "z") var z: BooleanProxy? = null
)

@Entity
data class GovGAST3(
    @Id var govGAST3Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bca") var bca: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bp") var bp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dtc") var dtc: Temperature? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ka") var ka: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kac") var kac: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kca") var kca: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ksi") var ksi: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ky") var ky: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mnef") var mnef: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mxef") var mxef: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rcmn") var rcmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rcmx") var rcmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tac") var tac: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tfen") var tfen: Temperature? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tsi") var tsi: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Temperature? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ttc") var ttc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ty") var ty: Seconds? = null
)

@Entity
data class GovGAST4(
    @Id var govGAST4Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bp") var bp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ktm") var ktm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mnef") var mnef: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mxef") var mxef: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rymn") var rymn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rymx") var rymx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tcm") var tcm: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tm") var tm: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tv") var tv: Seconds? = null
)

@Entity
data class GovGASTWD(
    @Id var govGASTWDId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a") var a: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "af1") var af1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "af2") var af2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b") var b: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bf1") var bf1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bf2") var bf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "c") var c: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cf2") var cf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ecr") var ecr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "etd") var etd: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k4") var k4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k5") var k5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k6") var k6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdroop") var kdroop: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t") var t: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Temperature? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tcd") var tcd: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tmax") var tmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tmin") var tmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Temperature? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "trate") var trate: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Seconds? = null
)

@Entity
data class GovHydro1(
    @Id var govHydro1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "at") var at: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dturb") var dturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmax") var gmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmin") var gmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hdam") var hdam: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qnl") var qnl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rperm") var rperm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rtemp") var rtemp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velm") var velm: Simple_Float? = null
)

@Entity
data class GovHydro2(
    @Id var govHydro2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "aturb") var aturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bturb") var bturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eps") var eps: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv6") var gv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kturb") var kturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv6") var pgv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rperm") var rperm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rtemp") var rtemp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uc") var uc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uo") var uo: Simple_Float? = null
)

@Entity
data class GovHydro3(
    @Id var govHydro3Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "at") var at: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dturb") var dturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eps") var eps: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "governorControl") var governorControl: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv6") var gv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "h0") var h0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv6") var pgv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qnl") var qnl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "relec") var relec: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rgate") var rgate: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velcl") var velcl: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velop") var velop: Simple_Float? = null
)

@Entity
data class GovHydro4(
    @Id var govHydro4Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "at") var at: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bgv0") var bgv0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bgv1") var bgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bgv2") var bgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bgv3") var bgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bgv4") var bgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bgv5") var bgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bmax") var bmax: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dturb") var dturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eps") var eps: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmax") var gmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmin") var gmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv0") var gv0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hdam") var hdam: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv0") var pgv0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qn1") var qn1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rperm") var rperm: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rtemp") var rtemp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tblade") var tblade: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uc") var uc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uo") var uo: Simple_Float? = null
)

@Entity
data class GovHydroDD(
    @Id var govHydroDDId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "aturb") var aturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bturb") var bturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eps") var eps: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmax") var gmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmin") var gmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv6") var gv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inputSignal") var inputSignal: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv6") var pgv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tturb") var tturb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velcl") var velcl: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velop") var velop: Simple_Float? = null
)

@Entity
data class GovHydroFrancis(
    @Id var govHydroFrancisId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "am") var am: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "av0") var av0: Area? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "av1") var av1: Area? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bp") var bp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "etamax") var etamax: PU? = null,
    @Enumerated(EnumType.STRING) var governorControl: FrancisGovernorControlKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "h1") var h1: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "h2") var h2: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hn") var hn: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kt") var kt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qc0") var qc0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qn") var qn: VolumeFlowRate? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts") var ts: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twnc") var twnc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twng") var twng: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tx") var tx: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "va") var va: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "valvmax") var valvmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "valvmin") var valvmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vc") var vc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "waterTunnelSurgeChamberSimulation") var waterTunnelSurgeChamberSimulation: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zsfc") var zsfc: Length? = null
)

@Entity
data class GovHydroIEEE0(
    @Id var govHydroIEEE0Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null
)

@Entity
data class GovHydroIEEE2(
    @Id var govHydroIEEE2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "aturb") var aturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bturb") var bturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv6") var gv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kturb") var kturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv6") var pgv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rperm") var rperm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rtemp") var rtemp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uc") var uc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uo") var uo: Simple_Float? = null
)

@Entity
data class GovHydroPID(
    @Id var govHydroPIDId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "aturb") var aturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bturb") var bturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eps") var eps: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv6") var gv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inputSignal") var inputSignal: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv6") var pgv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tturb") var tturb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velcl") var velcl: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velop") var velop: Simple_Float? = null
)

@Entity
data class GovHydroPID2(
    @Id var govHydroPID2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "atw") var atw: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "d") var d: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "feedbackSignal") var feedbackSignal: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g0") var g0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g1") var g1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g2") var g2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmax") var gmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmin") var gmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p1") var p1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p2") var p2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p3") var p3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rperm") var rperm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "treg") var treg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velmax") var velmax: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velmin") var velmin: Simple_Float? = null
)

@Entity
data class GovHydroPelton(
    @Id var govHydroPeltonId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "av0") var av0: Area? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "av1") var av1: Area? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bp") var bp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "h1") var h1: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "h2") var h2: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hn") var hn: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kc") var kc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qc0") var qc0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qn") var qn: VolumeFlowRate? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "simplifiedPelton") var simplifiedPelton: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "staticCompensating") var staticCompensating: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts") var ts: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tv") var tv: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twnc") var twnc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twng") var twng: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tx") var tx: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "va") var va: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "valvmax") var valvmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "valvmin") var valvmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vav") var vav: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vc") var vc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vcv") var vcv: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "waterTunnelSurgeChamberSimulation") var waterTunnelSurgeChamberSimulation: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zsfc") var zsfc: Length? = null
)

@Entity
data class GovHydroR(
    @Id var govHydroRId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "at") var at: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dturb") var dturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eps") var eps: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmax") var gmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmin") var gmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv6") var gv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "h0") var h0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inputSignal") var inputSignal: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kg") var kg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv6") var pgv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qnl") var qnl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t7") var t7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t8") var t8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velcl") var velcl: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velop") var velop: Simple_Float? = null
)

@Entity
data class GovHydroWEH(
    @Id var govHydroWEHId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db") var db: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dicn") var dicn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dpv") var dpv: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dturb") var dturb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "feedbackSignal") var feedbackSignal: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fl1") var fl1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fl2") var fl2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fl3") var fl3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fl4") var fl4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fl5") var fl5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp1") var fp1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp10") var fp10: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp2") var fp2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp3") var fp3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp4") var fp4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp5") var fp5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp6") var fp6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp7") var fp7: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp8") var fp8: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fp9") var fp9: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmax") var gmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gmin") var gmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gtmxcl") var gtmxcl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gtmxop") var gtmxop: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss1") var pmss1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss10") var pmss10: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss2") var pmss2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss3") var pmss3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss4") var pmss4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss5") var pmss5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss6") var pmss6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss7") var pmss7: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss8") var pmss8: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmss9") var pmss9: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rpg") var rpg: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rpp") var rpp: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdv") var tdv: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpe") var tpe: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null
)

@Entity
data class GovHydroWPID(
    @Id var govHydroWPIDId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "d") var d: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gatmax") var gatmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gatmin") var gatmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "reg") var reg: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "treg") var treg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velmax") var velmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "velmin") var velmin: PU? = null
)

@Entity
data class GovSteam0(
    @Id var govSteam0Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dt") var dt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax") var vmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin") var vmin: PU? = null
)

@Entity
data class GovSteam1(
    @Id var govSteam1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eps") var eps: Frequency? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv1") var gv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv2") var gv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv3") var gv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv4") var gv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv5") var gv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gv6") var gv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k4") var k4: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k5") var k5: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k6") var k6: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k7") var k7: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k8") var k8: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv1") var pgv1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv2") var pgv2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv3") var pgv3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv4") var pgv4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv5") var pgv5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pgv6") var pgv6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sdb1") var sdb1: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sdb2") var sdb2: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t7") var t7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uc") var uc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uo") var uo: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "valve") var valve: BooleanProxy? = null
)

@Entity
data class GovSteam2(
    @Id var govSteam2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dbf") var dbf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mnef") var mnef: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mxef") var mxef: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null
)

@Entity
data class GovSteamCC(
    @Id var govSteamCCId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dhp") var dhp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dlp") var dlp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fhp") var fhp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "flp") var flp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmaxhp") var pmaxhp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmaxlp") var pmaxlp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rhp") var rhp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rlp") var rlp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1hp") var t1hp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1lp") var t1lp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3hp") var t3hp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3lp") var t3lp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4hp") var t4hp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4lp") var t4lp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5hp") var t5hp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5lp") var t5lp: Seconds? = null
)

@Entity
data class GovSteamEU(
    @Id var govSteamEUId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "chc") var chc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cho") var cho: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cic") var cic: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cio") var cio: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db1") var db1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db2") var db2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hhpmax") var hhpmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ke") var ke: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kfcor") var kfcor: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "khp") var khp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "klp") var klp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kwcor") var kwcor: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "prhmax") var prhmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "simx") var simx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdp") var tdp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ten") var ten: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tfp") var tfp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thp") var thp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tip") var tip: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tlp") var tlp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "trh") var trh: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tvhp") var tvhp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tvip") var tvip: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw") var tw: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wfmax") var wfmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wfmin") var wfmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wmax1") var wmax1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wmax2") var wmax2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wwmax") var wwmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wwmin") var wwmin: PU? = null
)

@Entity
data class GovSteamFV2(
    @Id var govSteamFV2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dt") var dt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti") var ti: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmax") var vmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vmin") var vmin: PU? = null
)

@Entity
data class GovSteamFV3(
    @Id var govSteamFV3Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "prmax") var prmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uc") var uc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uo") var uo: Simple_Float? = null
)

@Entity
data class GovSteamFV4(
    @Id var govSteamFV4Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cpsmn") var cpsmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cpsmx") var cpsmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "crmn") var crmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "crmx") var crmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdc") var kdc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf1") var kf1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf3") var kf3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "khp") var khp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kic") var kic: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kip") var kip: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kit") var kit: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kmp1") var kmp1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kmp2") var kmp2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpc") var kpc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpp") var kpp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpt") var kpt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "krc") var krc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ksh") var ksh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lpi") var lpi: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lps") var lps: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mnef") var mnef: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mxef") var mxef: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pr1") var pr1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pr2") var pr2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "psmn") var psmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rsmimn") var rsmimn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rsmimx") var rsmimx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rvgmn") var rvgmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rvgmx") var rvgmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "srmn") var srmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "srmx") var srmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "srsmp") var srsmp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "svmn") var svmn: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "svmx") var svmx: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tam") var tam: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tcm") var tcm: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdc") var tdc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf1") var tf1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf2") var tf2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thp") var thp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tmp") var tmp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "trh") var trh: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tv") var tv: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ty") var ty: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "y") var y: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "yhpmn") var yhpmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "yhpmx") var yhpmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ympmn") var ympmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ympmx") var ympmx: PU? = null
)

@Entity
data class GovSteamIEEE1(
    @Id var govSteamIEEE1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k4") var k4: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k5") var k5: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k6") var k6: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k7") var k7: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k8") var k8: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t7") var t7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uc") var uc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uo") var uo: Simple_Float? = null
)

@Entity
data class GovSteamSGO(
    @Id var govSteamSGOId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmax") var pmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null
)

@Entity
data class GrossToNetActivePowerCurve(
    @Id var grossToNetActivePowerCurveId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "grossToNetActivePowerCurves") var grossToNetActivePowerCurves:  Set<GrossToNetActivePowerCurve>? = null
)

@Entity
data class Ground(
     var groundId: UUID? = null
)

@Entity
data class GroundDisconnector(
     var groundDisconnectorId: UUID? = null
)

@Entity
data class GroundingImpedance(
    @Id var groundingImpedanceId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x") var x: Reactance? = null
)

@Entity
data class HydroGeneratingUnit(
    @Id var hydroGeneratingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var energyConversionCapability: HydroEnergyConversionKind? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "hydroGeneratingUnits") var hydroGeneratingUnits:  Set<HydroGeneratingUnit>? = null
)

@Entity
data class HydroPowerPlant(
    @Id var hydroPowerPlantId: UUID? = null,
    @Enumerated(EnumType.STRING) var hydroPlantStorageType: HydroPlantStorageKind? = null
)

@Entity
data class HydroPump(
    @Id var hydroPumpId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hydroPump") var hydroPump: HydroPump? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "hydroPumps") var hydroPumps:  Set<HydroPump>? = null
)

@Entity
data class IdentifiedObject(
    @Id var identifiedObjectId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "description") var description: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "energyIdentCodeEic") var energyIdentCodeEic: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mRID") var mRID: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "name") var name: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class Inductance(
    @Id var inductanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class InductancePerLength(
    @Id var inductancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class IntegerProxy(
     var integerProxyId: UUID? = null
)

@Entity
data class Junction(
     var junctionId: UUID? = null
)

@Entity
data class Length(
    @Id var lengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class Limit(
     var limitId: UUID? = null
)

@Entity
data class LimitSet(
    @Id var limitSetId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "percentageLimitsFlag") var percentageLimitsFlag: BooleanProxy? = null
)

@Entity
data class Line(
    @Id var lineId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "lines") var lines:  Set<Line>? = null
)

@Entity
data class LinearShuntCompensator(
    @Id var linearShuntCompensatorId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b0PerSection") var b0PerSection: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bPerSection") var bPerSection: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g0PerSection") var g0PerSection: Conductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "gPerSection") var gPerSection: Conductance? = null
)

@Entity
data class LoadAggregate(
     var loadAggregateId: UUID? = null
)

@Entity
data class LoadArea(
     var loadAreaId: UUID? = null
)

@Entity
data class LoadBreakSwitch(
     var loadBreakSwitchId: UUID? = null
)

@Entity
data class LoadComposite(
    @Id var loadCompositeId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "epfd") var epfd: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "epfs") var epfs: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "epvd") var epvd: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "epvs") var epvs: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eqfd") var eqfd: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eqfs") var eqfs: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eqvd") var eqvd: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eqvs") var eqvs: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "h") var h: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lfrac") var lfrac: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pfrac") var pfrac: Simple_Float? = null
)

@Entity
data class LoadDynamics(
     var loadDynamicsId: UUID? = null
)

@Entity
data class LoadGenericNonLinear(
    @Id var loadGenericNonLinearId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bs") var bs: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bt") var bt: Simple_Float? = null,
    @Enumerated(EnumType.STRING) var genericNonLinearLoadModelType: GenericNonLinearLoadModelKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ls") var ls: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lt") var lt: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pt") var pt: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qt") var qt: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tq") var tq: Seconds? = null
)

@Entity
data class LoadGroup(
    @Id var loadGroupId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "loadGroups") var loadGroups:  Set<LoadGroup>? = null
)

@Entity
data class LoadMotor(
    @Id var loadMotorId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "d") var d: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "h") var h: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lfac") var lfac: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lp") var lp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lpp") var lpp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ls") var ls: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pfrac") var pfrac: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ra") var ra: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tbkr") var tbkr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpo") var tpo: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tppo") var tppo: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tv") var tv: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vt") var vt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "loadMotor") var loadMotor: LoadMotor? = null
)

@Entity
data class LoadResponseCharacteristic(
    @Id var loadResponseCharacteristicId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exponentModel") var exponentModel: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pConstantCurrent") var pConstantCurrent: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pConstantImpedance") var pConstantImpedance: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pConstantPower") var pConstantPower: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pFrequencyExponent") var pFrequencyExponent: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pVoltageExponent") var pVoltageExponent: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qConstantCurrent") var qConstantCurrent: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qConstantImpedance") var qConstantImpedance: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qConstantPower") var qConstantPower: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qFrequencyExponent") var qFrequencyExponent: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qVoltageExponent") var qVoltageExponent: Simple_Float? = null
)

@Entity
data class LoadStatic(
    @Id var loadStaticId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ep1") var ep1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ep2") var ep2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ep3") var ep3: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eq1") var eq1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eq2") var eq2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "eq3") var eq3: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp1") var kp1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp2") var kp2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp3") var kp3: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp4") var kp4: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpf") var kpf: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kq1") var kq1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kq2") var kq2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kq3") var kq3: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kq4") var kq4: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kqf") var kqf: Simple_Float? = null,
    @Enumerated(EnumType.STRING) var staticLoadModelType: StaticLoadModelKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "loadStatic") var loadStatic: LoadStatic? = null
)

@Entity
data class LoadUserDefined(
    @Id var loadUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class Location(
    @Id var locationId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "location") var location: Location? = null
)

@Entity
data class Measurement(
    @Id var measurementId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "measurementType") var measurementType: StringProxy? = null,
    @Enumerated(EnumType.STRING) var phases: PhaseCode? = null,
    @Enumerated(EnumType.STRING) var unitMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unitSymbol: UnitSymbol? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "measurements") var measurements:  Set<Measurement>? = null
)

@Entity
data class MeasurementValue(
    @Id var measurementValueId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sensorAccuracy") var sensorAccuracy: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "timeStamp") var timeStamp: DateTime? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "measurementValues") var measurementValues:  Set<MeasurementValue>? = null
)

@Entity
data class MeasurementValueQuality(
    @Id var measurementValueQualityId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "measurementValueQuality") var measurementValueQuality: MeasurementValueQuality? = null
)

@Entity
data class MeasurementValueSource(
     var measurementValueSourceId: UUID? = null
)

@Entity
data class MechLoad1(
    @Id var mechLoad1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a") var a: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b") var b: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "d") var d: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "e") var e: Simple_Float? = null
)

@Entity
data class MechanicalLoadDynamics(
    @Id var mechanicalLoadDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mechanicalLoadDynamics") var mechanicalLoadDynamics: MechanicalLoadDynamics? = null
)

@Entity
data class MechanicalLoadUserDefined(
    @Id var mechanicalLoadUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class Money(
    @Id var moneyId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: CurrencyEnum? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: DecimalProxy? = null
)

@Entity
data class MonthDay(
     var monthDayId: UUID? = null
)

@Entity
data class MonthDayInterval(
    @Id var monthDayIntervalId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "end") var end: MonthDay? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "start") var start: MonthDay? = null
)

@Entity
data class MutualCoupling(
    @Id var mutualCouplingId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b0ch") var b0ch: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "distance11") var distance11: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "distance12") var distance12: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "distance21") var distance21: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "distance22") var distance22: Length? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g0ch") var g0ch: Conductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r0") var r0: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x0") var x0: Reactance? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "hasSecondMutualCoupling") var hasSecondMutualCoupling:  Set<MutualCoupling>? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "hasFirstMutualCoupling") var hasFirstMutualCoupling:  Set<MutualCoupling>? = null
)

@Entity
data class NonConformLoad(
    @Id var nonConformLoadId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "energyConsumers") var energyConsumers:  Set<NonConformLoad>? = null
)

@Entity
data class NonConformLoadGroup(
     var nonConformLoadGroupId: UUID? = null
)

@Entity
data class NonConformLoadSchedule(
    @Id var nonConformLoadScheduleId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "nonConformLoadSchedules") var nonConformLoadSchedules:  Set<NonConformLoadSchedule>? = null
)

@Entity
data class NonlinearShuntCompensator(
     var nonlinearShuntCompensatorId: UUID? = null
)

@Entity
data class NonlinearShuntCompensatorPoint(
    @Id var nonlinearShuntCompensatorPointId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b") var b: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b0") var b0: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g") var g: Conductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g0") var g0: Conductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sectionNumber") var sectionNumber: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "nonlinearShuntCompensatorPoints") var nonlinearShuntCompensatorPoints:  Set<NonlinearShuntCompensatorPoint>? = null
)

@Entity
data class NuclearGeneratingUnit(
     var nuclearGeneratingUnitId: UUID? = null
)

@Entity
data class OperationalLimit(
    @Id var operationalLimitId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "operationalLimit") var operationalLimit:  Set<OperationalLimit>? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "operationalLimitValue") var operationalLimitValue:  Set<OperationalLimit>? = null
)

@Entity
data class OperationalLimitSet(
    @Id var operationalLimitSetId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "operationalLimitSet") var operationalLimitSet:  Set<OperationalLimitSet>? = null
)

@Entity
data class OperationalLimitType(
    @Id var operationalLimitTypeId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "acceptableDuration") var acceptableDuration: Seconds? = null,
    @Enumerated(EnumType.STRING) var direction: OperationalLimitDirectionKind? = null,
    @Enumerated(EnumType.STRING) var limitType: LimitTypeEnum? = null
)

@Entity
data class OverexcLim2(
    @Id var overexcLim2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ifdlim") var ifdlim: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "koi") var koi: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voimax") var voimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voimin") var voimin: PU? = null
)

@Entity
data class OverexcLimIEEE(
    @Id var overexcLimIEEEId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hyst") var hyst: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ifdlim") var ifdlim: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ifdmax") var ifdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "itfpu") var itfpu: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kcd") var kcd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kramp") var kramp: Simple_Float? = null
)

@Entity
data class OverexcLimX1(
    @Id var overexcLimX1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd3") var efd3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efddes") var efddes: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdrated") var efdrated: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kmx") var kmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vlow") var vlow: PU? = null
)

@Entity
data class OverexcLimX2(
    @Id var overexcLimX2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd1") var efd1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd2") var efd2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efd3") var efd3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efddes") var efddes: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdrated") var efdrated: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kmx") var kmx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "m") var m: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vlow") var vlow: PU? = null
)

@Entity
data class OverexcitationLimiterDynamics(
    @Id var overexcitationLimiterDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "overexcitationLimiterDynamics") var overexcitationLimiterDynamics: OverexcitationLimiterDynamics? = null
)

@Entity
data class OverexcitationLimiterUserDefined(
    @Id var overexcitationLimiterUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class PFVArControllerType1Dynamics(
    @Id var pFVArControllerType1DynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pFVArControllerType1Dynamics") var pFVArControllerType1Dynamics: PFVArControllerType1Dynamics? = null
)

@Entity
data class PFVArControllerType1UserDefined(
    @Id var pFVArControllerType1UserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class PFVArControllerType2Dynamics(
    @Id var pFVArControllerType2DynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pFVArControllerType2Dynamics") var pFVArControllerType2Dynamics: PFVArControllerType2Dynamics? = null
)

@Entity
data class PFVArControllerType2UserDefined(
    @Id var pFVArControllerType2UserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class PFVArType1IEEEPFController(
    @Id var pFVArType1IEEEPFControllerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ovex") var ovex: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpfc") var tpfc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vitmin") var vitmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vpf") var vpf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vpfcbw") var vpfcbw: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vpfref") var vpfref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vvtmax") var vvtmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vvtmin") var vvtmin: PU? = null
)

@Entity
data class PFVArType1IEEEVArController(
    @Id var pFVArType1IEEEVArControllerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tvarc") var tvarc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vvar") var vvar: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vvarcbw") var vvarcbw: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vvarref") var vvarref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vvtmax") var vvtmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vvtmin") var vvtmin: PU? = null
)

@Entity
data class PFVArType2Common1(
    @Id var pFVArType2Common1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "j") var j: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "max") var max: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ref") var ref: PU? = null
)

@Entity
data class PFVArType2IEEEPFController(
    @Id var pFVArType2IEEEPFControllerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exlon") var exlon: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pfref") var pfref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vclmt") var vclmt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vref") var vref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vs") var vs: Simple_Float? = null
)

@Entity
data class PFVArType2IEEEVArController(
    @Id var pFVArType2IEEEVArControllerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "exlon") var exlon: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qref") var qref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vclmt") var vclmt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vref") var vref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vs") var vs: Simple_Float? = null
)

@Entity
data class PU(
    @Id var pUId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class PerCent(
    @Id var perCentId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class PerLengthDCLineParameter(
    @Id var perLengthDCLineParameterId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "capacitance") var capacitance: CapacitancePerLength? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inductance") var inductance: InductancePerLength? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "resistance") var resistance: ResistancePerLength? = null
)

@Entity
data class PetersenCoil(
    @Id var petersenCoilId: UUID? = null,
    @Enumerated(EnumType.STRING) var mode: PetersenCoilModeKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nominalU") var nominalU: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "offsetCurrent") var offsetCurrent: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "positionCurrent") var positionCurrent: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xGroundMax") var xGroundMax: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xGroundMin") var xGroundMin: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xGroundNominal") var xGroundNominal: Reactance? = null
)

@Entity
data class PhaseTapChanger(
    @Id var phaseTapChangerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "phaseTapChanger") var phaseTapChanger: PhaseTapChanger? = null
)

@Entity
data class PhaseTapChangerAsymmetrical(
    @Id var phaseTapChangerAsymmetricalId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windingConnectionAngle") var windingConnectionAngle: AngleDegrees? = null
)

@Entity
data class PhaseTapChangerLinear(
    @Id var phaseTapChangerLinearId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "stepPhaseShiftIncrement") var stepPhaseShiftIncrement: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xMax") var xMax: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xMin") var xMin: Reactance? = null
)

@Entity
data class PhaseTapChangerNonLinear(
    @Id var phaseTapChangerNonLinearId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voltageStepIncrement") var voltageStepIncrement: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xMax") var xMax: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xMin") var xMin: Reactance? = null
)

@Entity
data class PhaseTapChangerSymmetrical(
     var phaseTapChangerSymmetricalId: UUID? = null
)

@Entity
data class PhaseTapChangerTable(
     var phaseTapChangerTableId: UUID? = null
)

@Entity
data class PhaseTapChangerTablePoint(
    @Id var phaseTapChangerTablePointId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "angle") var angle: AngleDegrees? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "phaseTapChangerTablePoint") var phaseTapChangerTablePoint:  Set<PhaseTapChangerTablePoint>? = null
)

@Entity
data class PhaseTapChangerTabular(
    @Id var phaseTapChangerTabularId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "phaseTapChangerTabular") var phaseTapChangerTabular:  Set<PhaseTapChangerTabular>? = null
)

@Entity
data class PositionPoint(
    @Id var positionPointId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sequenceNumber") var sequenceNumber: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xPosition") var xPosition: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "yPosition") var yPosition: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zPosition") var zPosition: StringProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "positionPoints") var positionPoints:  Set<PositionPoint>? = null
)

@Entity
data class PowerSystemResource(
     var powerSystemResourceId: UUID? = null
)

@Entity
data class PowerSystemStabilizerDynamics(
    @Id var powerSystemStabilizerDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "powerSystemStabilizerDynamics") var powerSystemStabilizerDynamics: PowerSystemStabilizerDynamics? = null
)

@Entity
data class PowerSystemStabilizerUserDefined(
    @Id var powerSystemStabilizerUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class PowerTransformer(
    @Id var powerTransformerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "beforeShCircuitHighestOperatingCurrent") var beforeShCircuitHighestOperatingCurrent: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "beforeShCircuitHighestOperatingVoltage") var beforeShCircuitHighestOperatingVoltage: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "beforeShortCircuitAnglePf") var beforeShortCircuitAnglePf: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "highSideMinOperatingU") var highSideMinOperatingU: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "partOfGeneratorUnitFlag") var partOfGeneratorUnitFlag: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "operationalValuesConsidered") var operationalValuesConsidered: BooleanProxy? = null
)

@Entity
data class PowerTransformerEnd(
    @Id var powerTransformerEndId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b") var b: Susceptance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b0") var b0: Susceptance? = null,
    @Enumerated(EnumType.STRING) var connectionKind: WindingConnection? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g") var g: Conductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g0") var g0: Conductance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "phaseAngleClock") var phaseAngleClock: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r0") var r0: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedS") var ratedS: ApparentPower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedU") var ratedU: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x") var x: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x0") var x0: Reactance? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "powerTransformerEnd") var powerTransformerEnd:  Set<PowerTransformerEnd>? = null
)

@Entity
data class ProprietaryParameterDynamics(
    @Id var proprietaryParameterDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "booleanParameterValue") var booleanParameterValue: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "floatParameterValue") var floatParameterValue: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "integerParameterValue") var integerParameterValue: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "parameterNumber") var parameterNumber: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "proprietaryParameterDynamics") var proprietaryParameterDynamics:  Set<ProprietaryParameterDynamics>? = null
)

@Entity
data class ProtectedSwitch(
     var protectedSwitchId: UUID? = null
)

@Entity
data class Pss1(
    @Id var pss1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpe") var kpe: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kw") var kw: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t10") var t10: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t7") var t7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t8") var t8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t9") var t9: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpe") var tpe: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vadat") var vadat: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmn") var vsmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmx") var vsmx: PU? = null
)

@Entity
data class Pss1A(
    @Id var pss1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a1") var a1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a2") var a2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a3") var a3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a4") var a4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a5") var a5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a6") var a6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a7") var a7: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a8") var a8: PU? = null,
    @Enumerated(EnumType.STRING) var inputSignalType: InputSignalKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kd") var kd: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdelay") var tdelay: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vcl") var vcl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vcu") var vcu: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class Pss2B(
    @Id var pss2BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a") var a: Simple_Float? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind? = null,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks1") var ks1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks2") var ks2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks3") var ks3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks4") var ks4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "m") var m: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "n") var n: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t10") var t10: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t11") var t11: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t7") var t7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t8") var t8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t9") var t9: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw1") var tw1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw2") var tw2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw3") var tw3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw4") var tw4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsi1max") var vsi1max: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsi1min") var vsi1min: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsi2max") var vsi2max: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsi2min") var vsi2min: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vstmax") var vstmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vstmin") var vstmin: PU? = null
)

@Entity
data class Pss2ST(
    @Id var pss2STId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind? = null,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lsmax") var lsmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lsmin") var lsmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t10") var t10: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t7") var t7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t8") var t8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t9") var t9: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vcl") var vcl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vcu") var vcu: PU? = null
)

@Entity
data class Pss5(
    @Id var pss5Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ctw2") var ctw2: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "deadband") var deadband: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "isfreq") var isfreq: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf") var kf: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpe") var kpe: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpss") var kpss: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmm") var pmm: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl1") var tl1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl2") var tl2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl3") var tl3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl4") var tl4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpe") var tpe: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw1") var tw1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw2") var tw2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vadat") var vadat: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmn") var vsmn: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmx") var vsmx: PU? = null
)

@Entity
data class PssELIN2(
    @Id var pssELIN2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "apss") var apss: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks1") var ks1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks2") var ks2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ppss") var ppss: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "psslim") var psslim: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts1") var ts1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts2") var ts2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts3") var ts3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts4") var ts4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts5") var ts5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ts6") var ts6: Seconds? = null
)

@Entity
data class PssIEEE1A(
    @Id var pssIEEE1AId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a1") var a1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a2") var a2: PU? = null,
    @Enumerated(EnumType.STRING) var inputSignalType: InputSignalKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmax") var vrmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vrmin") var vrmin: PU? = null
)

@Entity
data class PssIEEE2B(
    @Id var pssIEEE2BId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind? = null,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks1") var ks1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks2") var ks2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks3") var ks3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "m") var m: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "n") var n: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t10") var t10: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t11") var t11: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t7") var t7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t8") var t8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t9") var t9: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw1") var tw1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw2") var tw2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw3") var tw3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw4") var tw4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsi1max") var vsi1max: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsi1min") var vsi1min: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsi2max") var vsi2max: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsi2min") var vsi2min: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vstmax") var vstmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vstmin") var vstmin: PU? = null
)

@Entity
data class PssIEEE3B(
    @Id var pssIEEE3BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a1") var a1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a2") var a2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a3") var a3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a4") var a4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a5") var a5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a6") var a6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a7") var a7: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a8") var a8: PU? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind? = null,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks1") var ks1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks2") var ks2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw1") var tw1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw2") var tw2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tw3") var tw3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vstmax") var vstmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vstmin") var vstmin: PU? = null
)

@Entity
data class PssIEEE4B(
    @Id var pssIEEE4BId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bwh1") var bwh1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bwh2") var bwh2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bwl1") var bwl1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "bwl2") var bwl2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh") var kh: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh1") var kh1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh11") var kh11: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh17") var kh17: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kh2") var kh2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki1") var ki1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki11") var ki11: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki17") var ki17: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki2") var ki2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl") var kl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl1") var kl1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl11") var kl11: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl17") var kl17: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kl2") var kl2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "omeganh1") var omeganh1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "omeganh2") var omeganh2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "omeganl1") var omeganl1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "omeganl2") var omeganl2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th1") var th1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th10") var th10: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th11") var th11: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th12") var th12: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th2") var th2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th3") var th3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th4") var th4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th5") var th5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th6") var th6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th7") var th7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th8") var th8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "th9") var th9: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti1") var ti1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti10") var ti10: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti11") var ti11: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti12") var ti12: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti2") var ti2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti3") var ti3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti4") var ti4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti5") var ti5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti6") var ti6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti7") var ti7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti8") var ti8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ti9") var ti9: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl1") var tl1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl10") var tl10: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl11") var tl11: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl12") var tl12: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl2") var tl2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl3") var tl3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl4") var tl4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl5") var tl5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl6") var tl6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl7") var tl7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl8") var tl8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tl9") var tl9: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vhmax") var vhmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vhmin") var vhmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimax") var vimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vimin") var vimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vlmax") var vlmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vlmin") var vlmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vstmax") var vstmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vstmin") var vstmin: PU? = null
)

@Entity
data class PssPTIST1(
    @Id var pssPTIST1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dtc") var dtc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dtf") var dtf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dtp") var dtp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "m") var m: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null
)

@Entity
data class PssPTIST3(
    @Id var pssPTIST3Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a0") var a0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a1") var a1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a2") var a2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a3") var a3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a4") var a4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "a5") var a5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "al") var al: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "athres") var athres: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b0") var b0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b1") var b1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b2") var b2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b3") var b3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b4") var b4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b5") var b5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dl") var dl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dtc") var dtc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dtf") var dtf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dtp") var dtp: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "isw") var isw: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lthres") var lthres: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "m") var m: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nav") var nav: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ncl") var ncl: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ncr") var ncr: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmin") var pmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf") var tf: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tp") var tp: Seconds? = null
)

@Entity
data class PssSB4(
    @Id var pssSB4Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kx") var kx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ta") var ta: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tb") var tb: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "te") var te: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tt") var tt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tx1") var tx1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tx2") var tx2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmax") var vsmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmin") var vsmin: PU? = null
)

@Entity
data class PssSH(
    @Id var pssSHId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k0") var k0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k4") var k4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "td") var td: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmax") var vsmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmin") var vsmin: PU? = null
)

@Entity
data class PssSK(
    @Id var pssSKId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k3") var k3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmax") var vsmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmin") var vsmin: PU? = null
)

@Entity
data class PssWECC(
    @Id var pssWECCId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind? = null,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t10") var t10: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t3") var t3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t4") var t4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t5") var t5: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t6") var t6: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t7") var t7: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t8") var t8: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t9") var t9: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vcl") var vcl: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vcu") var vcu: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmax") var vsmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vsmin") var vsmin: PU? = null
)

@Entity
data class Quality61850(
    @Id var quality61850Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "badReference") var badReference: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "estimatorReplaced") var estimatorReplaced: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "failure") var failure: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "oldData") var oldData: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "operatorBlocked") var operatorBlocked: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "oscillatory") var oscillatory: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "outOfRange") var outOfRange: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "overFlow") var overFlow: BooleanProxy? = null,
    @Enumerated(EnumType.STRING) var source: Source? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "suspect") var suspect: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "test") var test: BooleanProxy? = null,
    @Enumerated(EnumType.STRING) var validity: Validity? = null
)

@Entity
data class RaiseLowerCommand(
    @Id var raiseLowerCommandId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "raiseLowerCommands") var raiseLowerCommands:  Set<RaiseLowerCommand>? = null
)

@Entity
data class RatioTapChanger(
    @Id var ratioTapChangerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "stepVoltageIncrement") var stepVoltageIncrement: PerCent? = null,
    @Enumerated(EnumType.STRING) var tculControlMode: TransformerControlMode? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratioTapChanger") var ratioTapChanger: RatioTapChanger? = null
)

@Entity
data class RatioTapChangerTable(
     var ratioTapChangerTableId: UUID? = null
)

@Entity
data class RatioTapChangerTablePoint(
    @Id var ratioTapChangerTablePointId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "ratioTapChangerTablePoint") var ratioTapChangerTablePoint:  Set<RatioTapChangerTablePoint>? = null
)

@Entity
data class Reactance(
    @Id var reactanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class ReactiveCapabilityCurve(
     var reactiveCapabilityCurveId: UUID? = null
)

@Entity
data class ReactivePower(
    @Id var reactivePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class RegularIntervalSchedule(
    @Id var regularIntervalScheduleId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "endTime") var endTime: DateTime? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "timeStep") var timeStep: Seconds? = null
)

@Entity
data class RegularTimePoint(
    @Id var regularTimePointId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sequenceNumber") var sequenceNumber: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value1") var value1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value2") var value2: Simple_Float? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "timePoints") var timePoints:  Set<RegularTimePoint>? = null
)

@Entity
data class RegulatingCondEq(
    @Id var regulatingCondEqId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "regulatingCondEq") var regulatingCondEq:  Set<RegulatingCondEq>? = null
)

@Entity
data class RegulatingControl(
    @Id var regulatingControlId: UUID? = null,
    @Enumerated(EnumType.STRING) var mode: RegulatingControlModeKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "regulatingControl") var regulatingControl: RegulatingControl? = null
)

@Entity
data class RegulationSchedule(
    @Id var regulationScheduleId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "regulationSchedule") var regulationSchedule:  Set<RegulationSchedule>? = null
)

@Entity
data class RemoteInputSignal(
    @Id var remoteInputSignalId: UUID? = null,
    @Enumerated(EnumType.STRING) var remoteSignalType: RemoteSignalKind? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "remoteInputSignal") var remoteInputSignal:  Set<RemoteInputSignal>? = null
)

@Entity
data class ReportingGroup(
     var reportingGroupId: UUID? = null
)

@Entity
data class Resistance(
    @Id var resistanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class ResistancePerLength(
    @Id var resistancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class RotatingMachine(
    @Id var rotatingMachineId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedPowerFactor") var ratedPowerFactor: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedS") var ratedS: ApparentPower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedU") var ratedU: Voltage? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "rotatingMachine") var rotatingMachine:  Set<RotatingMachine>? = null
)

@Entity
data class RotatingMachineDynamics(
    @Id var rotatingMachineDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "damping") var damping: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inertia") var inertia: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "saturationFactor") var saturationFactor: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "saturationFactor120") var saturationFactor120: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "statorLeakageReactance") var statorLeakageReactance: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "statorResistance") var statorResistance: PU? = null
)

@Entity
data class RotationSpeed(
    @Id var rotationSpeedId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class Season(
    @Id var seasonId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "endDate") var endDate: MonthDay? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "startDate") var startDate: MonthDay? = null
)

@Entity
data class SeasonDayTypeSchedule(
    @Id var seasonDayTypeScheduleId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "seasonDayTypeSchedules") var seasonDayTypeSchedules:  Set<SeasonDayTypeSchedule>? = null
)

@Entity
data class Seconds(
    @Id var secondsId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class SeriesCompensator(
    @Id var seriesCompensatorId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r0") var r0: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "varistorPresent") var varistorPresent: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "varistorRatedCurrent") var varistorRatedCurrent: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "varistorVoltageThreshold") var varistorVoltageThreshold: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x") var x: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x0") var x0: Reactance? = null
)

@Entity
data class SetPoint(
    @Id var setPointId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "normalValue") var normalValue: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: Simple_Float? = null
)

@Entity
data class ShuntCompensator(
    @Id var shuntCompensatorId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "aVRDelay") var aVRDelay: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "grounded") var grounded: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maximumSections") var maximumSections: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "nomU") var nomU: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "normalSections") var normalSections: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "switchOnCount") var switchOnCount: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "switchOnDate") var switchOnDate: DateTime? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voltageSensitivity") var voltageSensitivity: VoltagePerReactivePower? = null
)

@Entity
data class Simple_Float(
    @Id var simple_FloatId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class SolarGeneratingUnit(
     var solarGeneratingUnitId: UUID? = null
)

@Entity
data class StateVariablesVersion(
    @Id var stateVariablesVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURI") var baseURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURI") var entsoeURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class StaticVarCompensator(
    @Id var staticVarCompensatorId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "capacitiveRating") var capacitiveRating: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inductiveRating") var inductiveRating: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "slope") var slope: VoltagePerReactivePower? = null,
    @Enumerated(EnumType.STRING) var sVCControlMode: SVCControlMode? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voltageSetPoint") var voltageSetPoint: Voltage? = null
)

@Entity
data class Staticpowersystemmodel(
     var staticpowersystemmodelId: UUID? = null
)

@Entity
data class StationSupply(
     var stationSupplyId: UUID? = null
)

@Entity
data class SteadyStateHypothesisVersion(
    @Id var steadyStateHypothesisVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURI") var baseURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURI") var entsoeURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class StringMeasurement(
     var stringMeasurementId: UUID? = null
)

@Entity
data class StringMeasurementValue(
    @Id var stringMeasurementValueId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: StringProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "stringMeasurementValues") var stringMeasurementValues:  Set<StringMeasurementValue>? = null
)

@Entity
data class StringProxy(
     var stringProxyId: UUID? = null
)

@Entity
data class SubGeographicalRegion(
    @Id var subGeographicalRegionId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "regions") var regions:  Set<SubGeographicalRegion>? = null
)

@Entity
data class SubLoadArea(
    @Id var subLoadAreaId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "subLoadAreas") var subLoadAreas:  Set<SubLoadArea>? = null
)

@Entity
data class Substation(
    @Id var substationId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "substations") var substations:  Set<Substation>? = null
)

@Entity
data class Susceptance(
    @Id var susceptanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class SvInjection(
    @Id var svInjectionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pInjection") var pInjection: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qInjection") var qInjection: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "svInjection") var svInjection: SvInjection? = null
)

@Entity
data class SvPowerFlow(
    @Id var svPowerFlowId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p") var p: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q") var q: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "svPowerFlow") var svPowerFlow: SvPowerFlow? = null
)

@Entity
data class SvShuntCompensatorSections(
    @Id var svShuntCompensatorSectionsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sections") var sections: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "svShuntCompensatorSections") var svShuntCompensatorSections: SvShuntCompensatorSections? = null
)

@Entity
data class SvStatus(
    @Id var svStatusId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "inService") var inService: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "svStatus") var svStatus: SvStatus? = null
)

@Entity
data class SvTapStep(
    @Id var svTapStepId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "position") var position: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "svTapStep") var svTapStep: SvTapStep? = null
)

@Entity
data class SvVoltage(
    @Id var svVoltageId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "angle") var angle: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "v") var v: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "svVoltage") var svVoltage: SvVoltage? = null
)

@Entity
data class SwitchIt(
    @Id var switchItId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "open") var open: BooleanProxy? = null
)

@Entity
data class SwitchProxy(
    @Id var switchProxyId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "normalOpen") var normalOpen: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratedCurrent") var ratedCurrent: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "retained") var retained: BooleanProxy? = null
)

@Entity
data class SwitchSchedule(
    @Id var switchScheduleId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "switchSchedules") var switchSchedules:  Set<SwitchSchedule>? = null
)

@Entity
data class SynchronousMachine(
    @Id var synchronousMachineId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "earthing") var earthing: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "earthingStarPointR") var earthingStarPointR: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "earthingStarPointX") var earthingStarPointX: Reactance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ikk") var ikk: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxQ") var maxQ: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "minQ") var minQ: ReactivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mu") var mu: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qPercent") var qPercent: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r0") var r0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r2") var r2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "satDirectSubtransX") var satDirectSubtransX: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "satDirectSyncX") var satDirectSyncX: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "satDirectTransX") var satDirectTransX: PU? = null,
    @Enumerated(EnumType.STRING) var shortCircuitRotorType: ShortCircuitRotorKind? = null,
    @Enumerated(EnumType.STRING) var type: SynchronousMachineKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voltageRegulationRange") var voltageRegulationRange: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x0") var x0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x2") var x2: PU? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "initiallyUsedBySynchronousMachines") var initiallyUsedBySynchronousMachines:  Set<SynchronousMachine>? = null
)

@Entity
data class SynchronousMachineDetailed(
    @Id var synchronousMachineDetailedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "efdBaseRatio") var efdBaseRatio: Simple_Float? = null,
    @Enumerated(EnumType.STRING) var ifdBaseType: IfdBaseKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ifdBaseValue") var ifdBaseValue: CurrentFlow? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "saturationFactor120QAxis") var saturationFactor120QAxis: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "saturationFactorQAxis") var saturationFactorQAxis: Simple_Float? = null
)

@Entity
data class SynchronousMachineDynamics(
    @Id var synchronousMachineDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "synchronousMachineDynamics") var synchronousMachineDynamics: SynchronousMachineDynamics? = null
)

@Entity
data class SynchronousMachineEquivalentCircuit(
    @Id var synchronousMachineEquivalentCircuitId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r1d") var r1d: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r1q") var r1q: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r2q") var r2q: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rfd") var rfd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x1d") var x1d: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x1q") var x1q: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x2q") var x2q: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xad") var xad: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xaq") var xaq: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xf1d") var xf1d: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xfd") var xfd: PU? = null
)

@Entity
data class SynchronousMachineSimplified(
     var synchronousMachineSimplifiedId: UUID? = null
)

@Entity
data class SynchronousMachineTimeConstantReactance(
    @Id var synchronousMachineTimeConstantReactanceId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ks") var ks: Simple_Float? = null,
    @Enumerated(EnumType.STRING) var modelType: SynchronousMachineModelKind? = null,
    @Enumerated(EnumType.STRING) var rotorType: RotorKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tc") var tc: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpdo") var tpdo: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tppdo") var tppdo: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tppqo") var tppqo: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpqo") var tpqo: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xDirectSubtrans") var xDirectSubtrans: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xDirectSync") var xDirectSync: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xDirectTrans") var xDirectTrans: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xQuadSubtrans") var xQuadSubtrans: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xQuadSync") var xQuadSync: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xQuadTrans") var xQuadTrans: PU? = null
)

@Entity
data class SynchronousMachineUserDefined(
    @Id var synchronousMachineUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class TapChanger(
    @Id var tapChangerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "highStep") var highStep: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lowStep") var lowStep: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ltcFlag") var ltcFlag: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "neutralStep") var neutralStep: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "neutralU") var neutralU: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "normalStep") var normalStep: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "tapChanger") var tapChanger:  Set<TapChanger>? = null
)

@Entity
data class TapChangerControl(
     var tapChangerControlId: UUID? = null
)

@Entity
data class TapChangerTablePoint(
    @Id var tapChangerTablePointId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "b") var b: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "g") var g: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PerCent? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ratio") var ratio: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "step") var step: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "x") var x: PerCent? = null
)

@Entity
data class TapSchedule(
    @Id var tapScheduleId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "tapSchedules") var tapSchedules:  Set<TapSchedule>? = null
)

@Entity
data class Temperature(
    @Id var temperatureId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class Terminal(
    @Id var terminalId: UUID? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "terminals") var terminals:  Set<Terminal>? = null
)

@Entity
data class TextDiagramObject(
    @Id var textDiagramObjectId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "text") var text: StringProxy? = null
)

@Entity
data class ThermalGeneratingUnit(
     var thermalGeneratingUnitId: UUID? = null
)

@Entity
data class TieFlow(
    @Id var tieFlowId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "positiveFlowIn") var positiveFlowIn: BooleanProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "tieFlow") var tieFlow:  Set<TieFlow>? = null
)

@Entity
data class TopologicalIsland(
    @Id var topologicalIslandId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "topologicalIsland") var topologicalIsland: TopologicalIsland? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "angleRefTopologicalIsland") var angleRefTopologicalIsland: TopologicalIsland? = null
)

@Entity
data class TopologicalNode(
    @Id var topologicalNodeId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "boundaryPoint") var boundaryPoint: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndIsoCode") var fromEndIsoCode: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndName") var fromEndName: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fromEndNameTso") var fromEndNameTso: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndIsoCode") var toEndIsoCode: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndName") var toEndName: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "toEndNameTso") var toEndNameTso: StringProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "topologicalNode") var topologicalNode:  Set<TopologicalNode>? = null
)

@Entity
data class TopologyBoundaryVersion(
    @Id var topologyBoundaryVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURI") var baseURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURI") var entsoeURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class TopologyVersion(
    @Id var topologyVersionId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseUML") var baseUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "baseURI") var baseURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "date") var date: DateProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "differenceModelURI") var differenceModelURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeUML") var entsoeUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "entsoeURI") var entsoeURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "modelDescriptionURI") var modelDescriptionURI: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceRDF") var namespaceRDF: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "namespaceUML") var namespaceUML: StringProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "shortName") var shortName: StringProxy? = null
)

@Entity
data class TransformerEnd(
    @Id var transformerEndId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "endNumber") var endNumber: IntegerProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "grounded") var grounded: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rground") var rground: Resistance? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xground") var xground: Reactance? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "transformerEnds") var transformerEnds:  Set<TransformerEnd>? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "transformerEnd") var transformerEnd:  Set<TransformerEnd>? = null
)

@Entity
data class TurbLCFB1(
    @Id var turbLCFB1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "db") var db: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "emax") var emax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fb") var fb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fbf") var fbf: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "irmax") var irmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ki") var ki: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kp") var kp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwbase") var mwbase: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pbf") var pbf: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pmwset") var pmwset: ActivePower? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "speedReferenceGovernor") var speedReferenceGovernor: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpelec") var tpelec: Seconds? = null
)

@Entity
data class TurbineGovernorDynamics(
    @Id var turbineGovernorDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "turbineGovernorDynamics") var turbineGovernorDynamics: TurbineGovernorDynamics? = null
)

@Entity
data class TurbineGovernorUserDefined(
    @Id var turbineGovernorUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class TurbineLoadControllerDynamics(
    @Id var turbineLoadControllerDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "turbineLoadControllerDynamics") var turbineLoadControllerDynamics: TurbineLoadControllerDynamics? = null
)

@Entity
data class TurbineLoadControllerUserDefined(
    @Id var turbineLoadControllerUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class UnderexcLim2Simplified(
    @Id var underexcLim2SimplifiedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kui") var kui: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p0") var p0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p1") var p1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q0") var q0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q1") var q1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vuimax") var vuimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vuimin") var vuimin: PU? = null
)

@Entity
data class UnderexcLimIEEE1(
    @Id var underexcLimIEEE1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kuc") var kuc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kuf") var kuf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kui") var kui: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kul") var kul: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kur") var kur: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tu1") var tu1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tu2") var tu2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tu3") var tu3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tu4") var tu4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vucmax") var vucmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vuimax") var vuimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vuimin") var vuimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vulmax") var vulmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vulmin") var vulmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vurmax") var vurmax: PU? = null
)

@Entity
data class UnderexcLimIEEE2(
    @Id var underexcLimIEEE2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k1") var k1: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k2") var k2: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kfb") var kfb: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kuf") var kuf: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kui") var kui: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kul") var kul: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p0") var p0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p1") var p1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p10") var p10: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p2") var p2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p3") var p3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p4") var p4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p5") var p5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p6") var p6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p7") var p7: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p8") var p8: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "p9") var p9: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q0") var q0: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q1") var q1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q10") var q10: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q2") var q2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q3") var q3: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q4") var q4: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q5") var q5: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q6") var q6: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q7") var q7: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q8") var q8: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "q9") var q9: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tu1") var tu1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tu2") var tu2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tu3") var tu3: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tu4") var tu4: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tul") var tul: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tup") var tup: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tuq") var tuq: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tuv") var tuv: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vuimax") var vuimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vuimin") var vuimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vulmax") var vulmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vulmin") var vulmin: PU? = null
)

@Entity
data class UnderexcLimX1(
    @Id var underexcLimX1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "k") var k: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf2") var kf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "km") var km: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "melmax") var melmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf2") var tf2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tm") var tm: Seconds? = null
)

@Entity
data class UnderexcLimX2(
    @Id var underexcLimX2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kf2") var kf2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "km") var km: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "melmax") var melmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qo") var qo: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "r") var r: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tf2") var tf2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tm") var tm: Seconds? = null
)

@Entity
data class UnderexcitationLimiterDynamics(
    @Id var underexcitationLimiterDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "underexcitationLimiterDynamics") var underexcitationLimiterDynamics: UnderexcitationLimiterDynamics? = null
)

@Entity
data class UnderexcitationLimiterUserDefined(
    @Id var underexcitationLimiterUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class Unresolvedname(
     var unresolvednameId: UUID? = null
)

@Entity
data class VAdjIEEE(
    @Id var vAdjIEEEId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "adjslew") var adjslew: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "taoff") var taoff: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "taon") var taon: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vadjf") var vadjf: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vadjmax") var vadjmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "vadjmin") var vadjmin: PU? = null
)

@Entity
data class VCompIEEEType1(
    @Id var vCompIEEEType1Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rc") var rc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xc") var xc: PU? = null
)

@Entity
data class VCompIEEEType2(
    @Id var vCompIEEEType2Id: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tr") var tr: Seconds? = null
)

@Entity
data class ValueAliasSet(
     var valueAliasSetId: UUID? = null
)

@Entity
data class ValueToAlias(
    @Id var valueToAliasId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "values") var values:  Set<ValueToAlias>? = null
)

@Entity
data class VisibilityLayer(
    @Id var visibilityLayerId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "drawingOrder") var drawingOrder: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "visibilityLayers") var visibilityLayers:  Set<VisibilityLayer>? = null
)

@Entity
data class Voltage(
    @Id var voltageId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class VoltageAdjusterDynamics(
    @Id var voltageAdjusterDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voltageAdjusterDynamics") var voltageAdjusterDynamics: VoltageAdjusterDynamics? = null
)

@Entity
data class VoltageAdjusterUserDefined(
    @Id var voltageAdjusterUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class VoltageCompensatorDynamics(
    @Id var voltageCompensatorDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "voltageCompensatorDynamics") var voltageCompensatorDynamics: VoltageCompensatorDynamics? = null
)

@Entity
data class VoltageCompensatorUserDefined(
    @Id var voltageCompensatorUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class VoltageLevel(
    @Id var voltageLevelId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "highVoltageLimit") var highVoltageLimit: Voltage? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lowVoltageLimit") var lowVoltageLimit: Voltage? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "voltageLevel") var voltageLevel:  Set<VoltageLevel>? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "voltageLevels") var voltageLevels:  Set<VoltageLevel>? = null
)

@Entity
data class VoltageLimit(
    @Id var voltageLimitId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: Voltage? = null
)

@Entity
data class VoltagePerReactivePower(
    @Id var voltagePerReactivePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class VolumeFlowRate(
    @Id var volumeFlowRateId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier? = null,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "value") var value: FloatProxy? = null
)

@Entity
data class VsCapabilityCurve(
     var vsCapabilityCurveId: UUID? = null
)

@Entity
data class VsConverter(
    @Id var vsConverterId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxModulationIndex") var maxModulationIndex: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "maxValveCurrent") var maxValveCurrent: CurrentFlow? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "vsConverterDCSides") var vsConverterDCSides:  Set<VsConverter>? = null
)

@Entity
data class WindAeroConstIEC(
     var windAeroConstIECId: UUID? = null
)

@Entity
data class WindAeroLinearIEC(
    @Id var windAeroLinearIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dpomega") var dpomega: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dptheta") var dptheta: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "omegazero") var omegazero: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pavail") var pavail: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thetazero") var thetazero: AngleDegrees? = null
)

@Entity
data class WindContCurrLimIEC(
    @Id var windContCurrLimIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "imax") var imax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "imaxdip") var imaxdip: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mdfslim") var mdfslim: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mqpri") var mqpri: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tufilt") var tufilt: Seconds? = null
)

@Entity
data class WindContPType3IEC(
    @Id var windContPType3IECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dpmax") var dpmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dtrisemaxlvrt") var dtrisemaxlvrt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdtd") var kdtd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kip") var kip: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpp") var kpp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mplvrt") var mplvrt: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "omegaoffset") var omegaoffset: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pdtdmax") var pdtdmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rramp") var rramp: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tdvs") var tdvs: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "temin") var temin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tomegafilt") var tomegafilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpfilt") var tpfilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpord") var tpord: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tufilt") var tufilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tuscale") var tuscale: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twref") var twref: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "udvs") var udvs: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "updip") var updip: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "wdtd") var wdtd: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "zeta") var zeta: Simple_Float? = null
)

@Entity
data class WindContPType4aIEC(
    @Id var windContPType4aIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dpmax") var dpmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpord") var tpord: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tufilt") var tufilt: Seconds? = null
)

@Entity
data class WindContPType4bIEC(
    @Id var windContPType4bIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dpmax") var dpmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpaero") var tpaero: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpord") var tpord: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tufilt") var tufilt: Seconds? = null
)

@Entity
data class WindContPitchAngleIEC(
    @Id var windContPitchAngleIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dthetamax") var dthetamax: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dthetamin") var dthetamin: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kic") var kic: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kiomega") var kiomega: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpc") var kpc: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpomega") var kpomega: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpx") var kpx: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thetamax") var thetamax: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "thetamin") var thetamin: AngleDegrees? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "ttheta") var ttheta: Seconds? = null
)

@Entity
data class WindContQIEC(
    @Id var windContQIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "iqh1") var iqh1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "iqmax") var iqmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "iqmin") var iqmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "iqpost") var iqpost: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kiq") var kiq: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kiu") var kiu: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpq") var kpq: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpu") var kpu: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kqv") var kqv: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qmax") var qmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "qmin") var qmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rdroop") var rdroop: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tiq") var tiq: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpfilt") var tpfilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpost") var tpost: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tqord") var tqord: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tufilt") var tufilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "udb1") var udb1: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "udb2") var udb2: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "umax") var umax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "umin") var umin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uqdip") var uqdip: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uref0") var uref0: PU? = null,
    @Enumerated(EnumType.STRING) var windLVRTQcontrolModesType: WindLVRTQcontrolModesKind? = null,
    @Enumerated(EnumType.STRING) var windQcontrolModesType: WindQcontrolModesKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xdroop") var xdroop: PU? = null
)

@Entity
data class WindContRotorRIEC(
    @Id var windContRotorRIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kirr") var kirr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "komegafilt") var komegafilt: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpfilt") var kpfilt: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kprr") var kprr: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rmax") var rmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "rmin") var rmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tomegafilt") var tomegafilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpfilt") var tpfilt: Seconds? = null
)

@Entity
data class WindDynamicsLookupTable(
    @Id var windDynamicsLookupTableId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "input") var input: Simple_Float? = null,
    @Enumerated(EnumType.STRING) var lookupTableFunctionType: WindLookupTableFunctionKind? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "output") var output: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "sequence") var sequence: IntegerProxy? = null,
    @OneToMany(fetch = FetchType.EAGER) @JoinColumn(name = "windDynamicsLookupTable") var windDynamicsLookupTable:  Set<WindDynamicsLookupTable>? = null
)

@Entity
data class WindGenTurbineType1IEC(
    @Id var windGenTurbineType1IECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windGenTurbineType1IEC") var windGenTurbineType1IEC: WindGenTurbineType1IEC? = null
)

@Entity
data class WindGenTurbineType2IEC(
    @Id var windGenTurbineType2IECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windGenTurbineType2IEC") var windGenTurbineType2IEC: WindGenTurbineType2IEC? = null
)

@Entity
data class WindGenTurbineType3IEC(
    @Id var windGenTurbineType3IECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dipmax") var dipmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "diqmax") var diqmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windGenTurbineType3IEC") var windGenTurbineType3IEC: WindGenTurbineType3IEC? = null
)

@Entity
data class WindGenTurbineType3aIEC(
    @Id var windGenTurbineType3aIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpc") var kpc: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tic") var tic: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xs") var xs: PU? = null
)

@Entity
data class WindGenTurbineType3bIEC(
    @Id var windGenTurbineType3bIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fducw") var fducw: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwtcwp") var mwtcwp: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "two") var two: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xs") var xs: PU? = null
)

@Entity
data class WindGenType4IEC(
    @Id var windGenType4IECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dipmax") var dipmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "diqmax") var diqmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "diqmin") var diqmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tg") var tg: Seconds? = null
)

@Entity
data class WindGeneratingUnit(
    @Id var windGeneratingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var windGenUnitType: WindGenUnitKind? = null
)

@Entity
data class WindMechIEC(
    @Id var windMechIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "cdrt") var cdrt: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hgen") var hgen: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hwtr") var hwtr: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdrt") var kdrt: PU? = null
)

@Entity
data class WindPitchContEmulIEC(
    @Id var windPitchContEmulIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kdroop") var kdroop: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kipce") var kipce: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "komegaaero") var komegaaero: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kppce") var kppce: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "omegaref") var omegaref: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pimax") var pimax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "pimin") var pimin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t1") var t1: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "t2") var t2: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpe") var tpe: Seconds? = null
)

@Entity
data class WindPlantDynamics(
    @Id var windPlantDynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windPlantDynamics") var windPlantDynamics: WindPlantDynamics? = null
)

@Entity
data class WindPlantFreqPcontrolIEC(
    @Id var windPlantFreqPcontrolIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dprefmax") var dprefmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dprefmin") var dprefmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kiwpp") var kiwpp: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpwpp") var kpwpp: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "prefmax") var prefmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "prefmin") var prefmin: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpft") var tpft: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tpfv") var tpfv: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twpffilt") var twpffilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twppfilt") var twppfilt: Seconds? = null
)

@Entity
data class WindPlantIEC(
    @Id var windPlantIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windPlantIEC") var windPlantIEC: WindPlantIEC? = null
)

@Entity
data class WindPlantReactiveControlIEC(
    @Id var windPlantReactiveControlIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kiwpx") var kiwpx: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kpwpx") var kpwpx: Simple_Float? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "kwpqu") var kwpqu: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwppf") var mwppf: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "mwpu") var mwpu: BooleanProxy? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twppfilt") var twppfilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twpqfilt") var twpqfilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "twpufilt") var twpufilt: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "txft") var txft: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "txfv") var txfv: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uwpqdip") var uwpqdip: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xrefmax") var xrefmax: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "xrefmin") var xrefmin: PU? = null
)

@Entity
data class WindPlantUserDefined(
    @Id var windPlantUserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class WindProtectionIEC(
    @Id var windProtectionIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "fover") var fover: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "funder") var funder: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tfover") var tfover: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tfunder") var tfunder: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tuover") var tuover: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "tuunder") var tuunder: Seconds? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uover") var uover: PU? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "uunder") var uunder: PU? = null
)

@Entity
data class WindTurbineType1or2Dynamics(
    @Id var windTurbineType1or2DynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windTurbineType1or2Dynamics") var windTurbineType1or2Dynamics: WindTurbineType1or2Dynamics? = null
)

@Entity
data class WindTurbineType1or2IEC(
    @Id var windTurbineType1or2IECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windTurbineType1or2IEC") var windTurbineType1or2IEC: WindTurbineType1or2IEC? = null
)

@Entity
data class WindTurbineType3or4Dynamics(
    @Id var windTurbineType3or4DynamicsId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windTurbineType3or4Dynamics") var windTurbineType3or4Dynamics: WindTurbineType3or4Dynamics? = null
)

@Entity
data class WindTurbineType3or4IEC(
    @Id var windTurbineType3or4IECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windTurbineType3or4IEC") var windTurbineType3or4IEC: WindTurbineType3or4IEC? = null
)

@Entity
data class WindTurbineType4aIEC(
    @Id var windTurbineType4aIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windTurbineType4aIEC") var windTurbineType4aIEC: WindTurbineType4aIEC? = null
)

@Entity
data class WindTurbineType4bIEC(
    @Id var windTurbineType4bIECId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "windTurbineType4bIEC") var windTurbineType4bIEC: WindTurbineType4bIEC? = null
)

@Entity
data class WindType1or2UserDefined(
    @Id var windType1or2UserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

@Entity
data class WindType3or4UserDefined(
    @Id var windType3or4UserDefinedId: UUID? = null,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "proprietary") var proprietary: BooleanProxy? = null
)

