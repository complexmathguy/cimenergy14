/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.api;

import java.time.Instant
import java.util.*

import javax.persistence.*

import com.occulue.entity.*;


//-----------------------------------------------------------
// Event definitions
//-----------------------------------------------------------

// ACDCConverter Events

data class CreateACDCConverterEvent(
     var aCDCConverterId: UUID? = null
)

data class UpdateACDCConverterEvent(
    @Id var aCDCConverterId: UUID? = null,
    var baseS: ApparentPower,
    var idleLoss: ActivePower,
    var maxUdc: Voltage,
    var minUdc: Voltage,
    var numberOfValves: IntegerProxy,
    var ratedUdc: Voltage,
    var resistiveLoss: Resistance,
    var switchingLoss: ActivePowerPerCurrentFlow,
    var valveU0: Voltage,
    var converterDCSides:  Set<ACDCConverter>
)

data class DeleteACDCConverterEvent(@Id val aCDCConverterId: UUID? = null)

// single association events
data class AssignBaseSToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: ApparentPower )
data class UnAssignBaseSFromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )
data class AssignIdleLossToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: ActivePower )
data class UnAssignIdleLossFromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )
data class AssignMaxUdcToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: Voltage )
data class UnAssignMaxUdcFromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )
data class AssignMinUdcToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: Voltage )
data class UnAssignMinUdcFromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )
data class AssignNumberOfValvesToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: IntegerProxy )
data class UnAssignNumberOfValvesFromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )
data class AssignRatedUdcToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: Voltage )
data class UnAssignRatedUdcFromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )
data class AssignResistiveLossToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: Resistance )
data class UnAssignResistiveLossFromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )
data class AssignSwitchingLossToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: ActivePowerPerCurrentFlow )
data class UnAssignSwitchingLossFromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )
data class AssignValveU0ToACDCConverterEvent(@Id val aCDCConverterId: UUID, val assignment: Voltage )
data class UnAssignValveU0FromACDCConverterEvent(@Id val aCDCConverterId: UUID? = null )

// multiple association events
data class AssignConverterDCSidesToACDCConverterEvent(@Id val aCDCConverterId: UUID, val addTo: ACDCConverter )
data class RemoveConverterDCSidesFromACDCConverterEvent(@Id val aCDCConverterId: UUID, val removeFrom: ACDCConverter )


// ACDCConverterDCTerminal Events

data class CreateACDCConverterDCTerminalEvent(
    @Id var aCDCConverterDCTerminalId: UUID? = null,
    @Enumerated(EnumType.STRING) var polarity: DCPolarityKind
)

data class UpdateACDCConverterDCTerminalEvent(
    @Id var aCDCConverterDCTerminalId: UUID? = null,
    @Enumerated(EnumType.STRING) var polarity: DCPolarityKind,
    var dCTerminals:  Set<ACDCConverterDCTerminal>
)

data class DeleteACDCConverterDCTerminalEvent(@Id val aCDCConverterDCTerminalId: UUID? = null)

// single association events

// multiple association events
data class AssignDCTerminalsToACDCConverterDCTerminalEvent(@Id val aCDCConverterDCTerminalId: UUID, val addTo: ACDCConverterDCTerminal )
data class RemoveDCTerminalsFromACDCConverterDCTerminalEvent(@Id val aCDCConverterDCTerminalId: UUID, val removeFrom: ACDCConverterDCTerminal )


// ACDCTerminal Events

data class CreateACDCTerminalEvent(
     var aCDCTerminalId: UUID? = null
)

data class UpdateACDCTerminalEvent(
    @Id var aCDCTerminalId: UUID? = null,
    var sequenceNumber: IntegerProxy,
    var terminal:  Set<ACDCTerminal>
)

data class DeleteACDCTerminalEvent(@Id val aCDCTerminalId: UUID? = null)

// single association events
data class AssignSequenceNumberToACDCTerminalEvent(@Id val aCDCTerminalId: UUID, val assignment: IntegerProxy )
data class UnAssignSequenceNumberFromACDCTerminalEvent(@Id val aCDCTerminalId: UUID? = null )

// multiple association events
data class AssignTerminalToACDCTerminalEvent(@Id val aCDCTerminalId: UUID, val addTo: ACDCTerminal )
data class RemoveTerminalFromACDCTerminalEvent(@Id val aCDCTerminalId: UUID, val removeFrom: ACDCTerminal )


// ACLineSegment Events

data class CreateACLineSegmentEvent(
     var aCLineSegmentId: UUID? = null
)

data class UpdateACLineSegmentEvent(
    @Id var aCLineSegmentId: UUID? = null,
    var b0ch: Susceptance,
    var bch: Susceptance,
    var g0ch: Conductance,
    var gch: Conductance,
    var r: Resistance,
    var r0: Resistance,
    var shortCircuitEndTemperature: Temperature,
    var x: Reactance,
    var x0: Reactance
)

data class DeleteACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null)

// single association events
data class AssignB0chToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Susceptance )
data class UnAssignB0chFromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )
data class AssignBchToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Susceptance )
data class UnAssignBchFromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )
data class AssignG0chToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Conductance )
data class UnAssignG0chFromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )
data class AssignGchToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Conductance )
data class UnAssignGchFromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )
data class AssignRToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Resistance )
data class UnAssignRFromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )
data class AssignR0ToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Resistance )
data class UnAssignR0FromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )
data class AssignShortCircuitEndTemperatureToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Temperature )
data class UnAssignShortCircuitEndTemperatureFromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )
data class AssignXToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Reactance )
data class UnAssignXFromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )
data class AssignX0ToACLineSegmentEvent(@Id val aCLineSegmentId: UUID, val assignment: Reactance )
data class UnAssignX0FromACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null )

// multiple association events


// Accumulator Events

data class CreateAccumulatorEvent(
     var accumulatorId: UUID? = null
)

data class UpdateAccumulatorEvent(
     var accumulatorId: UUID? = null
)

data class DeleteAccumulatorEvent(@Id val accumulatorId: UUID? = null)

// single association events

// multiple association events


// AccumulatorLimit Events

data class CreateAccumulatorLimitEvent(
     var accumulatorLimitId: UUID? = null
)

data class UpdateAccumulatorLimitEvent(
    @Id var accumulatorLimitId: UUID? = null,
    var value: IntegerProxy,
    var limits:  Set<AccumulatorLimit>
)

data class DeleteAccumulatorLimitEvent(@Id val accumulatorLimitId: UUID? = null)

// single association events
data class AssignValueToAccumulatorLimitEvent(@Id val accumulatorLimitId: UUID, val assignment: IntegerProxy )
data class UnAssignValueFromAccumulatorLimitEvent(@Id val accumulatorLimitId: UUID? = null )

// multiple association events
data class AssignLimitsToAccumulatorLimitEvent(@Id val accumulatorLimitId: UUID, val addTo: AccumulatorLimit )
data class RemoveLimitsFromAccumulatorLimitEvent(@Id val accumulatorLimitId: UUID, val removeFrom: AccumulatorLimit )


// AccumulatorLimitSet Events

data class CreateAccumulatorLimitSetEvent(
     var accumulatorLimitSetId: UUID? = null
)

data class UpdateAccumulatorLimitSetEvent(
    @Id var accumulatorLimitSetId: UUID? = null,
    var limitSets:  Set<AccumulatorLimitSet>
)

data class DeleteAccumulatorLimitSetEvent(@Id val accumulatorLimitSetId: UUID? = null)

// single association events

// multiple association events
data class AssignLimitSetsToAccumulatorLimitSetEvent(@Id val accumulatorLimitSetId: UUID, val addTo: AccumulatorLimitSet )
data class RemoveLimitSetsFromAccumulatorLimitSetEvent(@Id val accumulatorLimitSetId: UUID, val removeFrom: AccumulatorLimitSet )


// AccumulatorReset Events

data class CreateAccumulatorResetEvent(
     var accumulatorResetId: UUID? = null
)

data class UpdateAccumulatorResetEvent(
    @Id var accumulatorResetId: UUID? = null,
    var accumulatorReset: AccumulatorReset
)

data class DeleteAccumulatorResetEvent(@Id val accumulatorResetId: UUID? = null)

// single association events
data class AssignAccumulatorResetToAccumulatorResetEvent(@Id val accumulatorResetId: UUID, val assignment: AccumulatorReset )
data class UnAssignAccumulatorResetFromAccumulatorResetEvent(@Id val accumulatorResetId: UUID? = null )

// multiple association events


// AccumulatorValue Events

data class CreateAccumulatorValueEvent(
     var accumulatorValueId: UUID? = null
)

data class UpdateAccumulatorValueEvent(
    @Id var accumulatorValueId: UUID? = null,
    var value: IntegerProxy,
    var accumulatorValues:  Set<AccumulatorValue>
)

data class DeleteAccumulatorValueEvent(@Id val accumulatorValueId: UUID? = null)

// single association events
data class AssignValueToAccumulatorValueEvent(@Id val accumulatorValueId: UUID, val assignment: IntegerProxy )
data class UnAssignValueFromAccumulatorValueEvent(@Id val accumulatorValueId: UUID? = null )

// multiple association events
data class AssignAccumulatorValuesToAccumulatorValueEvent(@Id val accumulatorValueId: UUID, val addTo: AccumulatorValue )
data class RemoveAccumulatorValuesFromAccumulatorValueEvent(@Id val accumulatorValueId: UUID, val removeFrom: AccumulatorValue )


// ActivePower Events

data class CreateActivePowerEvent(
    @Id var activePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateActivePowerEvent(
    @Id var activePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteActivePowerEvent(@Id val activePowerId: UUID? = null)

// single association events
data class AssignValueToActivePowerEvent(@Id val activePowerId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromActivePowerEvent(@Id val activePowerId: UUID? = null )

// multiple association events


// ActivePowerLimit Events

data class CreateActivePowerLimitEvent(
     var activePowerLimitId: UUID? = null
)

data class UpdateActivePowerLimitEvent(
    @Id var activePowerLimitId: UUID? = null,
    var value: ActivePower
)

data class DeleteActivePowerLimitEvent(@Id val activePowerLimitId: UUID? = null)

// single association events
data class AssignValueToActivePowerLimitEvent(@Id val activePowerLimitId: UUID, val assignment: ActivePower )
data class UnAssignValueFromActivePowerLimitEvent(@Id val activePowerLimitId: UUID? = null )

// multiple association events


// ActivePowerPerCurrentFlow Events

data class CreateActivePowerPerCurrentFlowEvent(
     var activePowerPerCurrentFlowId: UUID? = null
)

data class UpdateActivePowerPerCurrentFlowEvent(
     var activePowerPerCurrentFlowId: UUID? = null
)

data class DeleteActivePowerPerCurrentFlowEvent(@Id val activePowerPerCurrentFlowId: UUID? = null)

// single association events

// multiple association events


// ActivePowerPerFrequency Events

data class CreateActivePowerPerFrequencyEvent(
    @Id var activePowerPerFrequencyId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateActivePowerPerFrequencyEvent(
    @Id var activePowerPerFrequencyId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteActivePowerPerFrequencyEvent(@Id val activePowerPerFrequencyId: UUID? = null)

// single association events
data class AssignValueToActivePowerPerFrequencyEvent(@Id val activePowerPerFrequencyId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromActivePowerPerFrequencyEvent(@Id val activePowerPerFrequencyId: UUID? = null )

// multiple association events


// Analog Events

data class CreateAnalogEvent(
     var analogId: UUID? = null
)

data class UpdateAnalogEvent(
    @Id var analogId: UUID? = null,
    var positiveFlowIn: BooleanProxy
)

data class DeleteAnalogEvent(@Id val analogId: UUID? = null)

// single association events
data class AssignPositiveFlowInToAnalogEvent(@Id val analogId: UUID, val assignment: BooleanProxy )
data class UnAssignPositiveFlowInFromAnalogEvent(@Id val analogId: UUID? = null )

// multiple association events


// AnalogControl Events

data class CreateAnalogControlEvent(
     var analogControlId: UUID? = null
)

data class UpdateAnalogControlEvent(
    @Id var analogControlId: UUID? = null,
    var maxValue: Simple_Float,
    var minValue: Simple_Float,
    var analogControl: AnalogControl
)

data class DeleteAnalogControlEvent(@Id val analogControlId: UUID? = null)

// single association events
data class AssignMaxValueToAnalogControlEvent(@Id val analogControlId: UUID, val assignment: Simple_Float )
data class UnAssignMaxValueFromAnalogControlEvent(@Id val analogControlId: UUID? = null )
data class AssignMinValueToAnalogControlEvent(@Id val analogControlId: UUID, val assignment: Simple_Float )
data class UnAssignMinValueFromAnalogControlEvent(@Id val analogControlId: UUID? = null )
data class AssignAnalogControlToAnalogControlEvent(@Id val analogControlId: UUID, val assignment: AnalogControl )
data class UnAssignAnalogControlFromAnalogControlEvent(@Id val analogControlId: UUID? = null )

// multiple association events


// AnalogLimit Events

data class CreateAnalogLimitEvent(
     var analogLimitId: UUID? = null
)

data class UpdateAnalogLimitEvent(
    @Id var analogLimitId: UUID? = null,
    var value: Simple_Float,
    var limits:  Set<AnalogLimit>
)

data class DeleteAnalogLimitEvent(@Id val analogLimitId: UUID? = null)

// single association events
data class AssignValueToAnalogLimitEvent(@Id val analogLimitId: UUID, val assignment: Simple_Float )
data class UnAssignValueFromAnalogLimitEvent(@Id val analogLimitId: UUID? = null )

// multiple association events
data class AssignLimitsToAnalogLimitEvent(@Id val analogLimitId: UUID, val addTo: AnalogLimit )
data class RemoveLimitsFromAnalogLimitEvent(@Id val analogLimitId: UUID, val removeFrom: AnalogLimit )


// AnalogLimitSet Events

data class CreateAnalogLimitSetEvent(
     var analogLimitSetId: UUID? = null
)

data class UpdateAnalogLimitSetEvent(
    @Id var analogLimitSetId: UUID? = null,
    var limitSets:  Set<AnalogLimitSet>
)

data class DeleteAnalogLimitSetEvent(@Id val analogLimitSetId: UUID? = null)

// single association events

// multiple association events
data class AssignLimitSetsToAnalogLimitSetEvent(@Id val analogLimitSetId: UUID, val addTo: AnalogLimitSet )
data class RemoveLimitSetsFromAnalogLimitSetEvent(@Id val analogLimitSetId: UUID, val removeFrom: AnalogLimitSet )


// AnalogValue Events

data class CreateAnalogValueEvent(
     var analogValueId: UUID? = null
)

data class UpdateAnalogValueEvent(
    @Id var analogValueId: UUID? = null,
    var value: Simple_Float,
    var analogValues:  Set<AnalogValue>
)

data class DeleteAnalogValueEvent(@Id val analogValueId: UUID? = null)

// single association events
data class AssignValueToAnalogValueEvent(@Id val analogValueId: UUID, val assignment: Simple_Float )
data class UnAssignValueFromAnalogValueEvent(@Id val analogValueId: UUID? = null )

// multiple association events
data class AssignAnalogValuesToAnalogValueEvent(@Id val analogValueId: UUID, val addTo: AnalogValue )
data class RemoveAnalogValuesFromAnalogValueEvent(@Id val analogValueId: UUID, val removeFrom: AnalogValue )


// AngleDegrees Events

data class CreateAngleDegreesEvent(
    @Id var angleDegreesId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateAngleDegreesEvent(
    @Id var angleDegreesId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteAngleDegreesEvent(@Id val angleDegreesId: UUID? = null)

// single association events
data class AssignValueToAngleDegreesEvent(@Id val angleDegreesId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromAngleDegreesEvent(@Id val angleDegreesId: UUID? = null )

// multiple association events


// AngleRadians Events

data class CreateAngleRadiansEvent(
    @Id var angleRadiansId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateAngleRadiansEvent(
    @Id var angleRadiansId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteAngleRadiansEvent(@Id val angleRadiansId: UUID? = null)

// single association events
data class AssignValueToAngleRadiansEvent(@Id val angleRadiansId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromAngleRadiansEvent(@Id val angleRadiansId: UUID? = null )

// multiple association events


// ApparentPower Events

data class CreateApparentPowerEvent(
    @Id var apparentPowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateApparentPowerEvent(
    @Id var apparentPowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteApparentPowerEvent(@Id val apparentPowerId: UUID? = null)

// single association events
data class AssignValueToApparentPowerEvent(@Id val apparentPowerId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromApparentPowerEvent(@Id val apparentPowerId: UUID? = null )

// multiple association events


// ApparentPowerLimit Events

data class CreateApparentPowerLimitEvent(
     var apparentPowerLimitId: UUID? = null
)

data class UpdateApparentPowerLimitEvent(
    @Id var apparentPowerLimitId: UUID? = null,
    var value: ApparentPower
)

data class DeleteApparentPowerLimitEvent(@Id val apparentPowerLimitId: UUID? = null)

// single association events
data class AssignValueToApparentPowerLimitEvent(@Id val apparentPowerLimitId: UUID, val assignment: ApparentPower )
data class UnAssignValueFromApparentPowerLimitEvent(@Id val apparentPowerLimitId: UUID? = null )

// multiple association events


// Area Events

data class CreateAreaEvent(
    @Id var areaId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateAreaEvent(
    @Id var areaId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteAreaEvent(@Id val areaId: UUID? = null)

// single association events
data class AssignValueToAreaEvent(@Id val areaId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromAreaEvent(@Id val areaId: UUID? = null )

// multiple association events


// AsynchronousMachine Events

data class CreateAsynchronousMachineEvent(
     var asynchronousMachineId: UUID? = null
)

data class UpdateAsynchronousMachineEvent(
    @Id var asynchronousMachineId: UUID? = null,
    var converterFedDrive: BooleanProxy,
    var efficiency: PerCent,
    var iaIrRatio: Simple_Float,
    var nominalFrequency: Frequency,
    var nominalSpeed: RotationSpeed,
    var polePairNumber: IntegerProxy,
    var ratedMechanicalPower: ActivePower,
    var reversible: BooleanProxy,
    var rxLockedRotorRatio: Simple_Float
)

data class DeleteAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null)

// single association events
data class AssignConverterFedDriveToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: BooleanProxy )
data class UnAssignConverterFedDriveFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )
data class AssignEfficiencyToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: PerCent )
data class UnAssignEfficiencyFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )
data class AssignIaIrRatioToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: Simple_Float )
data class UnAssignIaIrRatioFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )
data class AssignNominalFrequencyToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: Frequency )
data class UnAssignNominalFrequencyFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )
data class AssignNominalSpeedToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: RotationSpeed )
data class UnAssignNominalSpeedFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )
data class AssignPolePairNumberToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: IntegerProxy )
data class UnAssignPolePairNumberFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )
data class AssignRatedMechanicalPowerToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: ActivePower )
data class UnAssignRatedMechanicalPowerFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )
data class AssignReversibleToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: BooleanProxy )
data class UnAssignReversibleFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )
data class AssignRxLockedRotorRatioToAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID, val assignment: Simple_Float )
data class UnAssignRxLockedRotorRatioFromAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null )

// multiple association events


// AsynchronousMachineDynamics Events

data class CreateAsynchronousMachineDynamicsEvent(
     var asynchronousMachineDynamicsId: UUID? = null
)

data class UpdateAsynchronousMachineDynamicsEvent(
    @Id var asynchronousMachineDynamicsId: UUID? = null,
    var asynchronousMachineDynamics: AsynchronousMachineDynamics
)

data class DeleteAsynchronousMachineDynamicsEvent(@Id val asynchronousMachineDynamicsId: UUID? = null)

// single association events
data class AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsEvent(@Id val asynchronousMachineDynamicsId: UUID, val assignment: AsynchronousMachineDynamics )
data class UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsEvent(@Id val asynchronousMachineDynamicsId: UUID? = null )

// multiple association events


// AsynchronousMachineEquivalentCircuit Events

data class CreateAsynchronousMachineEquivalentCircuitEvent(
     var asynchronousMachineEquivalentCircuitId: UUID? = null
)

data class UpdateAsynchronousMachineEquivalentCircuitEvent(
    @Id var asynchronousMachineEquivalentCircuitId: UUID? = null,
    var rr1: PU,
    var rr2: PU,
    var xlr1: PU,
    var xlr2: PU,
    var xm: PU
)

data class DeleteAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID? = null)

// single association events
data class AssignRr1ToAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignRr1FromAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignRr2ToAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignRr2FromAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignXlr1ToAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignXlr1FromAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignXlr2ToAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignXlr2FromAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignXmToAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignXmFromAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID? = null )

// multiple association events


// AsynchronousMachineTimeConstantReactance Events

data class CreateAsynchronousMachineTimeConstantReactanceEvent(
     var asynchronousMachineTimeConstantReactanceId: UUID? = null
)

data class UpdateAsynchronousMachineTimeConstantReactanceEvent(
    @Id var asynchronousMachineTimeConstantReactanceId: UUID? = null,
    var tpo: Seconds,
    var tppo: Seconds,
    var xp: PU,
    var xpp: PU,
    var xs: PU
)

data class DeleteAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID? = null)

// single association events
data class AssignTpoToAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID, val assignment: Seconds )
data class UnAssignTpoFromAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignTppoToAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID, val assignment: Seconds )
data class UnAssignTppoFromAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXpToAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXpFromAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXppToAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXppFromAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXsToAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXsFromAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID? = null )

// multiple association events


// AsynchronousMachineUserDefined Events

data class CreateAsynchronousMachineUserDefinedEvent(
     var asynchronousMachineUserDefinedId: UUID? = null
)

data class UpdateAsynchronousMachineUserDefinedEvent(
    @Id var asynchronousMachineUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteAsynchronousMachineUserDefinedEvent(@Id val asynchronousMachineUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToAsynchronousMachineUserDefinedEvent(@Id val asynchronousMachineUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromAsynchronousMachineUserDefinedEvent(@Id val asynchronousMachineUserDefinedId: UUID? = null )

// multiple association events


// BaseVoltage Events

data class CreateBaseVoltageEvent(
     var baseVoltageId: UUID? = null
)

data class UpdateBaseVoltageEvent(
    @Id var baseVoltageId: UUID? = null,
    var nominalVoltage: Voltage
)

data class DeleteBaseVoltageEvent(@Id val baseVoltageId: UUID? = null)

// single association events
data class AssignNominalVoltageToBaseVoltageEvent(@Id val baseVoltageId: UUID, val assignment: Voltage )
data class UnAssignNominalVoltageFromBaseVoltageEvent(@Id val baseVoltageId: UUID? = null )

// multiple association events


// BasicIntervalSchedule Events

data class CreateBasicIntervalScheduleEvent(
    @Id var basicIntervalScheduleId: UUID? = null,
    @Enumerated(EnumType.STRING) var value1Unit: UnitSymbol,
    @Enumerated(EnumType.STRING) var value2Unit: UnitSymbol
)

data class UpdateBasicIntervalScheduleEvent(
    @Id var basicIntervalScheduleId: UUID? = null,
    var startTime: DateTime,
    @Enumerated(EnumType.STRING) var value1Unit: UnitSymbol,
    @Enumerated(EnumType.STRING) var value2Unit: UnitSymbol
)

data class DeleteBasicIntervalScheduleEvent(@Id val basicIntervalScheduleId: UUID? = null)

// single association events
data class AssignStartTimeToBasicIntervalScheduleEvent(@Id val basicIntervalScheduleId: UUID, val assignment: DateTime )
data class UnAssignStartTimeFromBasicIntervalScheduleEvent(@Id val basicIntervalScheduleId: UUID? = null )

// multiple association events


// Bay Events

data class CreateBayEvent(
     var bayId: UUID? = null
)

data class UpdateBayEvent(
    @Id var bayId: UUID? = null,
    var bays:  Set<Bay>
)

data class DeleteBayEvent(@Id val bayId: UUID? = null)

// single association events

// multiple association events
data class AssignBaysToBayEvent(@Id val bayId: UUID, val addTo: Bay )
data class RemoveBaysFromBayEvent(@Id val bayId: UUID, val removeFrom: Bay )


// BooleanProxy Events

data class CreateBooleanProxyEvent(
     var booleanProxyId: UUID? = null
)

data class UpdateBooleanProxyEvent(
     var booleanProxyId: UUID? = null
)

data class DeleteBooleanProxyEvent(@Id val booleanProxyId: UUID? = null)

// single association events

// multiple association events


// BoundaryExtensions Events

data class CreateBoundaryExtensionsEvent(
     var boundaryExtensionsId: UUID? = null
)

data class UpdateBoundaryExtensionsEvent(
    @Id var boundaryExtensionsId: UUID? = null,
    var boundaryPoint: BooleanProxy,
    var fromEndIsoCode: StringProxy,
    var fromEndName: StringProxy,
    var fromEndNameTso: StringProxy,
    var toEndIsoCode: StringProxy,
    var toEndName: StringProxy,
    var toEndNameTso: StringProxy
)

data class DeleteBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null)

// single association events
data class AssignBoundaryPointToBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID, val assignment: BooleanProxy )
data class UnAssignBoundaryPointFromBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null )
data class AssignFromEndIsoCodeToBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID, val assignment: StringProxy )
data class UnAssignFromEndIsoCodeFromBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null )
data class AssignFromEndNameToBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID, val assignment: StringProxy )
data class UnAssignFromEndNameFromBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null )
data class AssignFromEndNameTsoToBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID, val assignment: StringProxy )
data class UnAssignFromEndNameTsoFromBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null )
data class AssignToEndIsoCodeToBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID, val assignment: StringProxy )
data class UnAssignToEndIsoCodeFromBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null )
data class AssignToEndNameToBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID, val assignment: StringProxy )
data class UnAssignToEndNameFromBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null )
data class AssignToEndNameTsoToBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID, val assignment: StringProxy )
data class UnAssignToEndNameTsoFromBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null )

// multiple association events


// Breaker Events

data class CreateBreakerEvent(
     var breakerId: UUID? = null
)

data class UpdateBreakerEvent(
     var breakerId: UUID? = null
)

data class DeleteBreakerEvent(@Id val breakerId: UUID? = null)

// single association events

// multiple association events


// BusNameMarker Events

data class CreateBusNameMarkerEvent(
     var busNameMarkerId: UUID? = null
)

data class UpdateBusNameMarkerEvent(
    @Id var busNameMarkerId: UUID? = null,
    var priority: IntegerProxy,
    var busNameMarker:  Set<BusNameMarker>
)

data class DeleteBusNameMarkerEvent(@Id val busNameMarkerId: UUID? = null)

// single association events
data class AssignPriorityToBusNameMarkerEvent(@Id val busNameMarkerId: UUID, val assignment: IntegerProxy )
data class UnAssignPriorityFromBusNameMarkerEvent(@Id val busNameMarkerId: UUID? = null )

// multiple association events
data class AssignBusNameMarkerToBusNameMarkerEvent(@Id val busNameMarkerId: UUID, val addTo: BusNameMarker )
data class RemoveBusNameMarkerFromBusNameMarkerEvent(@Id val busNameMarkerId: UUID, val removeFrom: BusNameMarker )


// BusbarSection Events

data class CreateBusbarSectionEvent(
     var busbarSectionId: UUID? = null
)

data class UpdateBusbarSectionEvent(
    @Id var busbarSectionId: UUID? = null,
    var ipMax: CurrentFlow
)

data class DeleteBusbarSectionEvent(@Id val busbarSectionId: UUID? = null)

// single association events
data class AssignIpMaxToBusbarSectionEvent(@Id val busbarSectionId: UUID, val assignment: CurrentFlow )
data class UnAssignIpMaxFromBusbarSectionEvent(@Id val busbarSectionId: UUID? = null )

// multiple association events


// Capacitance Events

data class CreateCapacitanceEvent(
    @Id var capacitanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateCapacitanceEvent(
    @Id var capacitanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteCapacitanceEvent(@Id val capacitanceId: UUID? = null)

// single association events
data class AssignValueToCapacitanceEvent(@Id val capacitanceId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromCapacitanceEvent(@Id val capacitanceId: UUID? = null )

// multiple association events


// CapacitancePerLength Events

data class CreateCapacitancePerLengthEvent(
    @Id var capacitancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateCapacitancePerLengthEvent(
    @Id var capacitancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteCapacitancePerLengthEvent(@Id val capacitancePerLengthId: UUID? = null)

// single association events
data class AssignValueToCapacitancePerLengthEvent(@Id val capacitancePerLengthId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromCapacitancePerLengthEvent(@Id val capacitancePerLengthId: UUID? = null )

// multiple association events


// Command Events

data class CreateCommandEvent(
     var commandId: UUID? = null
)

data class UpdateCommandEvent(
    @Id var commandId: UUID? = null,
    var normalValue: IntegerProxy,
    var value: IntegerProxy,
    var commands:  Set<Command>,
    var command: Command
)

data class DeleteCommandEvent(@Id val commandId: UUID? = null)

// single association events
data class AssignNormalValueToCommandEvent(@Id val commandId: UUID, val assignment: IntegerProxy )
data class UnAssignNormalValueFromCommandEvent(@Id val commandId: UUID? = null )
data class AssignValueToCommandEvent(@Id val commandId: UUID, val assignment: IntegerProxy )
data class UnAssignValueFromCommandEvent(@Id val commandId: UUID? = null )
data class AssignCommandToCommandEvent(@Id val commandId: UUID, val assignment: Command )
data class UnAssignCommandFromCommandEvent(@Id val commandId: UUID? = null )

// multiple association events
data class AssignCommandsToCommandEvent(@Id val commandId: UUID, val addTo: Command )
data class RemoveCommandsFromCommandEvent(@Id val commandId: UUID, val removeFrom: Command )


// Conductance Events

data class CreateConductanceEvent(
    @Id var conductanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateConductanceEvent(
    @Id var conductanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteConductanceEvent(@Id val conductanceId: UUID? = null)

// single association events
data class AssignValueToConductanceEvent(@Id val conductanceId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromConductanceEvent(@Id val conductanceId: UUID? = null )

// multiple association events


// ConductingEquipment Events

data class CreateConductingEquipmentEvent(
     var conductingEquipmentId: UUID? = null
)

data class UpdateConductingEquipmentEvent(
     var conductingEquipmentId: UUID? = null
)

data class DeleteConductingEquipmentEvent(@Id val conductingEquipmentId: UUID? = null)

// single association events

// multiple association events


// Conductor Events

data class CreateConductorEvent(
     var conductorId: UUID? = null
)

data class UpdateConductorEvent(
    @Id var conductorId: UUID? = null,
    var length: Length
)

data class DeleteConductorEvent(@Id val conductorId: UUID? = null)

// single association events
data class AssignLengthToConductorEvent(@Id val conductorId: UUID, val assignment: Length )
data class UnAssignLengthFromConductorEvent(@Id val conductorId: UUID? = null )

// multiple association events


// ConformLoad Events

data class CreateConformLoadEvent(
     var conformLoadId: UUID? = null
)

data class UpdateConformLoadEvent(
    @Id var conformLoadId: UUID? = null,
    var energyConsumers:  Set<ConformLoad>
)

data class DeleteConformLoadEvent(@Id val conformLoadId: UUID? = null)

// single association events

// multiple association events
data class AssignEnergyConsumersToConformLoadEvent(@Id val conformLoadId: UUID, val addTo: ConformLoad )
data class RemoveEnergyConsumersFromConformLoadEvent(@Id val conformLoadId: UUID, val removeFrom: ConformLoad )


// ConformLoadGroup Events

data class CreateConformLoadGroupEvent(
     var conformLoadGroupId: UUID? = null
)

data class UpdateConformLoadGroupEvent(
     var conformLoadGroupId: UUID? = null
)

data class DeleteConformLoadGroupEvent(@Id val conformLoadGroupId: UUID? = null)

// single association events

// multiple association events


// ConformLoadSchedule Events

data class CreateConformLoadScheduleEvent(
     var conformLoadScheduleId: UUID? = null
)

data class UpdateConformLoadScheduleEvent(
    @Id var conformLoadScheduleId: UUID? = null,
    var conformLoadSchedules:  Set<ConformLoadSchedule>
)

data class DeleteConformLoadScheduleEvent(@Id val conformLoadScheduleId: UUID? = null)

// single association events

// multiple association events
data class AssignConformLoadSchedulesToConformLoadScheduleEvent(@Id val conformLoadScheduleId: UUID, val addTo: ConformLoadSchedule )
data class RemoveConformLoadSchedulesFromConformLoadScheduleEvent(@Id val conformLoadScheduleId: UUID, val removeFrom: ConformLoadSchedule )


// ConnectivityNode Events

data class CreateConnectivityNodeEvent(
     var connectivityNodeId: UUID? = null
)

data class UpdateConnectivityNodeEvent(
    @Id var connectivityNodeId: UUID? = null,
    var boundaryPoint: BooleanProxy,
    var fromEndIsoCode: StringProxy,
    var fromEndName: StringProxy,
    var fromEndNameTso: StringProxy,
    var toEndIsoCode: StringProxy,
    var toEndName: StringProxy,
    var toEndNameTso: StringProxy,
    var connectivityNodes:  Set<ConnectivityNode>
)

data class DeleteConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null)

// single association events
data class AssignBoundaryPointToConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val assignment: BooleanProxy )
data class UnAssignBoundaryPointFromConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null )
data class AssignFromEndIsoCodeToConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val assignment: StringProxy )
data class UnAssignFromEndIsoCodeFromConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null )
data class AssignFromEndNameToConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val assignment: StringProxy )
data class UnAssignFromEndNameFromConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null )
data class AssignFromEndNameTsoToConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val assignment: StringProxy )
data class UnAssignFromEndNameTsoFromConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null )
data class AssignToEndIsoCodeToConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val assignment: StringProxy )
data class UnAssignToEndIsoCodeFromConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null )
data class AssignToEndNameToConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val assignment: StringProxy )
data class UnAssignToEndNameFromConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null )
data class AssignToEndNameTsoToConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val assignment: StringProxy )
data class UnAssignToEndNameTsoFromConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null )

// multiple association events
data class AssignConnectivityNodesToConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val addTo: ConnectivityNode )
data class RemoveConnectivityNodesFromConnectivityNodeEvent(@Id val connectivityNodeId: UUID, val removeFrom: ConnectivityNode )


// ConnectivityNodeContainer Events

data class CreateConnectivityNodeContainerEvent(
     var connectivityNodeContainerId: UUID? = null
)

data class UpdateConnectivityNodeContainerEvent(
     var connectivityNodeContainerId: UUID? = null
)

data class DeleteConnectivityNodeContainerEvent(@Id val connectivityNodeContainerId: UUID? = null)

// single association events

// multiple association events


// Connector Events

data class CreateConnectorEvent(
     var connectorId: UUID? = null
)

data class UpdateConnectorEvent(
     var connectorId: UUID? = null
)

data class DeleteConnectorEvent(@Id val connectorId: UUID? = null)

// single association events

// multiple association events


// Control Events

data class CreateControlEvent(
    @Id var controlId: UUID? = null,
    @Enumerated(EnumType.STRING) var unitMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unitSymbol: UnitSymbol
)

data class UpdateControlEvent(
    @Id var controlId: UUID? = null,
    var controlType: StringProxy,
    var operationInProgress: BooleanProxy,
    var timeStamp: DateTime,
    @Enumerated(EnumType.STRING) var unitMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unitSymbol: UnitSymbol,
    var controls:  Set<Control>
)

data class DeleteControlEvent(@Id val controlId: UUID? = null)

// single association events
data class AssignControlTypeToControlEvent(@Id val controlId: UUID, val assignment: StringProxy )
data class UnAssignControlTypeFromControlEvent(@Id val controlId: UUID? = null )
data class AssignOperationInProgressToControlEvent(@Id val controlId: UUID, val assignment: BooleanProxy )
data class UnAssignOperationInProgressFromControlEvent(@Id val controlId: UUID? = null )
data class AssignTimeStampToControlEvent(@Id val controlId: UUID, val assignment: DateTime )
data class UnAssignTimeStampFromControlEvent(@Id val controlId: UUID? = null )

// multiple association events
data class AssignControlsToControlEvent(@Id val controlId: UUID, val addTo: Control )
data class RemoveControlsFromControlEvent(@Id val controlId: UUID, val removeFrom: Control )


// ControlArea Events

data class CreateControlAreaEvent(
    @Id var controlAreaId: UUID? = null,
    @Enumerated(EnumType.STRING) var type: ControlAreaTypeKind
)

data class UpdateControlAreaEvent(
    @Id var controlAreaId: UUID? = null,
    @Enumerated(EnumType.STRING) var type: ControlAreaTypeKind,
    var controlArea: ControlArea
)

data class DeleteControlAreaEvent(@Id val controlAreaId: UUID? = null)

// single association events
data class AssignControlAreaToControlAreaEvent(@Id val controlAreaId: UUID, val assignment: ControlArea )
data class UnAssignControlAreaFromControlAreaEvent(@Id val controlAreaId: UUID? = null )

// multiple association events


// ControlAreaGeneratingUnit Events

data class CreateControlAreaGeneratingUnitEvent(
     var controlAreaGeneratingUnitId: UUID? = null
)

data class UpdateControlAreaGeneratingUnitEvent(
    @Id var controlAreaGeneratingUnitId: UUID? = null,
    var controlAreaGeneratingUnit:  Set<ControlAreaGeneratingUnit>
)

data class DeleteControlAreaGeneratingUnitEvent(@Id val controlAreaGeneratingUnitId: UUID? = null)

// single association events

// multiple association events
data class AssignControlAreaGeneratingUnitToControlAreaGeneratingUnitEvent(@Id val controlAreaGeneratingUnitId: UUID, val addTo: ControlAreaGeneratingUnit )
data class RemoveControlAreaGeneratingUnitFromControlAreaGeneratingUnitEvent(@Id val controlAreaGeneratingUnitId: UUID, val removeFrom: ControlAreaGeneratingUnit )


// CoordinateSystem Events

data class CreateCoordinateSystemEvent(
     var coordinateSystemId: UUID? = null
)

data class UpdateCoordinateSystemEvent(
    @Id var coordinateSystemId: UUID? = null,
    var crsUrn: StringProxy
)

data class DeleteCoordinateSystemEvent(@Id val coordinateSystemId: UUID? = null)

// single association events
data class AssignCrsUrnToCoordinateSystemEvent(@Id val coordinateSystemId: UUID, val assignment: StringProxy )
data class UnAssignCrsUrnFromCoordinateSystemEvent(@Id val coordinateSystemId: UUID? = null )

// multiple association events


// CsConverter Events

data class CreateCsConverterEvent(
     var csConverterId: UUID? = null
)

data class UpdateCsConverterEvent(
    @Id var csConverterId: UUID? = null,
    var maxAlpha: AngleDegrees,
    var maxGamma: AngleDegrees,
    var maxIdc: CurrentFlow,
    var minAlpha: AngleDegrees,
    var minGamma: AngleDegrees,
    var minIdc: CurrentFlow,
    var ratedIdc: CurrentFlow
)

data class DeleteCsConverterEvent(@Id val csConverterId: UUID? = null)

// single association events
data class AssignMaxAlphaToCsConverterEvent(@Id val csConverterId: UUID, val assignment: AngleDegrees )
data class UnAssignMaxAlphaFromCsConverterEvent(@Id val csConverterId: UUID? = null )
data class AssignMaxGammaToCsConverterEvent(@Id val csConverterId: UUID, val assignment: AngleDegrees )
data class UnAssignMaxGammaFromCsConverterEvent(@Id val csConverterId: UUID? = null )
data class AssignMaxIdcToCsConverterEvent(@Id val csConverterId: UUID, val assignment: CurrentFlow )
data class UnAssignMaxIdcFromCsConverterEvent(@Id val csConverterId: UUID? = null )
data class AssignMinAlphaToCsConverterEvent(@Id val csConverterId: UUID, val assignment: AngleDegrees )
data class UnAssignMinAlphaFromCsConverterEvent(@Id val csConverterId: UUID? = null )
data class AssignMinGammaToCsConverterEvent(@Id val csConverterId: UUID, val assignment: AngleDegrees )
data class UnAssignMinGammaFromCsConverterEvent(@Id val csConverterId: UUID? = null )
data class AssignMinIdcToCsConverterEvent(@Id val csConverterId: UUID, val assignment: CurrentFlow )
data class UnAssignMinIdcFromCsConverterEvent(@Id val csConverterId: UUID? = null )
data class AssignRatedIdcToCsConverterEvent(@Id val csConverterId: UUID, val assignment: CurrentFlow )
data class UnAssignRatedIdcFromCsConverterEvent(@Id val csConverterId: UUID? = null )

// multiple association events


// CurrentFlow Events

data class CreateCurrentFlowEvent(
    @Id var currentFlowId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateCurrentFlowEvent(
    @Id var currentFlowId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteCurrentFlowEvent(@Id val currentFlowId: UUID? = null)

// single association events
data class AssignValueToCurrentFlowEvent(@Id val currentFlowId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromCurrentFlowEvent(@Id val currentFlowId: UUID? = null )

// multiple association events


// CurrentLimit Events

data class CreateCurrentLimitEvent(
     var currentLimitId: UUID? = null
)

data class UpdateCurrentLimitEvent(
    @Id var currentLimitId: UUID? = null,
    var value: CurrentFlow
)

data class DeleteCurrentLimitEvent(@Id val currentLimitId: UUID? = null)

// single association events
data class AssignValueToCurrentLimitEvent(@Id val currentLimitId: UUID, val assignment: CurrentFlow )
data class UnAssignValueFromCurrentLimitEvent(@Id val currentLimitId: UUID? = null )

// multiple association events


// Curve Events

data class CreateCurveEvent(
    @Id var curveId: UUID? = null,
    @Enumerated(EnumType.STRING) var curveStyle: CurveStyle,
    @Enumerated(EnumType.STRING) var xUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var y1Unit: UnitSymbol,
    @Enumerated(EnumType.STRING) var y2Unit: UnitSymbol
)

data class UpdateCurveEvent(
    @Id var curveId: UUID? = null,
    @Enumerated(EnumType.STRING) var curveStyle: CurveStyle,
    @Enumerated(EnumType.STRING) var xUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var y1Unit: UnitSymbol,
    @Enumerated(EnumType.STRING) var y2Unit: UnitSymbol
)

data class DeleteCurveEvent(@Id val curveId: UUID? = null)

// single association events

// multiple association events


// CurveData Events

data class CreateCurveDataEvent(
     var curveDataId: UUID? = null
)

data class UpdateCurveDataEvent(
    @Id var curveDataId: UUID? = null,
    var xvalue: Simple_Float,
    var y1value: Simple_Float,
    var y2value: Simple_Float,
    var curveDatas:  Set<CurveData>
)

data class DeleteCurveDataEvent(@Id val curveDataId: UUID? = null)

// single association events
data class AssignXvalueToCurveDataEvent(@Id val curveDataId: UUID, val assignment: Simple_Float )
data class UnAssignXvalueFromCurveDataEvent(@Id val curveDataId: UUID? = null )
data class AssignY1valueToCurveDataEvent(@Id val curveDataId: UUID, val assignment: Simple_Float )
data class UnAssignY1valueFromCurveDataEvent(@Id val curveDataId: UUID? = null )
data class AssignY2valueToCurveDataEvent(@Id val curveDataId: UUID, val assignment: Simple_Float )
data class UnAssignY2valueFromCurveDataEvent(@Id val curveDataId: UUID? = null )

// multiple association events
data class AssignCurveDatasToCurveDataEvent(@Id val curveDataId: UUID, val addTo: CurveData )
data class RemoveCurveDatasFromCurveDataEvent(@Id val curveDataId: UUID, val removeFrom: CurveData )


// DCBaseTerminal Events

data class CreateDCBaseTerminalEvent(
     var dCBaseTerminalId: UUID? = null
)

data class UpdateDCBaseTerminalEvent(
    @Id var dCBaseTerminalId: UUID? = null,
    var dCTerminals:  Set<DCBaseTerminal>
)

data class DeleteDCBaseTerminalEvent(@Id val dCBaseTerminalId: UUID? = null)

// single association events

// multiple association events
data class AssignDCTerminalsToDCBaseTerminalEvent(@Id val dCBaseTerminalId: UUID, val addTo: DCBaseTerminal )
data class RemoveDCTerminalsFromDCBaseTerminalEvent(@Id val dCBaseTerminalId: UUID, val removeFrom: DCBaseTerminal )


// DCBreaker Events

data class CreateDCBreakerEvent(
     var dCBreakerId: UUID? = null
)

data class UpdateDCBreakerEvent(
     var dCBreakerId: UUID? = null
)

data class DeleteDCBreakerEvent(@Id val dCBreakerId: UUID? = null)

// single association events

// multiple association events


// DCBusbar Events

data class CreateDCBusbarEvent(
     var dCBusbarId: UUID? = null
)

data class UpdateDCBusbarEvent(
     var dCBusbarId: UUID? = null
)

data class DeleteDCBusbarEvent(@Id val dCBusbarId: UUID? = null)

// single association events

// multiple association events


// DCChopper Events

data class CreateDCChopperEvent(
     var dCChopperId: UUID? = null
)

data class UpdateDCChopperEvent(
     var dCChopperId: UUID? = null
)

data class DeleteDCChopperEvent(@Id val dCChopperId: UUID? = null)

// single association events

// multiple association events


// DCConductingEquipment Events

data class CreateDCConductingEquipmentEvent(
     var dCConductingEquipmentId: UUID? = null
)

data class UpdateDCConductingEquipmentEvent(
     var dCConductingEquipmentId: UUID? = null
)

data class DeleteDCConductingEquipmentEvent(@Id val dCConductingEquipmentId: UUID? = null)

// single association events

// multiple association events


// DCConverterUnit Events

data class CreateDCConverterUnitEvent(
    @Id var dCConverterUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var operationMode: DCConverterOperatingModeKind
)

data class UpdateDCConverterUnitEvent(
    @Id var dCConverterUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var operationMode: DCConverterOperatingModeKind,
    var dCConverterUnit:  Set<DCConverterUnit>
)

data class DeleteDCConverterUnitEvent(@Id val dCConverterUnitId: UUID? = null)

// single association events

// multiple association events
data class AssignDCConverterUnitToDCConverterUnitEvent(@Id val dCConverterUnitId: UUID, val addTo: DCConverterUnit )
data class RemoveDCConverterUnitFromDCConverterUnitEvent(@Id val dCConverterUnitId: UUID, val removeFrom: DCConverterUnit )


// DCDisconnector Events

data class CreateDCDisconnectorEvent(
     var dCDisconnectorId: UUID? = null
)

data class UpdateDCDisconnectorEvent(
     var dCDisconnectorId: UUID? = null
)

data class DeleteDCDisconnectorEvent(@Id val dCDisconnectorId: UUID? = null)

// single association events

// multiple association events


// DCEquipmentContainer Events

data class CreateDCEquipmentContainerEvent(
     var dCEquipmentContainerId: UUID? = null
)

data class UpdateDCEquipmentContainerEvent(
     var dCEquipmentContainerId: UUID? = null
)

data class DeleteDCEquipmentContainerEvent(@Id val dCEquipmentContainerId: UUID? = null)

// single association events

// multiple association events


// DCGround Events

data class CreateDCGroundEvent(
     var dCGroundId: UUID? = null
)

data class UpdateDCGroundEvent(
    @Id var dCGroundId: UUID? = null,
    var inductance: Inductance,
    var r: Resistance
)

data class DeleteDCGroundEvent(@Id val dCGroundId: UUID? = null)

// single association events
data class AssignInductanceToDCGroundEvent(@Id val dCGroundId: UUID, val assignment: Inductance )
data class UnAssignInductanceFromDCGroundEvent(@Id val dCGroundId: UUID? = null )
data class AssignRToDCGroundEvent(@Id val dCGroundId: UUID, val assignment: Resistance )
data class UnAssignRFromDCGroundEvent(@Id val dCGroundId: UUID? = null )

// multiple association events


// DCLine Events

data class CreateDCLineEvent(
     var dCLineId: UUID? = null
)

data class UpdateDCLineEvent(
    @Id var dCLineId: UUID? = null,
    var dCLines:  Set<DCLine>
)

data class DeleteDCLineEvent(@Id val dCLineId: UUID? = null)

// single association events

// multiple association events
data class AssignDCLinesToDCLineEvent(@Id val dCLineId: UUID, val addTo: DCLine )
data class RemoveDCLinesFromDCLineEvent(@Id val dCLineId: UUID, val removeFrom: DCLine )


// DCLineSegment Events

data class CreateDCLineSegmentEvent(
     var dCLineSegmentId: UUID? = null
)

data class UpdateDCLineSegmentEvent(
    @Id var dCLineSegmentId: UUID? = null,
    var capacitance: Capacitance,
    var inductance: Inductance,
    var length: Length,
    var resistance: Resistance,
    var dCLineSegments:  Set<DCLineSegment>
)

data class DeleteDCLineSegmentEvent(@Id val dCLineSegmentId: UUID? = null)

// single association events
data class AssignCapacitanceToDCLineSegmentEvent(@Id val dCLineSegmentId: UUID, val assignment: Capacitance )
data class UnAssignCapacitanceFromDCLineSegmentEvent(@Id val dCLineSegmentId: UUID? = null )
data class AssignInductanceToDCLineSegmentEvent(@Id val dCLineSegmentId: UUID, val assignment: Inductance )
data class UnAssignInductanceFromDCLineSegmentEvent(@Id val dCLineSegmentId: UUID? = null )
data class AssignLengthToDCLineSegmentEvent(@Id val dCLineSegmentId: UUID, val assignment: Length )
data class UnAssignLengthFromDCLineSegmentEvent(@Id val dCLineSegmentId: UUID? = null )
data class AssignResistanceToDCLineSegmentEvent(@Id val dCLineSegmentId: UUID, val assignment: Resistance )
data class UnAssignResistanceFromDCLineSegmentEvent(@Id val dCLineSegmentId: UUID? = null )

// multiple association events
data class AssignDCLineSegmentsToDCLineSegmentEvent(@Id val dCLineSegmentId: UUID, val addTo: DCLineSegment )
data class RemoveDCLineSegmentsFromDCLineSegmentEvent(@Id val dCLineSegmentId: UUID, val removeFrom: DCLineSegment )


// DCNode Events

data class CreateDCNodeEvent(
     var dCNodeId: UUID? = null
)

data class UpdateDCNodeEvent(
    @Id var dCNodeId: UUID? = null,
    var dCNodes:  Set<DCNode>
)

data class DeleteDCNodeEvent(@Id val dCNodeId: UUID? = null)

// single association events

// multiple association events
data class AssignDCNodesToDCNodeEvent(@Id val dCNodeId: UUID, val addTo: DCNode )
data class RemoveDCNodesFromDCNodeEvent(@Id val dCNodeId: UUID, val removeFrom: DCNode )


// DCSeriesDevice Events

data class CreateDCSeriesDeviceEvent(
     var dCSeriesDeviceId: UUID? = null
)

data class UpdateDCSeriesDeviceEvent(
    @Id var dCSeriesDeviceId: UUID? = null,
    var inductance: Inductance,
    var ratedUdc: Voltage,
    var resistance: Resistance
)

data class DeleteDCSeriesDeviceEvent(@Id val dCSeriesDeviceId: UUID? = null)

// single association events
data class AssignInductanceToDCSeriesDeviceEvent(@Id val dCSeriesDeviceId: UUID, val assignment: Inductance )
data class UnAssignInductanceFromDCSeriesDeviceEvent(@Id val dCSeriesDeviceId: UUID? = null )
data class AssignRatedUdcToDCSeriesDeviceEvent(@Id val dCSeriesDeviceId: UUID, val assignment: Voltage )
data class UnAssignRatedUdcFromDCSeriesDeviceEvent(@Id val dCSeriesDeviceId: UUID? = null )
data class AssignResistanceToDCSeriesDeviceEvent(@Id val dCSeriesDeviceId: UUID, val assignment: Resistance )
data class UnAssignResistanceFromDCSeriesDeviceEvent(@Id val dCSeriesDeviceId: UUID? = null )

// multiple association events


// DCShunt Events

data class CreateDCShuntEvent(
     var dCShuntId: UUID? = null
)

data class UpdateDCShuntEvent(
    @Id var dCShuntId: UUID? = null,
    var capacitance: Capacitance,
    var ratedUdc: Voltage,
    var resistance: Resistance
)

data class DeleteDCShuntEvent(@Id val dCShuntId: UUID? = null)

// single association events
data class AssignCapacitanceToDCShuntEvent(@Id val dCShuntId: UUID, val assignment: Capacitance )
data class UnAssignCapacitanceFromDCShuntEvent(@Id val dCShuntId: UUID? = null )
data class AssignRatedUdcToDCShuntEvent(@Id val dCShuntId: UUID, val assignment: Voltage )
data class UnAssignRatedUdcFromDCShuntEvent(@Id val dCShuntId: UUID? = null )
data class AssignResistanceToDCShuntEvent(@Id val dCShuntId: UUID, val assignment: Resistance )
data class UnAssignResistanceFromDCShuntEvent(@Id val dCShuntId: UUID? = null )

// multiple association events


// DCSwitch Events

data class CreateDCSwitchEvent(
     var dCSwitchId: UUID? = null
)

data class UpdateDCSwitchEvent(
     var dCSwitchId: UUID? = null
)

data class DeleteDCSwitchEvent(@Id val dCSwitchId: UUID? = null)

// single association events

// multiple association events


// DCTerminal Events

data class CreateDCTerminalEvent(
     var dCTerminalId: UUID? = null
)

data class UpdateDCTerminalEvent(
    @Id var dCTerminalId: UUID? = null,
    var dCTerminals:  Set<DCTerminal>
)

data class DeleteDCTerminalEvent(@Id val dCTerminalId: UUID? = null)

// single association events

// multiple association events
data class AssignDCTerminalsToDCTerminalEvent(@Id val dCTerminalId: UUID, val addTo: DCTerminal )
data class RemoveDCTerminalsFromDCTerminalEvent(@Id val dCTerminalId: UUID, val removeFrom: DCTerminal )


// DCTopologicalIsland Events

data class CreateDCTopologicalIslandEvent(
     var dCTopologicalIslandId: UUID? = null
)

data class UpdateDCTopologicalIslandEvent(
    @Id var dCTopologicalIslandId: UUID? = null,
    var dCTopologicalIsland: DCTopologicalIsland
)

data class DeleteDCTopologicalIslandEvent(@Id val dCTopologicalIslandId: UUID? = null)

// single association events
data class AssignDCTopologicalIslandToDCTopologicalIslandEvent(@Id val dCTopologicalIslandId: UUID, val assignment: DCTopologicalIsland )
data class UnAssignDCTopologicalIslandFromDCTopologicalIslandEvent(@Id val dCTopologicalIslandId: UUID? = null )

// multiple association events


// DCTopologicalNode Events

data class CreateDCTopologicalNodeEvent(
     var dCTopologicalNodeId: UUID? = null
)

data class UpdateDCTopologicalNodeEvent(
    @Id var dCTopologicalNodeId: UUID? = null,
    var dCTopologicalNode:  Set<DCTopologicalNode>
)

data class DeleteDCTopologicalNodeEvent(@Id val dCTopologicalNodeId: UUID? = null)

// single association events

// multiple association events
data class AssignDCTopologicalNodeToDCTopologicalNodeEvent(@Id val dCTopologicalNodeId: UUID, val addTo: DCTopologicalNode )
data class RemoveDCTopologicalNodeFromDCTopologicalNodeEvent(@Id val dCTopologicalNodeId: UUID, val removeFrom: DCTopologicalNode )


// DateProxy Events

data class CreateDateProxyEvent(
     var dateProxyId: UUID? = null
)

data class UpdateDateProxyEvent(
     var dateProxyId: UUID? = null
)

data class DeleteDateProxyEvent(@Id val dateProxyId: UUID? = null)

// single association events

// multiple association events


// DateTime Events

data class CreateDateTimeEvent(
     var dateTimeId: UUID? = null
)

data class UpdateDateTimeEvent(
     var dateTimeId: UUID? = null
)

data class DeleteDateTimeEvent(@Id val dateTimeId: UUID? = null)

// single association events

// multiple association events


// DayType Events

data class CreateDayTypeEvent(
     var dayTypeId: UUID? = null
)

data class UpdateDayTypeEvent(
     var dayTypeId: UUID? = null
)

data class DeleteDayTypeEvent(@Id val dayTypeId: UUID? = null)

// single association events

// multiple association events


// DecimalProxy Events

data class CreateDecimalProxyEvent(
     var decimalProxyId: UUID? = null
)

data class UpdateDecimalProxyEvent(
     var decimalProxyId: UUID? = null
)

data class DeleteDecimalProxyEvent(@Id val decimalProxyId: UUID? = null)

// single association events

// multiple association events


// Diagram Events

data class CreateDiagramEvent(
    @Id var diagramId: UUID? = null,
    @Enumerated(EnumType.STRING) var orientation: OrientationKind
)

data class UpdateDiagramEvent(
    @Id var diagramId: UUID? = null,
    @Enumerated(EnumType.STRING) var orientation: OrientationKind,
    var x1InitialView: Simple_Float,
    var x2InitialView: Simple_Float,
    var y1InitialView: Simple_Float,
    var y2InitialView: Simple_Float,
    var diagram:  Set<Diagram>
)

data class DeleteDiagramEvent(@Id val diagramId: UUID? = null)

// single association events
data class AssignX1InitialViewToDiagramEvent(@Id val diagramId: UUID, val assignment: Simple_Float )
data class UnAssignX1InitialViewFromDiagramEvent(@Id val diagramId: UUID? = null )
data class AssignX2InitialViewToDiagramEvent(@Id val diagramId: UUID, val assignment: Simple_Float )
data class UnAssignX2InitialViewFromDiagramEvent(@Id val diagramId: UUID? = null )
data class AssignY1InitialViewToDiagramEvent(@Id val diagramId: UUID, val assignment: Simple_Float )
data class UnAssignY1InitialViewFromDiagramEvent(@Id val diagramId: UUID? = null )
data class AssignY2InitialViewToDiagramEvent(@Id val diagramId: UUID, val assignment: Simple_Float )
data class UnAssignY2InitialViewFromDiagramEvent(@Id val diagramId: UUID? = null )

// multiple association events
data class AssignDiagramToDiagramEvent(@Id val diagramId: UUID, val addTo: Diagram )
data class RemoveDiagramFromDiagramEvent(@Id val diagramId: UUID, val removeFrom: Diagram )


// DiagramLayoutVersion Events

data class CreateDiagramLayoutVersionEvent(
     var diagramLayoutVersionId: UUID? = null
)

data class UpdateDiagramLayoutVersionEvent(
    @Id var diagramLayoutVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURI: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURI: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignBaseURIToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignDateToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignDifferenceModelURIToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignEntsoeUMLToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignEntsoeURIToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignModelDescriptionURIToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignNamespaceRDFToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignNamespaceUMLToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )
data class AssignShortNameToDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null )

// multiple association events


// DiagramObject Events

data class CreateDiagramObjectEvent(
     var diagramObjectId: UUID? = null
)

data class UpdateDiagramObjectEvent(
    @Id var diagramObjectId: UUID? = null,
    var drawingOrder: IntegerProxy,
    var polygonFlag: BooleanProxy,
    var offsetX: Simple_Float,
    var offsetY: Simple_Float,
    var rotation: AngleDegrees,
    var styledObjects:  Set<DiagramObject>,
    var diagramElements:  Set<DiagramObject>,
    var diagramObjects:  Set<DiagramObject>
)

data class DeleteDiagramObjectEvent(@Id val diagramObjectId: UUID? = null)

// single association events
data class AssignDrawingOrderToDiagramObjectEvent(@Id val diagramObjectId: UUID, val assignment: IntegerProxy )
data class UnAssignDrawingOrderFromDiagramObjectEvent(@Id val diagramObjectId: UUID? = null )
data class AssignPolygonFlagToDiagramObjectEvent(@Id val diagramObjectId: UUID, val assignment: BooleanProxy )
data class UnAssignPolygonFlagFromDiagramObjectEvent(@Id val diagramObjectId: UUID? = null )
data class AssignOffsetXToDiagramObjectEvent(@Id val diagramObjectId: UUID, val assignment: Simple_Float )
data class UnAssignOffsetXFromDiagramObjectEvent(@Id val diagramObjectId: UUID? = null )
data class AssignOffsetYToDiagramObjectEvent(@Id val diagramObjectId: UUID, val assignment: Simple_Float )
data class UnAssignOffsetYFromDiagramObjectEvent(@Id val diagramObjectId: UUID? = null )
data class AssignRotationToDiagramObjectEvent(@Id val diagramObjectId: UUID, val assignment: AngleDegrees )
data class UnAssignRotationFromDiagramObjectEvent(@Id val diagramObjectId: UUID? = null )

// multiple association events
data class AssignStyledObjectsToDiagramObjectEvent(@Id val diagramObjectId: UUID, val addTo: DiagramObject )
data class RemoveStyledObjectsFromDiagramObjectEvent(@Id val diagramObjectId: UUID, val removeFrom: DiagramObject )
data class AssignDiagramElementsToDiagramObjectEvent(@Id val diagramObjectId: UUID, val addTo: DiagramObject )
data class RemoveDiagramElementsFromDiagramObjectEvent(@Id val diagramObjectId: UUID, val removeFrom: DiagramObject )
data class AssignDiagramObjectsToDiagramObjectEvent(@Id val diagramObjectId: UUID, val addTo: DiagramObject )
data class RemoveDiagramObjectsFromDiagramObjectEvent(@Id val diagramObjectId: UUID, val removeFrom: DiagramObject )


// DiagramObjectGluePoint Events

data class CreateDiagramObjectGluePointEvent(
     var diagramObjectGluePointId: UUID? = null
)

data class UpdateDiagramObjectGluePointEvent(
     var diagramObjectGluePointId: UUID? = null
)

data class DeleteDiagramObjectGluePointEvent(@Id val diagramObjectGluePointId: UUID? = null)

// single association events

// multiple association events


// DiagramObjectPoint Events

data class CreateDiagramObjectPointEvent(
     var diagramObjectPointId: UUID? = null
)

data class UpdateDiagramObjectPointEvent(
    @Id var diagramObjectPointId: UUID? = null,
    var sequenceNumber: IntegerProxy,
    var xPosition: Simple_Float,
    var yPosition: Simple_Float,
    var zPosition: Simple_Float,
    var diagramObjectPoints:  Set<DiagramObjectPoint>
)

data class DeleteDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID? = null)

// single association events
data class AssignSequenceNumberToDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID, val assignment: IntegerProxy )
data class UnAssignSequenceNumberFromDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID? = null )
data class AssignXPositionToDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID, val assignment: Simple_Float )
data class UnAssignXPositionFromDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID? = null )
data class AssignYPositionToDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID, val assignment: Simple_Float )
data class UnAssignYPositionFromDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID? = null )
data class AssignZPositionToDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID, val assignment: Simple_Float )
data class UnAssignZPositionFromDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID? = null )

// multiple association events
data class AssignDiagramObjectPointsToDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID, val addTo: DiagramObjectPoint )
data class RemoveDiagramObjectPointsFromDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID, val removeFrom: DiagramObjectPoint )


// DiagramObjectStyle Events

data class CreateDiagramObjectStyleEvent(
     var diagramObjectStyleId: UUID? = null
)

data class UpdateDiagramObjectStyleEvent(
     var diagramObjectStyleId: UUID? = null
)

data class DeleteDiagramObjectStyleEvent(@Id val diagramObjectStyleId: UUID? = null)

// single association events

// multiple association events


// DiagramStyle Events

data class CreateDiagramStyleEvent(
     var diagramStyleId: UUID? = null
)

data class UpdateDiagramStyleEvent(
     var diagramStyleId: UUID? = null
)

data class DeleteDiagramStyleEvent(@Id val diagramStyleId: UUID? = null)

// single association events

// multiple association events


// DiscExcContIEEEDEC1A Events

data class CreateDiscExcContIEEEDEC1AEvent(
     var discExcContIEEEDEC1AId: UUID? = null
)

data class UpdateDiscExcContIEEEDEC1AEvent(
    @Id var discExcContIEEEDEC1AId: UUID? = null,
    var esc: PU,
    var kan: PU,
    var ketl: PU,
    var tan: Seconds,
    var td: Seconds,
    var tl1: Seconds,
    var tl2: Seconds,
    var tw5: Seconds,
    var value: PU,
    var vanmax: PU,
    var vomax: PU,
    var vomin: PU,
    var vsmax: PU,
    var vsmin: PU,
    var vtc: PU,
    var vtlmt: PU,
    var vtm: PU,
    var vtn: PU
)

data class DeleteDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null)

// single association events
data class AssignEscToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignEscFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignKanToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignKanFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignKetlToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignKetlFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignTanToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: Seconds )
data class UnAssignTanFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignTdToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: Seconds )
data class UnAssignTdFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignTl1ToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: Seconds )
data class UnAssignTl1FromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignTl2ToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: Seconds )
data class UnAssignTl2FromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignTw5ToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: Seconds )
data class UnAssignTw5FromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignValueToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignValueFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVanmaxToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVanmaxFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVomaxToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVomaxFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVominToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVominFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVsmaxToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVsmaxFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVsminToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVsminFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVtcToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVtcFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVtlmtToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVtlmtFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVtmToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVtmFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )
data class AssignVtnToDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID, val assignment: PU )
data class UnAssignVtnFromDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null )

// multiple association events


// DiscExcContIEEEDEC2A Events

data class CreateDiscExcContIEEEDEC2AEvent(
     var discExcContIEEEDEC2AId: UUID? = null
)

data class UpdateDiscExcContIEEEDEC2AEvent(
    @Id var discExcContIEEEDEC2AId: UUID? = null,
    var td1: Seconds,
    var td2: Seconds,
    var vdmax: PU,
    var vdmin: PU,
    var vk: PU
)

data class DeleteDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID? = null)

// single association events
data class AssignTd1ToDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID, val assignment: Seconds )
data class UnAssignTd1FromDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID? = null )
data class AssignTd2ToDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID, val assignment: Seconds )
data class UnAssignTd2FromDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID? = null )
data class AssignVdmaxToDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID, val assignment: PU )
data class UnAssignVdmaxFromDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID? = null )
data class AssignVdminToDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID, val assignment: PU )
data class UnAssignVdminFromDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID? = null )
data class AssignVkToDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID, val assignment: PU )
data class UnAssignVkFromDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID? = null )

// multiple association events


// DiscExcContIEEEDEC3A Events

data class CreateDiscExcContIEEEDEC3AEvent(
     var discExcContIEEEDEC3AId: UUID? = null
)

data class UpdateDiscExcContIEEEDEC3AEvent(
    @Id var discExcContIEEEDEC3AId: UUID? = null,
    var tdr: Seconds,
    var vtmin: PU
)

data class DeleteDiscExcContIEEEDEC3AEvent(@Id val discExcContIEEEDEC3AId: UUID? = null)

// single association events
data class AssignTdrToDiscExcContIEEEDEC3AEvent(@Id val discExcContIEEEDEC3AId: UUID, val assignment: Seconds )
data class UnAssignTdrFromDiscExcContIEEEDEC3AEvent(@Id val discExcContIEEEDEC3AId: UUID? = null )
data class AssignVtminToDiscExcContIEEEDEC3AEvent(@Id val discExcContIEEEDEC3AId: UUID, val assignment: PU )
data class UnAssignVtminFromDiscExcContIEEEDEC3AEvent(@Id val discExcContIEEEDEC3AId: UUID? = null )

// multiple association events


// Disconnector Events

data class CreateDisconnectorEvent(
     var disconnectorId: UUID? = null
)

data class UpdateDisconnectorEvent(
     var disconnectorId: UUID? = null
)

data class DeleteDisconnectorEvent(@Id val disconnectorId: UUID? = null)

// single association events

// multiple association events


// DiscontinuousExcitationControlDynamics Events

data class CreateDiscontinuousExcitationControlDynamicsEvent(
     var discontinuousExcitationControlDynamicsId: UUID? = null
)

data class UpdateDiscontinuousExcitationControlDynamicsEvent(
    @Id var discontinuousExcitationControlDynamicsId: UUID? = null,
    var discontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics
)

data class DeleteDiscontinuousExcitationControlDynamicsEvent(@Id val discontinuousExcitationControlDynamicsId: UUID? = null)

// single association events
data class AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsEvent(@Id val discontinuousExcitationControlDynamicsId: UUID, val assignment: DiscontinuousExcitationControlDynamics )
data class UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsEvent(@Id val discontinuousExcitationControlDynamicsId: UUID? = null )

// multiple association events


// DiscontinuousExcitationControlUserDefined Events

data class CreateDiscontinuousExcitationControlUserDefinedEvent(
     var discontinuousExcitationControlUserDefinedId: UUID? = null
)

data class UpdateDiscontinuousExcitationControlUserDefinedEvent(
    @Id var discontinuousExcitationControlUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteDiscontinuousExcitationControlUserDefinedEvent(@Id val discontinuousExcitationControlUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToDiscontinuousExcitationControlUserDefinedEvent(@Id val discontinuousExcitationControlUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromDiscontinuousExcitationControlUserDefinedEvent(@Id val discontinuousExcitationControlUserDefinedId: UUID? = null )

// multiple association events


// Discrete Events

data class CreateDiscreteEvent(
     var discreteId: UUID? = null
)

data class UpdateDiscreteEvent(
    @Id var discreteId: UUID? = null,
    var discretes:  Set<Discrete>
)

data class DeleteDiscreteEvent(@Id val discreteId: UUID? = null)

// single association events

// multiple association events
data class AssignDiscretesToDiscreteEvent(@Id val discreteId: UUID, val addTo: Discrete )
data class RemoveDiscretesFromDiscreteEvent(@Id val discreteId: UUID, val removeFrom: Discrete )


// DiscreteValue Events

data class CreateDiscreteValueEvent(
     var discreteValueId: UUID? = null
)

data class UpdateDiscreteValueEvent(
    @Id var discreteValueId: UUID? = null,
    var value: IntegerProxy,
    var discreteValues:  Set<DiscreteValue>
)

data class DeleteDiscreteValueEvent(@Id val discreteValueId: UUID? = null)

// single association events
data class AssignValueToDiscreteValueEvent(@Id val discreteValueId: UUID, val assignment: IntegerProxy )
data class UnAssignValueFromDiscreteValueEvent(@Id val discreteValueId: UUID? = null )

// multiple association events
data class AssignDiscreteValuesToDiscreteValueEvent(@Id val discreteValueId: UUID, val addTo: DiscreteValue )
data class RemoveDiscreteValuesFromDiscreteValueEvent(@Id val discreteValueId: UUID, val removeFrom: DiscreteValue )


// DomainVersion Events

data class CreateDomainVersionEvent(
     var domainVersionId: UUID? = null
)

data class UpdateDomainVersionEvent(
    @Id var domainVersionId: UUID? = null,
    var baseUML: StringProxy,
    var date: DateProxy,
    var entsoeUML: StringProxy,
    var version: StringProxy
)

data class DeleteDomainVersionEvent(@Id val domainVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToDomainVersionEvent(@Id val domainVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromDomainVersionEvent(@Id val domainVersionId: UUID? = null )
data class AssignDateToDomainVersionEvent(@Id val domainVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromDomainVersionEvent(@Id val domainVersionId: UUID? = null )
data class AssignEntsoeUMLToDomainVersionEvent(@Id val domainVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromDomainVersionEvent(@Id val domainVersionId: UUID? = null )
data class AssignVersionToDomainVersionEvent(@Id val domainVersionId: UUID, val assignment: StringProxy )
data class UnAssignVersionFromDomainVersionEvent(@Id val domainVersionId: UUID? = null )

// multiple association events


// DynamicsFunctionBlock Events

data class CreateDynamicsFunctionBlockEvent(
     var dynamicsFunctionBlockId: UUID? = null
)

data class UpdateDynamicsFunctionBlockEvent(
    @Id var dynamicsFunctionBlockId: UUID? = null,
    var enabled: BooleanProxy
)

data class DeleteDynamicsFunctionBlockEvent(@Id val dynamicsFunctionBlockId: UUID? = null)

// single association events
data class AssignEnabledToDynamicsFunctionBlockEvent(@Id val dynamicsFunctionBlockId: UUID, val assignment: BooleanProxy )
data class UnAssignEnabledFromDynamicsFunctionBlockEvent(@Id val dynamicsFunctionBlockId: UUID? = null )

// multiple association events


// DynamicsVersion Events

data class CreateDynamicsVersionEvent(
     var dynamicsVersionId: UUID? = null
)

data class UpdateDynamicsVersionEvent(
    @Id var dynamicsVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURI: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURI: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignBaseURIToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignDateToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignDifferenceModelURIToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignEntsoeUMLToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignEntsoeURIToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignModelDescriptionURIToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignNamespaceRDFToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignNamespaceUMLToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )
data class AssignShortNameToDynamicsVersionEvent(@Id val dynamicsVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null )

// multiple association events


// Dynamicsmodel Events

data class CreateDynamicsmodelEvent(
     var dynamicsmodelId: UUID? = null
)

data class UpdateDynamicsmodelEvent(
     var dynamicsmodelId: UUID? = null
)

data class DeleteDynamicsmodelEvent(@Id val dynamicsmodelId: UUID? = null)

// single association events

// multiple association events


// ENTSOEConnectivityNode Events

data class CreateENTSOEConnectivityNodeEvent(
     var eNTSOEConnectivityNodeId: UUID? = null
)

data class UpdateENTSOEConnectivityNodeEvent(
     var eNTSOEConnectivityNodeId: UUID? = null
)

data class DeleteENTSOEConnectivityNodeEvent(@Id val eNTSOEConnectivityNodeId: UUID? = null)

// single association events

// multiple association events


// ENTSOEIdentifiedObject Events

data class CreateENTSOEIdentifiedObjectEvent(
     var eNTSOEIdentifiedObjectId: UUID? = null
)

data class UpdateENTSOEIdentifiedObjectEvent(
    @Id var eNTSOEIdentifiedObjectId: UUID? = null,
    var energyIdentCodeEic: StringProxy,
    var shortName: StringProxy
)

data class DeleteENTSOEIdentifiedObjectEvent(@Id val eNTSOEIdentifiedObjectId: UUID? = null)

// single association events
data class AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectEvent(@Id val eNTSOEIdentifiedObjectId: UUID, val assignment: StringProxy )
data class UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectEvent(@Id val eNTSOEIdentifiedObjectId: UUID? = null )
data class AssignShortNameToENTSOEIdentifiedObjectEvent(@Id val eNTSOEIdentifiedObjectId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromENTSOEIdentifiedObjectEvent(@Id val eNTSOEIdentifiedObjectId: UUID? = null )

// multiple association events


// ENTSOEJunction Events

data class CreateENTSOEJunctionEvent(
     var eNTSOEJunctionId: UUID? = null
)

data class UpdateENTSOEJunctionEvent(
     var eNTSOEJunctionId: UUID? = null
)

data class DeleteENTSOEJunctionEvent(@Id val eNTSOEJunctionId: UUID? = null)

// single association events

// multiple association events


// ENTSOEOperationalLimitType Events

data class CreateENTSOEOperationalLimitTypeEvent(
    @Id var eNTSOEOperationalLimitTypeId: UUID? = null,
    @Enumerated(EnumType.STRING) var limitType: LimitTypeKind
)

data class UpdateENTSOEOperationalLimitTypeEvent(
    @Id var eNTSOEOperationalLimitTypeId: UUID? = null,
    @Enumerated(EnumType.STRING) var limitType: LimitTypeKind
)

data class DeleteENTSOEOperationalLimitTypeEvent(@Id val eNTSOEOperationalLimitTypeId: UUID? = null)

// single association events

// multiple association events


// ENTSOETopologicalNode Events

data class CreateENTSOETopologicalNodeEvent(
     var eNTSOETopologicalNodeId: UUID? = null
)

data class UpdateENTSOETopologicalNodeEvent(
     var eNTSOETopologicalNodeId: UUID? = null
)

data class DeleteENTSOETopologicalNodeEvent(@Id val eNTSOETopologicalNodeId: UUID? = null)

// single association events

// multiple association events


// EarthFaultCompensator Events

data class CreateEarthFaultCompensatorEvent(
     var earthFaultCompensatorId: UUID? = null
)

data class UpdateEarthFaultCompensatorEvent(
    @Id var earthFaultCompensatorId: UUID? = null,
    var r: Resistance
)

data class DeleteEarthFaultCompensatorEvent(@Id val earthFaultCompensatorId: UUID? = null)

// single association events
data class AssignRToEarthFaultCompensatorEvent(@Id val earthFaultCompensatorId: UUID, val assignment: Resistance )
data class UnAssignRFromEarthFaultCompensatorEvent(@Id val earthFaultCompensatorId: UUID? = null )

// multiple association events


// EnergyArea Events

data class CreateEnergyAreaEvent(
     var energyAreaId: UUID? = null
)

data class UpdateEnergyAreaEvent(
     var energyAreaId: UUID? = null
)

data class DeleteEnergyAreaEvent(@Id val energyAreaId: UUID? = null)

// single association events

// multiple association events


// EnergyConsumer Events

data class CreateEnergyConsumerEvent(
     var energyConsumerId: UUID? = null
)

data class UpdateEnergyConsumerEvent(
    @Id var energyConsumerId: UUID? = null,
    var pfixed: ActivePower,
    var pfixedPct: PerCent,
    var qfixed: ReactivePower,
    var qfixedPct: PerCent,
    var energyConsumer:  Set<EnergyConsumer>
)

data class DeleteEnergyConsumerEvent(@Id val energyConsumerId: UUID? = null)

// single association events
data class AssignPfixedToEnergyConsumerEvent(@Id val energyConsumerId: UUID, val assignment: ActivePower )
data class UnAssignPfixedFromEnergyConsumerEvent(@Id val energyConsumerId: UUID? = null )
data class AssignPfixedPctToEnergyConsumerEvent(@Id val energyConsumerId: UUID, val assignment: PerCent )
data class UnAssignPfixedPctFromEnergyConsumerEvent(@Id val energyConsumerId: UUID? = null )
data class AssignQfixedToEnergyConsumerEvent(@Id val energyConsumerId: UUID, val assignment: ReactivePower )
data class UnAssignQfixedFromEnergyConsumerEvent(@Id val energyConsumerId: UUID? = null )
data class AssignQfixedPctToEnergyConsumerEvent(@Id val energyConsumerId: UUID, val assignment: PerCent )
data class UnAssignQfixedPctFromEnergyConsumerEvent(@Id val energyConsumerId: UUID? = null )

// multiple association events
data class AssignEnergyConsumerToEnergyConsumerEvent(@Id val energyConsumerId: UUID, val addTo: EnergyConsumer )
data class RemoveEnergyConsumerFromEnergyConsumerEvent(@Id val energyConsumerId: UUID, val removeFrom: EnergyConsumer )


// EnergySchedulingType Events

data class CreateEnergySchedulingTypeEvent(
     var energySchedulingTypeId: UUID? = null
)

data class UpdateEnergySchedulingTypeEvent(
     var energySchedulingTypeId: UUID? = null
)

data class DeleteEnergySchedulingTypeEvent(@Id val energySchedulingTypeId: UUID? = null)

// single association events

// multiple association events


// EnergySource Events

data class CreateEnergySourceEvent(
     var energySourceId: UUID? = null
)

data class UpdateEnergySourceEvent(
    @Id var energySourceId: UUID? = null,
    var energySource:  Set<EnergySource>
)

data class DeleteEnergySourceEvent(@Id val energySourceId: UUID? = null)

// single association events

// multiple association events
data class AssignEnergySourceToEnergySourceEvent(@Id val energySourceId: UUID, val addTo: EnergySource )
data class RemoveEnergySourceFromEnergySourceEvent(@Id val energySourceId: UUID, val removeFrom: EnergySource )


// Equipment Events

data class CreateEquipmentEvent(
     var equipmentId: UUID? = null
)

data class UpdateEquipmentEvent(
    @Id var equipmentId: UUID? = null,
    var equipments:  Set<Equipment>
)

data class DeleteEquipmentEvent(@Id val equipmentId: UUID? = null)

// single association events

// multiple association events
data class AssignEquipmentsToEquipmentEvent(@Id val equipmentId: UUID, val addTo: Equipment )
data class RemoveEquipmentsFromEquipmentEvent(@Id val equipmentId: UUID, val removeFrom: Equipment )


// EquipmentBoundaryVersion Events

data class CreateEquipmentBoundaryVersionEvent(
     var equipmentBoundaryVersionId: UUID? = null
)

data class UpdateEquipmentBoundaryVersionEvent(
    @Id var equipmentBoundaryVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURI: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURIcore: StringProxy,
    var entsoeURIoperation: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignBaseURIToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignDateToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignDifferenceModelURIToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignEntsoeUMLToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignEntsoeURIcoreToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignEntsoeURIoperationToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignModelDescriptionURIToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignNamespaceRDFToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignNamespaceUMLToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )
data class AssignShortNameToEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null )

// multiple association events


// EquipmentContainer Events

data class CreateEquipmentContainerEvent(
     var equipmentContainerId: UUID? = null
)

data class UpdateEquipmentContainerEvent(
     var equipmentContainerId: UUID? = null
)

data class DeleteEquipmentContainerEvent(@Id val equipmentContainerId: UUID? = null)

// single association events

// multiple association events


// EquipmentVersion Events

data class CreateEquipmentVersionEvent(
     var equipmentVersionId: UUID? = null
)

data class UpdateEquipmentVersionEvent(
    @Id var equipmentVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURIcore: StringProxy,
    var baseURIoperation: StringProxy,
    var baseURIshortCircuit: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURIcore: StringProxy,
    var entsoeURIoperation: StringProxy,
    var entsoeURIshortCircuit: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignBaseURIcoreToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIcoreFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignBaseURIoperationToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIoperationFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignBaseURIshortCircuitToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIshortCircuitFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignDateToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignDifferenceModelURIToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignEntsoeUMLToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignEntsoeURIcoreToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIcoreFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignEntsoeURIoperationToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIoperationFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignEntsoeURIshortCircuitToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIshortCircuitFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignModelDescriptionURIToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignNamespaceRDFToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignNamespaceUMLToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )
data class AssignShortNameToEquipmentVersionEvent(@Id val equipmentVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null )

// multiple association events


// EquivalentBranch Events

data class CreateEquivalentBranchEvent(
     var equivalentBranchId: UUID? = null
)

data class UpdateEquivalentBranchEvent(
    @Id var equivalentBranchId: UUID? = null,
    var negativeR12: Resistance,
    var negativeR21: Resistance,
    var negativeX12: Reactance,
    var negativeX21: Reactance,
    var positiveR12: Resistance,
    var positiveR21: Resistance,
    var positiveX12: Reactance,
    var positiveX21: Reactance,
    var r: Resistance,
    var r21: Resistance,
    var x: Reactance,
    var x21: Reactance,
    var zeroR12: Resistance,
    var zeroR21: Resistance,
    var zeroX12: Reactance,
    var zeroX21: Reactance
)

data class DeleteEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null)

// single association events
data class AssignNegativeR12ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Resistance )
data class UnAssignNegativeR12FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignNegativeR21ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Resistance )
data class UnAssignNegativeR21FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignNegativeX12ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Reactance )
data class UnAssignNegativeX12FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignNegativeX21ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Reactance )
data class UnAssignNegativeX21FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignPositiveR12ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Resistance )
data class UnAssignPositiveR12FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignPositiveR21ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Resistance )
data class UnAssignPositiveR21FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignPositiveX12ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Reactance )
data class UnAssignPositiveX12FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignPositiveX21ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Reactance )
data class UnAssignPositiveX21FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignRToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Resistance )
data class UnAssignRFromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignR21ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Resistance )
data class UnAssignR21FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignXToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Reactance )
data class UnAssignXFromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignX21ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Reactance )
data class UnAssignX21FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignZeroR12ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Resistance )
data class UnAssignZeroR12FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignZeroR21ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Resistance )
data class UnAssignZeroR21FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignZeroX12ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Reactance )
data class UnAssignZeroX12FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )
data class AssignZeroX21ToEquivalentBranchEvent(@Id val equivalentBranchId: UUID, val assignment: Reactance )
data class UnAssignZeroX21FromEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null )

// multiple association events


// EquivalentEquipment Events

data class CreateEquivalentEquipmentEvent(
     var equivalentEquipmentId: UUID? = null
)

data class UpdateEquivalentEquipmentEvent(
    @Id var equivalentEquipmentId: UUID? = null,
    var equivalentEquipments:  Set<EquivalentEquipment>
)

data class DeleteEquivalentEquipmentEvent(@Id val equivalentEquipmentId: UUID? = null)

// single association events

// multiple association events
data class AssignEquivalentEquipmentsToEquivalentEquipmentEvent(@Id val equivalentEquipmentId: UUID, val addTo: EquivalentEquipment )
data class RemoveEquivalentEquipmentsFromEquivalentEquipmentEvent(@Id val equivalentEquipmentId: UUID, val removeFrom: EquivalentEquipment )


// EquivalentInjection Events

data class CreateEquivalentInjectionEvent(
     var equivalentInjectionId: UUID? = null
)

data class UpdateEquivalentInjectionEvent(
    @Id var equivalentInjectionId: UUID? = null,
    var maxP: ActivePower,
    var maxQ: ReactivePower,
    var minP: ActivePower,
    var minQ: ReactivePower,
    var r: Resistance,
    var r0: Resistance,
    var r2: Resistance,
    var regulationCapability: BooleanProxy,
    var x: Reactance,
    var x0: Reactance,
    var x2: Reactance,
    var equivalentInjection:  Set<EquivalentInjection>
)

data class DeleteEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null)

// single association events
data class AssignMaxPToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: ActivePower )
data class UnAssignMaxPFromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignMaxQToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: ReactivePower )
data class UnAssignMaxQFromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignMinPToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: ActivePower )
data class UnAssignMinPFromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignMinQToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: ReactivePower )
data class UnAssignMinQFromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignRToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: Resistance )
data class UnAssignRFromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignR0ToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: Resistance )
data class UnAssignR0FromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignR2ToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: Resistance )
data class UnAssignR2FromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignRegulationCapabilityToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: BooleanProxy )
data class UnAssignRegulationCapabilityFromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignXToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: Reactance )
data class UnAssignXFromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignX0ToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: Reactance )
data class UnAssignX0FromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )
data class AssignX2ToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val assignment: Reactance )
data class UnAssignX2FromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null )

// multiple association events
data class AssignEquivalentInjectionToEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val addTo: EquivalentInjection )
data class RemoveEquivalentInjectionFromEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID, val removeFrom: EquivalentInjection )


// EquivalentNetwork Events

data class CreateEquivalentNetworkEvent(
     var equivalentNetworkId: UUID? = null
)

data class UpdateEquivalentNetworkEvent(
     var equivalentNetworkId: UUID? = null
)

data class DeleteEquivalentNetworkEvent(@Id val equivalentNetworkId: UUID? = null)

// single association events

// multiple association events


// EquivalentShunt Events

data class CreateEquivalentShuntEvent(
     var equivalentShuntId: UUID? = null
)

data class UpdateEquivalentShuntEvent(
    @Id var equivalentShuntId: UUID? = null,
    var b: Susceptance,
    var g: Conductance
)

data class DeleteEquivalentShuntEvent(@Id val equivalentShuntId: UUID? = null)

// single association events
data class AssignBToEquivalentShuntEvent(@Id val equivalentShuntId: UUID, val assignment: Susceptance )
data class UnAssignBFromEquivalentShuntEvent(@Id val equivalentShuntId: UUID? = null )
data class AssignGToEquivalentShuntEvent(@Id val equivalentShuntId: UUID, val assignment: Conductance )
data class UnAssignGFromEquivalentShuntEvent(@Id val equivalentShuntId: UUID? = null )

// multiple association events


// ExcAC1A Events

data class CreateExcAC1AEvent(
     var excAC1AId: UUID? = null
)

data class UpdateExcAC1AEvent(
    @Id var excAC1AId: UUID? = null,
    var hvlvgates: BooleanProxy,
    var ka: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kf: PU,
    var kf1: PU,
    var kf2: PU,
    var ks: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcAC1AEvent(@Id val excAC1AId: UUID? = null)

// single association events
data class AssignHvlvgatesToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: BooleanProxy )
data class UnAssignHvlvgatesFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignKaToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignKaFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignKcToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignKcFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignKdToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignKdFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignKeToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignKeFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignKfToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignKfFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignKf1ToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignKf1FromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignKf2ToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignKf2FromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignKsToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignKsFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignSeve1ToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignSeve2ToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignTaToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignTbToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignTcToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignTeToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignTfToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignVamaxToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignVaminToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignVe1ToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignVe1FromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignVe2ToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignVe2FromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignVrmaxToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )
data class AssignVrminToExcAC1AEvent(@Id val excAC1AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcAC1AEvent(@Id val excAC1AId: UUID? = null )

// multiple association events


// ExcAC2A Events

data class CreateExcAC2AEvent(
     var excAC2AId: UUID? = null
)

data class UpdateExcAC2AEvent(
    @Id var excAC2AId: UUID? = null,
    var hvgate: BooleanProxy,
    var ka: PU,
    var kb: PU,
    var kb1: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kf: PU,
    var kh: PU,
    var kl: PU,
    var kl1: PU,
    var ks: PU,
    var lvgate: BooleanProxy,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vfemax: PU,
    var vlr: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcAC2AEvent(@Id val excAC2AId: UUID? = null)

// single association events
data class AssignHvgateToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: BooleanProxy )
data class UnAssignHvgateFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKaToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKaFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKbToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKbFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKb1ToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKb1FromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKcToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKcFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKdToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKdFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKeToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKeFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKfToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKfFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKhToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKhFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKlToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKlFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKl1ToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKl1FromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignKsToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignKsFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignLvgateToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: BooleanProxy )
data class UnAssignLvgateFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignSeve1ToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignSeve2ToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignTaToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignTbToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignTcToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignTeToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignTfToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignVamaxToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignVaminToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignVe1ToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignVe1FromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignVe2ToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignVe2FromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignVfemaxToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignVfemaxFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignVlrToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignVlrFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignVrmaxToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )
data class AssignVrminToExcAC2AEvent(@Id val excAC2AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcAC2AEvent(@Id val excAC2AId: UUID? = null )

// multiple association events


// ExcAC3A Events

data class CreateExcAC3AEvent(
     var excAC3AId: UUID? = null
)

data class UpdateExcAC3AEvent(
    @Id var excAC3AId: UUID? = null,
    var efdn: PU,
    var ka: Seconds,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kf: PU,
    var kf1: PU,
    var kf2: PU,
    var klv: PU,
    var kn: PU,
    var kr: PU,
    var ks: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: PU,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vemin: PU,
    var vfemax: PU,
    var vlv: PU
)

data class DeleteExcAC3AEvent(@Id val excAC3AId: UUID? = null)

// single association events
data class AssignEfdnToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignEfdnFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKaToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: Seconds )
data class UnAssignKaFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKcToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKcFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKdToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKdFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKeToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKeFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKfToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKfFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKf1ToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKf1FromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKf2ToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKf2FromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKlvToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKlvFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKnToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKnFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKrToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKrFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignKsToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignKsFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignSeve1ToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignSeve2ToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignTaToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignTaFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignTbToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignTcToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignTeToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignTfToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignVamaxToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignVaminToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignVe1ToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignVe1FromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignVe2ToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignVe2FromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignVeminToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignVeminFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignVfemaxToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignVfemaxFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )
data class AssignVlvToExcAC3AEvent(@Id val excAC3AId: UUID, val assignment: PU )
data class UnAssignVlvFromExcAC3AEvent(@Id val excAC3AId: UUID? = null )

// multiple association events


// ExcAC4A Events

data class CreateExcAC4AEvent(
     var excAC4AId: UUID? = null
)

data class UpdateExcAC4AEvent(
    @Id var excAC4AId: UUID? = null,
    var ka: PU,
    var kc: PU,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var vimax: PU,
    var vimin: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcAC4AEvent(@Id val excAC4AId: UUID? = null)

// single association events
data class AssignKaToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: PU )
data class UnAssignKaFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )
data class AssignKcToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: PU )
data class UnAssignKcFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )
data class AssignTaToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )
data class AssignTbToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )
data class AssignTcToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )
data class AssignVimaxToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )
data class AssignViminToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: PU )
data class UnAssignViminFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )
data class AssignVrmaxToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )
data class AssignVrminToExcAC4AEvent(@Id val excAC4AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcAC4AEvent(@Id val excAC4AId: UUID? = null )

// multiple association events


// ExcAC5A Events

data class CreateExcAC5AEvent(
     var excAC5AId: UUID? = null
)

data class UpdateExcAC5AEvent(
    @Id var excAC5AId: UUID? = null,
    var a: Simple_Float,
    var efd1: PU,
    var efd2: PU,
    var ka: PU,
    var ke: PU,
    var kf: PU,
    var ks: PU,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf1: Seconds,
    var tf2: Seconds,
    var tf3: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcAC5AEvent(@Id val excAC5AId: UUID? = null)

// single association events
data class AssignAToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Simple_Float )
data class UnAssignAFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignEfd1ToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignEfd2ToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignKaToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: PU )
data class UnAssignKaFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignKeToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: PU )
data class UnAssignKeFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignKfToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: PU )
data class UnAssignKfFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignKsToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: PU )
data class UnAssignKsFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignSeefd1ToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignSeefd2ToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignTaToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignTbToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignTcToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignTeToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignTf1ToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Seconds )
data class UnAssignTf1FromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignTf2ToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Seconds )
data class UnAssignTf2FromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignTf3ToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: Seconds )
data class UnAssignTf3FromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignVrmaxToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )
data class AssignVrminToExcAC5AEvent(@Id val excAC5AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcAC5AEvent(@Id val excAC5AId: UUID? = null )

// multiple association events


// ExcAC6A Events

data class CreateExcAC6AEvent(
     var excAC6AId: UUID? = null
)

data class UpdateExcAC6AEvent(
    @Id var excAC6AId: UUID? = null,
    var ka: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kh: PU,
    var ks: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var th: Seconds,
    var tj: Seconds,
    var tk: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vfelim: PU,
    var vhmax: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcAC6AEvent(@Id val excAC6AId: UUID? = null)

// single association events
data class AssignKaToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignKaFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignKcToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignKcFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignKdToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignKdFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignKeToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignKeFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignKhToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignKhFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignKsToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignKsFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignSeve1ToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignSeve2ToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignTaToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignTbToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignTcToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignTeToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignThToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Seconds )
data class UnAssignThFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignTjToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Seconds )
data class UnAssignTjFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignTkToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: Seconds )
data class UnAssignTkFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignVamaxToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignVaminToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignVe1ToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignVe1FromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignVe2ToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignVe2FromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignVfelimToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignVfelimFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignVhmaxToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignVhmaxFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignVrmaxToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )
data class AssignVrminToExcAC6AEvent(@Id val excAC6AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcAC6AEvent(@Id val excAC6AId: UUID? = null )

// multiple association events


// ExcAC8B Events

data class CreateExcAC8BEvent(
     var excAC8BId: UUID? = null
)

data class UpdateExcAC8BEvent(
    @Id var excAC8BId: UUID? = null,
    var inlim: BooleanProxy,
    var ka: PU,
    var kc: PU,
    var kd: PU,
    var kdr: PU,
    var ke: PU,
    var kir: PU,
    var kpr: PU,
    var ks: PU,
    var pidlim: BooleanProxy,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tdr: Seconds,
    var te: Seconds,
    var telim: BooleanProxy,
    var ve1: PU,
    var ve2: PU,
    var vemin: PU,
    var vfemax: PU,
    var vimax: PU,
    var vimin: PU,
    var vpidmax: PU,
    var vpidmin: PU,
    var vrmax: PU,
    var vrmin: PU,
    var vtmult: BooleanProxy
)

data class DeleteExcAC8BEvent(@Id val excAC8BId: UUID? = null)

// single association events
data class AssignInlimToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: BooleanProxy )
data class UnAssignInlimFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignKaToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignKaFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignKcToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignKcFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignKdToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignKdFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignKdrToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignKdrFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignKeToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignKeFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignKirToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignKirFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignKprToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignKprFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignKsToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignKsFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignPidlimToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: BooleanProxy )
data class UnAssignPidlimFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignSeve1ToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignSeve2ToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignTaToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignTdrToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: Seconds )
data class UnAssignTdrFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignTeToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignTelimToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: BooleanProxy )
data class UnAssignTelimFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVe1ToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVe1FromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVe2ToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVe2FromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVeminToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVeminFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVfemaxToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVfemaxFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVimaxToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignViminToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignViminFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVpidmaxToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVpidmaxFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVpidminToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVpidminFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVrmaxToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVrminToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )
data class AssignVtmultToExcAC8BEvent(@Id val excAC8BId: UUID, val assignment: BooleanProxy )
data class UnAssignVtmultFromExcAC8BEvent(@Id val excAC8BId: UUID? = null )

// multiple association events


// ExcANS Events

data class CreateExcANSEvent(
     var excANSId: UUID? = null
)

data class UpdateExcANSEvent(
    @Id var excANSId: UUID? = null,
    var blint: IntegerProxy,
    var ifmn: PU,
    var ifmx: PU,
    var k2: Simple_Float,
    var k3: Simple_Float,
    var kce: Simple_Float,
    var krvecc: IntegerProxy,
    var kvfif: IntegerProxy,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var tb: Seconds,
    var vrmn: PU,
    var vrmx: PU
)

data class DeleteExcANSEvent(@Id val excANSId: UUID? = null)

// single association events
data class AssignBlintToExcANSEvent(@Id val excANSId: UUID, val assignment: IntegerProxy )
data class UnAssignBlintFromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignIfmnToExcANSEvent(@Id val excANSId: UUID, val assignment: PU )
data class UnAssignIfmnFromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignIfmxToExcANSEvent(@Id val excANSId: UUID, val assignment: PU )
data class UnAssignIfmxFromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignK2ToExcANSEvent(@Id val excANSId: UUID, val assignment: Simple_Float )
data class UnAssignK2FromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignK3ToExcANSEvent(@Id val excANSId: UUID, val assignment: Simple_Float )
data class UnAssignK3FromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignKceToExcANSEvent(@Id val excANSId: UUID, val assignment: Simple_Float )
data class UnAssignKceFromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignKrveccToExcANSEvent(@Id val excANSId: UUID, val assignment: IntegerProxy )
data class UnAssignKrveccFromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignKvfifToExcANSEvent(@Id val excANSId: UUID, val assignment: IntegerProxy )
data class UnAssignKvfifFromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignT1ToExcANSEvent(@Id val excANSId: UUID, val assignment: Seconds )
data class UnAssignT1FromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignT2ToExcANSEvent(@Id val excANSId: UUID, val assignment: Seconds )
data class UnAssignT2FromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignT3ToExcANSEvent(@Id val excANSId: UUID, val assignment: Seconds )
data class UnAssignT3FromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignTbToExcANSEvent(@Id val excANSId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignVrmnToExcANSEvent(@Id val excANSId: UUID, val assignment: PU )
data class UnAssignVrmnFromExcANSEvent(@Id val excANSId: UUID? = null )
data class AssignVrmxToExcANSEvent(@Id val excANSId: UUID, val assignment: PU )
data class UnAssignVrmxFromExcANSEvent(@Id val excANSId: UUID? = null )

// multiple association events


// ExcAVR1 Events

data class CreateExcAVR1Event(
     var excAVR1Id: UUID? = null
)

data class UpdateExcAVR1Event(
    @Id var excAVR1Id: UUID? = null,
    var e1: PU,
    var e2: PU,
    var ka: Simple_Float,
    var kf: Simple_Float,
    var se1: Simple_Float,
    var se2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vrmn: PU,
    var vrmx: PU
)

data class DeleteExcAVR1Event(@Id val excAVR1Id: UUID? = null)

// single association events
data class AssignE1ToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: PU )
data class UnAssignE1FromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignE2ToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: PU )
data class UnAssignE2FromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignKaToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: Simple_Float )
data class UnAssignKaFromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignKfToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: Simple_Float )
data class UnAssignKfFromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignSe1ToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: Simple_Float )
data class UnAssignSe1FromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignSe2ToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: Simple_Float )
data class UnAssignSe2FromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignTaToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignTbToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: Seconds )
data class UnAssignTbFromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignTeToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignTfToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: Seconds )
data class UnAssignTfFromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignVrmnToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: PU )
data class UnAssignVrmnFromExcAVR1Event(@Id val excAVR1Id: UUID? = null )
data class AssignVrmxToExcAVR1Event(@Id val excAVR1Id: UUID, val assignment: PU )
data class UnAssignVrmxFromExcAVR1Event(@Id val excAVR1Id: UUID? = null )

// multiple association events


// ExcAVR2 Events

data class CreateExcAVR2Event(
     var excAVR2Id: UUID? = null
)

data class UpdateExcAVR2Event(
    @Id var excAVR2Id: UUID? = null,
    var e1: PU,
    var e2: PU,
    var ka: Simple_Float,
    var kf: Simple_Float,
    var se1: Simple_Float,
    var se2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var te: Seconds,
    var tf1: Seconds,
    var tf2: Seconds,
    var vrmn: PU,
    var vrmx: PU
)

data class DeleteExcAVR2Event(@Id val excAVR2Id: UUID? = null)

// single association events
data class AssignE1ToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: PU )
data class UnAssignE1FromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignE2ToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: PU )
data class UnAssignE2FromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignKaToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Simple_Float )
data class UnAssignKaFromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignKfToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Simple_Float )
data class UnAssignKfFromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignSe1ToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Simple_Float )
data class UnAssignSe1FromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignSe2ToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Simple_Float )
data class UnAssignSe2FromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignTaToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignTbToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Seconds )
data class UnAssignTbFromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignTeToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignTf1ToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Seconds )
data class UnAssignTf1FromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignTf2ToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: Seconds )
data class UnAssignTf2FromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignVrmnToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: PU )
data class UnAssignVrmnFromExcAVR2Event(@Id val excAVR2Id: UUID? = null )
data class AssignVrmxToExcAVR2Event(@Id val excAVR2Id: UUID, val assignment: PU )
data class UnAssignVrmxFromExcAVR2Event(@Id val excAVR2Id: UUID? = null )

// multiple association events


// ExcAVR3 Events

data class CreateExcAVR3Event(
     var excAVR3Id: UUID? = null
)

data class UpdateExcAVR3Event(
    @Id var excAVR3Id: UUID? = null,
    var e1: PU,
    var e2: PU,
    var ka: Simple_Float,
    var se1: Simple_Float,
    var se2: Simple_Float,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var te: Seconds,
    var vrmn: PU,
    var vrmx: PU
)

data class DeleteExcAVR3Event(@Id val excAVR3Id: UUID? = null)

// single association events
data class AssignE1ToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: PU )
data class UnAssignE1FromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignE2ToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: PU )
data class UnAssignE2FromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignKaToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: Simple_Float )
data class UnAssignKaFromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignSe1ToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: Simple_Float )
data class UnAssignSe1FromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignSe2ToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: Simple_Float )
data class UnAssignSe2FromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignT1ToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: Seconds )
data class UnAssignT1FromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignT2ToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: Seconds )
data class UnAssignT2FromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignT3ToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: Seconds )
data class UnAssignT3FromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignT4ToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: Seconds )
data class UnAssignT4FromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignTeToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: Seconds )
data class UnAssignTeFromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignVrmnToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: PU )
data class UnAssignVrmnFromExcAVR3Event(@Id val excAVR3Id: UUID? = null )
data class AssignVrmxToExcAVR3Event(@Id val excAVR3Id: UUID, val assignment: PU )
data class UnAssignVrmxFromExcAVR3Event(@Id val excAVR3Id: UUID? = null )

// multiple association events


// ExcAVR4 Events

data class CreateExcAVR4Event(
     var excAVR4Id: UUID? = null
)

data class UpdateExcAVR4Event(
    @Id var excAVR4Id: UUID? = null,
    var imul: BooleanProxy,
    var ka: Simple_Float,
    var ke: Simple_Float,
    var kif: Simple_Float,
    var t1: Seconds,
    var t1if: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var tif: Seconds,
    var vfmn: PU,
    var vfmx: PU,
    var vrmn: PU,
    var vrmx: PU
)

data class DeleteExcAVR4Event(@Id val excAVR4Id: UUID? = null)

// single association events
data class AssignImulToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: BooleanProxy )
data class UnAssignImulFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignKaToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Simple_Float )
data class UnAssignKaFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignKeToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Simple_Float )
data class UnAssignKeFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignKifToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Simple_Float )
data class UnAssignKifFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignT1ToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Seconds )
data class UnAssignT1FromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignT1ifToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Seconds )
data class UnAssignT1ifFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignT2ToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Seconds )
data class UnAssignT2FromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignT3ToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Seconds )
data class UnAssignT3FromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignT4ToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Seconds )
data class UnAssignT4FromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignTifToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: Seconds )
data class UnAssignTifFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignVfmnToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: PU )
data class UnAssignVfmnFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignVfmxToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: PU )
data class UnAssignVfmxFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignVrmnToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: PU )
data class UnAssignVrmnFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )
data class AssignVrmxToExcAVR4Event(@Id val excAVR4Id: UUID, val assignment: PU )
data class UnAssignVrmxFromExcAVR4Event(@Id val excAVR4Id: UUID? = null )

// multiple association events


// ExcAVR5 Events

data class CreateExcAVR5Event(
     var excAVR5Id: UUID? = null
)

data class UpdateExcAVR5Event(
    @Id var excAVR5Id: UUID? = null,
    var ka: PU,
    var rex: PU,
    var ta: Seconds
)

data class DeleteExcAVR5Event(@Id val excAVR5Id: UUID? = null)

// single association events
data class AssignKaToExcAVR5Event(@Id val excAVR5Id: UUID, val assignment: PU )
data class UnAssignKaFromExcAVR5Event(@Id val excAVR5Id: UUID? = null )
data class AssignRexToExcAVR5Event(@Id val excAVR5Id: UUID, val assignment: PU )
data class UnAssignRexFromExcAVR5Event(@Id val excAVR5Id: UUID? = null )
data class AssignTaToExcAVR5Event(@Id val excAVR5Id: UUID, val assignment: Seconds )
data class UnAssignTaFromExcAVR5Event(@Id val excAVR5Id: UUID? = null )

// multiple association events


// ExcAVR7 Events

data class CreateExcAVR7Event(
     var excAVR7Id: UUID? = null
)

data class UpdateExcAVR7Event(
    @Id var excAVR7Id: UUID? = null,
    var a1: PU,
    var a2: PU,
    var a3: PU,
    var a4: PU,
    var a5: PU,
    var a6: PU,
    var k1: PU,
    var k3: PU,
    var k5: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var vmax1: PU,
    var vmax3: PU,
    var vmax5: PU,
    var vmin1: PU,
    var vmin3: PU,
    var vmin5: PU
)

data class DeleteExcAVR7Event(@Id val excAVR7Id: UUID? = null)

// single association events
data class AssignA1ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignA1FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignA2ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignA2FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignA3ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignA3FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignA4ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignA4FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignA5ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignA5FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignA6ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignA6FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignK1ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignK1FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignK3ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignK3FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignK5ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignK5FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignT1ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: Seconds )
data class UnAssignT1FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignT2ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: Seconds )
data class UnAssignT2FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignT3ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: Seconds )
data class UnAssignT3FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignT4ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: Seconds )
data class UnAssignT4FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignT5ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: Seconds )
data class UnAssignT5FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignT6ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: Seconds )
data class UnAssignT6FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignVmax1ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignVmax1FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignVmax3ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignVmax3FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignVmax5ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignVmax5FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignVmin1ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignVmin1FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignVmin3ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignVmin3FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )
data class AssignVmin5ToExcAVR7Event(@Id val excAVR7Id: UUID, val assignment: PU )
data class UnAssignVmin5FromExcAVR7Event(@Id val excAVR7Id: UUID? = null )

// multiple association events


// ExcBBC Events

data class CreateExcBBCEvent(
     var excBBCId: UUID? = null
)

data class UpdateExcBBCEvent(
    @Id var excBBCId: UUID? = null,
    var efdmax: PU,
    var efdmin: PU,
    var k: PU,
    var switchIt: BooleanProxy,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var vrmax: PU,
    var vrmin: PU,
    var xe: PU
)

data class DeleteExcBBCEvent(@Id val excBBCId: UUID? = null)

// single association events
data class AssignEfdmaxToExcBBCEvent(@Id val excBBCId: UUID, val assignment: PU )
data class UnAssignEfdmaxFromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignEfdminToExcBBCEvent(@Id val excBBCId: UUID, val assignment: PU )
data class UnAssignEfdminFromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignKToExcBBCEvent(@Id val excBBCId: UUID, val assignment: PU )
data class UnAssignKFromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignSwitchItToExcBBCEvent(@Id val excBBCId: UUID, val assignment: BooleanProxy )
data class UnAssignSwitchItFromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignT1ToExcBBCEvent(@Id val excBBCId: UUID, val assignment: Seconds )
data class UnAssignT1FromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignT2ToExcBBCEvent(@Id val excBBCId: UUID, val assignment: Seconds )
data class UnAssignT2FromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignT3ToExcBBCEvent(@Id val excBBCId: UUID, val assignment: Seconds )
data class UnAssignT3FromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignT4ToExcBBCEvent(@Id val excBBCId: UUID, val assignment: Seconds )
data class UnAssignT4FromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignVrmaxToExcBBCEvent(@Id val excBBCId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignVrminToExcBBCEvent(@Id val excBBCId: UUID, val assignment: PU )
data class UnAssignVrminFromExcBBCEvent(@Id val excBBCId: UUID? = null )
data class AssignXeToExcBBCEvent(@Id val excBBCId: UUID, val assignment: PU )
data class UnAssignXeFromExcBBCEvent(@Id val excBBCId: UUID? = null )

// multiple association events


// ExcCZ Events

data class CreateExcCZEvent(
     var excCZId: UUID? = null
)

data class UpdateExcCZEvent(
    @Id var excCZId: UUID? = null,
    var efdmax: PU,
    var efdmin: PU,
    var ka: PU,
    var ke: PU,
    var kp: PU,
    var ta: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcCZEvent(@Id val excCZId: UUID? = null)

// single association events
data class AssignEfdmaxToExcCZEvent(@Id val excCZId: UUID, val assignment: PU )
data class UnAssignEfdmaxFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignEfdminToExcCZEvent(@Id val excCZId: UUID, val assignment: PU )
data class UnAssignEfdminFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignKaToExcCZEvent(@Id val excCZId: UUID, val assignment: PU )
data class UnAssignKaFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignKeToExcCZEvent(@Id val excCZId: UUID, val assignment: PU )
data class UnAssignKeFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignKpToExcCZEvent(@Id val excCZId: UUID, val assignment: PU )
data class UnAssignKpFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignTaToExcCZEvent(@Id val excCZId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignTcToExcCZEvent(@Id val excCZId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignTeToExcCZEvent(@Id val excCZId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignVrmaxToExcCZEvent(@Id val excCZId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcCZEvent(@Id val excCZId: UUID? = null )
data class AssignVrminToExcCZEvent(@Id val excCZId: UUID, val assignment: PU )
data class UnAssignVrminFromExcCZEvent(@Id val excCZId: UUID? = null )

// multiple association events


// ExcDC1A Events

data class CreateExcDC1AEvent(
     var excDC1AId: UUID? = null
)

data class UpdateExcDC1AEvent(
    @Id var excDC1AId: UUID? = null,
    var edfmax: PU,
    var efd1: PU,
    var efd2: PU,
    var efdmin: PU,
    var exclim: BooleanProxy,
    var ka: PU,
    var ke: PU,
    var kf: PU,
    var ks: PU,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcDC1AEvent(@Id val excDC1AId: UUID? = null)

// single association events
data class AssignEdfmaxToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignEdfmaxFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignEfd1ToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignEfd2ToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignEfdminToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignEfdminFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignExclimToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: BooleanProxy )
data class UnAssignExclimFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignKaToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignKaFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignKeToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignKeFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignKfToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignKfFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignKsToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignKsFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignSeefd1ToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignSeefd2ToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignTaToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignTbToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignTcToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignTeToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignTfToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignVrmaxToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )
data class AssignVrminToExcDC1AEvent(@Id val excDC1AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcDC1AEvent(@Id val excDC1AId: UUID? = null )

// multiple association events


// ExcDC2A Events

data class CreateExcDC2AEvent(
     var excDC2AId: UUID? = null
)

data class UpdateExcDC2AEvent(
    @Id var excDC2AId: UUID? = null,
    var efd1: PU,
    var efd2: PU,
    var exclim: BooleanProxy,
    var ka: PU,
    var ke: PU,
    var kf: PU,
    var ks: PU,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var tf1: Seconds,
    var vrmax: PU,
    var vrmin: PU,
    var vtlim: BooleanProxy
)

data class DeleteExcDC2AEvent(@Id val excDC2AId: UUID? = null)

// single association events
data class AssignEfd1ToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignEfd2ToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignExclimToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: BooleanProxy )
data class UnAssignExclimFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignKaToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: PU )
data class UnAssignKaFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignKeToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: PU )
data class UnAssignKeFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignKfToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: PU )
data class UnAssignKfFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignKsToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: PU )
data class UnAssignKsFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignSeefd1ToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignSeefd2ToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignTaToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignTbToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignTcToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignTeToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignTfToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignTf1ToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: Seconds )
data class UnAssignTf1FromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignVrmaxToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignVrminToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )
data class AssignVtlimToExcDC2AEvent(@Id val excDC2AId: UUID, val assignment: BooleanProxy )
data class UnAssignVtlimFromExcDC2AEvent(@Id val excDC2AId: UUID? = null )

// multiple association events


// ExcDC3A Events

data class CreateExcDC3AEvent(
     var excDC3AId: UUID? = null
)

data class UpdateExcDC3AEvent(
    @Id var excDC3AId: UUID? = null,
    var edfmax: PU,
    var efd1: PU,
    var efd2: PU,
    var efdlim: BooleanProxy,
    var efdmin: PU,
    var exclim: BooleanProxy,
    var ke: PU,
    var kr: PU,
    var ks: PU,
    var kv: PU,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var te: Seconds,
    var trh: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcDC3AEvent(@Id val excDC3AId: UUID? = null)

// single association events
data class AssignEdfmaxToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignEdfmaxFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignEfd1ToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignEfd2ToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignEfdlimToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: BooleanProxy )
data class UnAssignEfdlimFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignEfdminToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignEfdminFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignExclimToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: BooleanProxy )
data class UnAssignExclimFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignKeToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignKeFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignKrToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignKrFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignKsToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignKsFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignKvToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignKvFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignSeefd1ToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignSeefd2ToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignTeToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignTrhToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: Seconds )
data class UnAssignTrhFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignVrmaxToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )
data class AssignVrminToExcDC3AEvent(@Id val excDC3AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcDC3AEvent(@Id val excDC3AId: UUID? = null )

// multiple association events


// ExcDC3A1 Events

data class CreateExcDC3A1Event(
     var excDC3A1Id: UUID? = null
)

data class UpdateExcDC3A1Event(
    @Id var excDC3A1Id: UUID? = null,
    var exclim: BooleanProxy,
    var ka: PU,
    var ke: PU,
    var kf: PU,
    var ki: PU,
    var kp: PU,
    var ta: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vb1max: PU,
    var vblim: BooleanProxy,
    var vbmax: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcDC3A1Event(@Id val excDC3A1Id: UUID? = null)

// single association events
data class AssignExclimToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: BooleanProxy )
data class UnAssignExclimFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignKaToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignKaFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignKeToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignKeFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignKfToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignKfFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignKiToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignKiFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignKpToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignKpFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignTaToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: Seconds )
data class UnAssignTaFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignTeToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: Seconds )
data class UnAssignTeFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignTfToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: Seconds )
data class UnAssignTfFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignVb1maxToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignVb1maxFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignVblimToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: BooleanProxy )
data class UnAssignVblimFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignVbmaxToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignVbmaxFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignVrmaxToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )
data class AssignVrminToExcDC3A1Event(@Id val excDC3A1Id: UUID, val assignment: PU )
data class UnAssignVrminFromExcDC3A1Event(@Id val excDC3A1Id: UUID? = null )

// multiple association events


// ExcELIN1 Events

data class CreateExcELIN1Event(
     var excELIN1Id: UUID? = null
)

data class UpdateExcELIN1Event(
    @Id var excELIN1Id: UUID? = null,
    var dpnf: PU,
    var efmax: PU,
    var efmin: PU,
    var ks1: PU,
    var ks2: PU,
    var smax: PU,
    var tfi: Seconds,
    var tnu: Seconds,
    var ts1: Seconds,
    var ts2: Seconds,
    var tsw: Seconds,
    var vpi: PU,
    var vpnf: PU,
    var vpu: PU,
    var xe: PU
)

data class DeleteExcELIN1Event(@Id val excELIN1Id: UUID? = null)

// single association events
data class AssignDpnfToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignDpnfFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignEfmaxToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignEfmaxFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignEfminToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignEfminFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignKs1ToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignKs1FromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignKs2ToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignKs2FromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignSmaxToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignSmaxFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignTfiToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: Seconds )
data class UnAssignTfiFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignTnuToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: Seconds )
data class UnAssignTnuFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignTs1ToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: Seconds )
data class UnAssignTs1FromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignTs2ToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: Seconds )
data class UnAssignTs2FromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignTswToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: Seconds )
data class UnAssignTswFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignVpiToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignVpiFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignVpnfToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignVpnfFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignVpuToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignVpuFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )
data class AssignXeToExcELIN1Event(@Id val excELIN1Id: UUID, val assignment: PU )
data class UnAssignXeFromExcELIN1Event(@Id val excELIN1Id: UUID? = null )

// multiple association events


// ExcELIN2 Events

data class CreateExcELIN2Event(
     var excELIN2Id: UUID? = null
)

data class UpdateExcELIN2Event(
    @Id var excELIN2Id: UUID? = null,
    var efdbas: PU,
    var iefmax: PU,
    var iefmax2: PU,
    var iefmin: PU,
    var k1: PU,
    var k1ec: PU,
    var k2: PU,
    var k3: PU,
    var k4: PU,
    var kd1: PU,
    var ke2: PU,
    var ketb: PU,
    var pid1max: PU,
    var seve1: PU,
    var seve2: PU,
    var tb1: Seconds,
    var te: Seconds,
    var te2: Seconds,
    var ti1: PU,
    var ti3: Seconds,
    var ti4: Seconds,
    var tr4: Seconds,
    var upmax: PU,
    var upmin: PU,
    var ve1: PU,
    var ve2: PU,
    var xp: PU
)

data class DeleteExcELIN2Event(@Id val excELIN2Id: UUID? = null)

// single association events
data class AssignEfdbasToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignEfdbasFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignIefmaxToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignIefmaxFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignIefmax2ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignIefmax2FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignIefminToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignIefminFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignK1ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignK1FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignK1ecToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignK1ecFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignK2ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignK2FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignK3ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignK3FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignK4ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignK4FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignKd1ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignKd1FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignKe2ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignKe2FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignKetbToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignKetbFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignPid1maxToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignPid1maxFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignSeve1ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignSeve1FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignSeve2ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignSeve2FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignTb1ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTb1FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignTeToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTeFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignTe2ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTe2FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignTi1ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignTi1FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignTi3ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTi3FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignTi4ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTi4FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignTr4ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTr4FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignUpmaxToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignUpmaxFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignUpminToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignUpminFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignVe1ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignVe1FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignVe2ToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignVe2FromExcELIN2Event(@Id val excELIN2Id: UUID? = null )
data class AssignXpToExcELIN2Event(@Id val excELIN2Id: UUID, val assignment: PU )
data class UnAssignXpFromExcELIN2Event(@Id val excELIN2Id: UUID? = null )

// multiple association events


// ExcHU Events

data class CreateExcHUEvent(
     var excHUId: UUID? = null
)

data class UpdateExcHUEvent(
    @Id var excHUId: UUID? = null,
    var ae: PU,
    var ai: PU,
    var atr: PU,
    var emax: PU,
    var emin: PU,
    var imax: PU,
    var imin: PU,
    var ke: Simple_Float,
    var ki: Simple_Float,
    var te: Seconds,
    var ti: Seconds,
    var tr: Seconds
)

data class DeleteExcHUEvent(@Id val excHUId: UUID? = null)

// single association events
data class AssignAeToExcHUEvent(@Id val excHUId: UUID, val assignment: PU )
data class UnAssignAeFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignAiToExcHUEvent(@Id val excHUId: UUID, val assignment: PU )
data class UnAssignAiFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignAtrToExcHUEvent(@Id val excHUId: UUID, val assignment: PU )
data class UnAssignAtrFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignEmaxToExcHUEvent(@Id val excHUId: UUID, val assignment: PU )
data class UnAssignEmaxFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignEminToExcHUEvent(@Id val excHUId: UUID, val assignment: PU )
data class UnAssignEminFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignImaxToExcHUEvent(@Id val excHUId: UUID, val assignment: PU )
data class UnAssignImaxFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignIminToExcHUEvent(@Id val excHUId: UUID, val assignment: PU )
data class UnAssignIminFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignKeToExcHUEvent(@Id val excHUId: UUID, val assignment: Simple_Float )
data class UnAssignKeFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignKiToExcHUEvent(@Id val excHUId: UUID, val assignment: Simple_Float )
data class UnAssignKiFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignTeToExcHUEvent(@Id val excHUId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignTiToExcHUEvent(@Id val excHUId: UUID, val assignment: Seconds )
data class UnAssignTiFromExcHUEvent(@Id val excHUId: UUID? = null )
data class AssignTrToExcHUEvent(@Id val excHUId: UUID, val assignment: Seconds )
data class UnAssignTrFromExcHUEvent(@Id val excHUId: UUID? = null )

// multiple association events


// ExcIEEEAC1A Events

data class CreateExcIEEEAC1AEvent(
     var excIEEEAC1AId: UUID? = null
)

data class UpdateExcIEEEAC1AEvent(
    @Id var excIEEEAC1AId: UUID? = null,
    var ka: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kf: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null)

// single association events
data class AssignKaToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignKcToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignKdToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignKdFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignKeToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignKfToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignSeve1ToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignSeve2ToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignTaToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignTbToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignTcToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignTeToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignTfToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignVamaxToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignVaminToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignVe1ToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignVe1FromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignVe2ToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignVe2FromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignVrmaxToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )
data class AssignVrminToExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null )

// multiple association events


// ExcIEEEAC2A Events

data class CreateExcIEEEAC2AEvent(
     var excIEEEAC2AId: UUID? = null
)

data class UpdateExcIEEEAC2AEvent(
    @Id var excIEEEAC2AId: UUID? = null,
    var ka: PU,
    var kb: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kf: PU,
    var kh: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vfemax: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null)

// single association events
data class AssignKaToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignKbToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignKbFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignKcToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignKdToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignKdFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignKeToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignKfToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignKhToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignKhFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignSeve1ToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignSeve2ToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignTaToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignTbToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignTcToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignTeToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignTfToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignVamaxToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignVaminToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignVe1ToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignVe1FromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignVe2ToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignVe2FromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignVfemaxToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignVfemaxFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignVrmaxToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )
data class AssignVrminToExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null )

// multiple association events


// ExcIEEEAC3A Events

data class CreateExcIEEEAC3AEvent(
     var excIEEEAC3AId: UUID? = null
)

data class UpdateExcIEEEAC3AEvent(
    @Id var excIEEEAC3AId: UUID? = null,
    var efdn: PU,
    var ka: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kf: PU,
    var kn: PU,
    var kr: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vemin: PU,
    var vfemax: PU
)

data class DeleteExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null)

// single association events
data class AssignEfdnToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignEfdnFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignKaToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignKcToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignKdToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignKdFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignKeToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignKfToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignKnToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignKnFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignKrToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignKrFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignSeve1ToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignSeve2ToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignTaToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignTbToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignTcToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignTeToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignTfToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignVamaxToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignVaminToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignVe1ToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignVe1FromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignVe2ToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignVe2FromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignVeminToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignVeminFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )
data class AssignVfemaxToExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID, val assignment: PU )
data class UnAssignVfemaxFromExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null )

// multiple association events


// ExcIEEEAC4A Events

data class CreateExcIEEEAC4AEvent(
     var excIEEEAC4AId: UUID? = null
)

data class UpdateExcIEEEAC4AEvent(
    @Id var excIEEEAC4AId: UUID? = null,
    var ka: PU,
    var kc: PU,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var vimax: PU,
    var vimin: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null)

// single association events
data class AssignKaToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )
data class AssignKcToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )
data class AssignTaToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )
data class AssignTbToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )
data class AssignTcToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )
data class AssignVimaxToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )
data class AssignViminToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: PU )
data class UnAssignViminFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )
data class AssignVrmaxToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )
data class AssignVrminToExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null )

// multiple association events


// ExcIEEEAC5A Events

data class CreateExcIEEEAC5AEvent(
     var excIEEEAC5AId: UUID? = null
)

data class UpdateExcIEEEAC5AEvent(
    @Id var excIEEEAC5AId: UUID? = null,
    var efd1: PU,
    var efd2: PU,
    var ka: PU,
    var ke: PU,
    var kf: PU,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var ta: Seconds,
    var te: Seconds,
    var tf1: Seconds,
    var tf2: Seconds,
    var tf3: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null)

// single association events
data class AssignEfd1ToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignEfd2ToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignKaToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignKeToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignKfToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignSeefd1ToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignSeefd2ToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignTaToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignTeToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignTf1ToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: Seconds )
data class UnAssignTf1FromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignTf2ToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: Seconds )
data class UnAssignTf2FromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignTf3ToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: Seconds )
data class UnAssignTf3FromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignVrmaxToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )
data class AssignVrminToExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null )

// multiple association events


// ExcIEEEAC6A Events

data class CreateExcIEEEAC6AEvent(
     var excIEEEAC6AId: UUID? = null
)

data class UpdateExcIEEEAC6AEvent(
    @Id var excIEEEAC6AId: UUID? = null,
    var ka: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kh: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var th: Seconds,
    var tj: Seconds,
    var tk: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vfelim: PU,
    var vhmax: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null)

// single association events
data class AssignKaToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignKcToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignKdToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignKdFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignKeToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignKhToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignKhFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignSeve1ToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignSeve2ToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignTaToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignTbToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignTcToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignTeToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignThToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Seconds )
data class UnAssignThFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignTjToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Seconds )
data class UnAssignTjFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignTkToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: Seconds )
data class UnAssignTkFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignVamaxToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignVaminToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignVe1ToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignVe1FromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignVe2ToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignVe2FromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignVfelimToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignVfelimFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignVhmaxToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignVhmaxFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignVrmaxToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )
data class AssignVrminToExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null )

// multiple association events


// ExcIEEEAC7B Events

data class CreateExcIEEEAC7BEvent(
     var excIEEEAC7BId: UUID? = null
)

data class UpdateExcIEEEAC7BEvent(
    @Id var excIEEEAC7BId: UUID? = null,
    var kc: PU,
    var kd: PU,
    var kdr: PU,
    var ke: PU,
    var kf1: PU,
    var kf2: PU,
    var kf3: PU,
    var kia: PU,
    var kir: PU,
    var kl: PU,
    var kp: PU,
    var kpa: PU,
    var kpr: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var tdr: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vamax: PU,
    var vamin: PU,
    var ve1: PU,
    var ve2: PU,
    var vemin: PU,
    var vfemax: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null)

// single association events
data class AssignKcToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKdToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKdFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKdrToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKdrFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKeToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKf1ToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKf1FromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKf2ToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKf2FromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKf3ToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKf3FromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKiaToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKiaFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKirToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKirFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKlToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKlFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKpToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKpFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKpaToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKpaFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignKprToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignKprFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignSeve1ToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignSeve2ToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignTdrToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: Seconds )
data class UnAssignTdrFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignTeToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignTfToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignVamaxToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignVaminToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignVaminFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignVe1ToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignVe1FromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignVe2ToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignVe2FromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignVeminToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignVeminFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignVfemaxToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignVfemaxFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignVrmaxToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )
data class AssignVrminToExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null )

// multiple association events


// ExcIEEEAC8B Events

data class CreateExcIEEEAC8BEvent(
     var excIEEEAC8BId: UUID? = null
)

data class UpdateExcIEEEAC8BEvent(
    @Id var excIEEEAC8BId: UUID? = null,
    var ka: PU,
    var kc: PU,
    var kd: PU,
    var kdr: PU,
    var ke: PU,
    var kir: PU,
    var kpr: PU,
    var seve1: Simple_Float,
    var seve2: Simple_Float,
    var ta: Seconds,
    var tdr: Seconds,
    var te: Seconds,
    var ve1: PU,
    var ve2: PU,
    var vemin: PU,
    var vfemax: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null)

// single association events
data class AssignKaToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignKcToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignKdToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignKdFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignKdrToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignKdrFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignKeToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignKirToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignKirFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignKprToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignKprFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignSeve1ToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: Simple_Float )
data class UnAssignSeve1FromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignSeve2ToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: Simple_Float )
data class UnAssignSeve2FromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignTaToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignTdrToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: Seconds )
data class UnAssignTdrFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignTeToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignVe1ToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignVe1FromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignVe2ToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignVe2FromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignVeminToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignVeminFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignVfemaxToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignVfemaxFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignVrmaxToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )
data class AssignVrminToExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null )

// multiple association events


// ExcIEEEDC1A Events

data class CreateExcIEEEDC1AEvent(
     var excIEEEDC1AId: UUID? = null
)

data class UpdateExcIEEEDC1AEvent(
    @Id var excIEEEDC1AId: UUID? = null,
    var efd1: PU,
    var efd2: PU,
    var exclim: BooleanProxy,
    var ka: PU,
    var ke: PU,
    var kf: PU,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var uelin: BooleanProxy,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null)

// single association events
data class AssignEfd1ToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignEfd2ToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignExclimToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: BooleanProxy )
data class UnAssignExclimFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignKaToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignKeToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignKfToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignSeefd1ToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignSeefd2ToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignTaToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignTbToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignTcToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignTeToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignTfToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignUelinToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: BooleanProxy )
data class UnAssignUelinFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignVrmaxToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )
data class AssignVrminToExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null )

// multiple association events


// ExcIEEEDC2A Events

data class CreateExcIEEEDC2AEvent(
     var excIEEEDC2AId: UUID? = null
)

data class UpdateExcIEEEDC2AEvent(
    @Id var excIEEEDC2AId: UUID? = null,
    var efd1: PU,
    var efd2: PU,
    var exclim: PU,
    var ka: PU,
    var ke: PU,
    var kf: PU,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var uelin: BooleanProxy,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null)

// single association events
data class AssignEfd1ToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignEfd2ToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignExclimToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: PU )
data class UnAssignExclimFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignKaToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignKeToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignKfToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignSeefd1ToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignSeefd2ToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignTaToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignTbToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignTcToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignTeToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignTfToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignUelinToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: BooleanProxy )
data class UnAssignUelinFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignVrmaxToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )
data class AssignVrminToExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null )

// multiple association events


// ExcIEEEDC3A Events

data class CreateExcIEEEDC3AEvent(
     var excIEEEDC3AId: UUID? = null
)

data class UpdateExcIEEEDC3AEvent(
    @Id var excIEEEDC3AId: UUID? = null,
    var efd1: PU,
    var efd2: PU,
    var exclim: BooleanProxy,
    var ke: PU,
    var kv: PU,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var te: Seconds,
    var trh: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null)

// single association events
data class AssignEfd1ToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignEfd2ToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignExclimToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: BooleanProxy )
data class UnAssignExclimFromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignKeToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignKvToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: PU )
data class UnAssignKvFromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignSeefd1ToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignSeefd2ToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignTeToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignTrhToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: Seconds )
data class UnAssignTrhFromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignVrmaxToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )
data class AssignVrminToExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null )

// multiple association events


// ExcIEEEDC4B Events

data class CreateExcIEEEDC4BEvent(
     var excIEEEDC4BId: UUID? = null
)

data class UpdateExcIEEEDC4BEvent(
    @Id var excIEEEDC4BId: UUID? = null,
    var efd1: PU,
    var efd2: PU,
    var ka: PU,
    var kd: PU,
    var ke: PU,
    var kf: PU,
    var ki: PU,
    var kp: PU,
    var oelin: BooleanProxy,
    var seefd1: Simple_Float,
    var seefd2: Simple_Float,
    var ta: Seconds,
    var td: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var uelin: BooleanProxy,
    var vemin: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null)

// single association events
data class AssignEfd1ToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignEfd1FromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignEfd2ToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignEfd2FromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignKaToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignKdToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignKdFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignKeToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignKfToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignKiToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignKiFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignKpToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignKpFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignOelinToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: BooleanProxy )
data class UnAssignOelinFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignSeefd1ToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd1FromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignSeefd2ToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: Simple_Float )
data class UnAssignSeefd2FromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignTaToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignTdToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: Seconds )
data class UnAssignTdFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignTeToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignTfToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignUelinToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: BooleanProxy )
data class UnAssignUelinFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignVeminToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignVeminFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignVrmaxToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )
data class AssignVrminToExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null )

// multiple association events


// ExcIEEEST1A Events

data class CreateExcIEEEST1AEvent(
    @Id var excIEEEST1AId: UUID? = null,
    @Enumerated(EnumType.STRING) var uelin: ExcIEEEST1AUELselectorKind
)

data class UpdateExcIEEEST1AEvent(
    @Id var excIEEEST1AId: UUID? = null,
    var ilr: PU,
    var ka: PU,
    var kc: PU,
    var kf: PU,
    var klr: PU,
    var pssin: BooleanProxy,
    var ta: Seconds,
    var tb: Seconds,
    var tb1: Seconds,
    var tc: Seconds,
    var tc1: Seconds,
    var tf: Seconds,
    @Enumerated(EnumType.STRING) var uelin: ExcIEEEST1AUELselectorKind,
    var vamax: PU,
    var vamin: PU,
    var vimax: PU,
    var vimin: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null)

// single association events
data class AssignIlrToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignIlrFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignKaToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignKcToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignKfToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignKlrToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignKlrFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignPssinToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: BooleanProxy )
data class UnAssignPssinFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignTaToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignTbToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignTb1ToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: Seconds )
data class UnAssignTb1FromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignTcToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignTc1ToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: Seconds )
data class UnAssignTc1FromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignTfToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignVamaxToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignVaminToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignVimaxToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignViminToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignViminFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignVrmaxToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )
data class AssignVrminToExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null )

// multiple association events


// ExcIEEEST2A Events

data class CreateExcIEEEST2AEvent(
     var excIEEEST2AId: UUID? = null
)

data class UpdateExcIEEEST2AEvent(
    @Id var excIEEEST2AId: UUID? = null,
    var efdmax: PU,
    var ka: PU,
    var kc: PU,
    var ke: PU,
    var kf: PU,
    var ki: PU,
    var kp: PU,
    var ta: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var uelin: BooleanProxy,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null)

// single association events
data class AssignEfdmaxToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignEfdmaxFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignKaToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignKcToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignKeToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignKeFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignKfToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignKfFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignKiToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignKiFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignKpToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignKpFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignTaToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignTeToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignTfToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignUelinToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: BooleanProxy )
data class UnAssignUelinFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignVrmaxToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )
data class AssignVrminToExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null )

// multiple association events


// ExcIEEEST3A Events

data class CreateExcIEEEST3AEvent(
     var excIEEEST3AId: UUID? = null
)

data class UpdateExcIEEEST3AEvent(
    @Id var excIEEEST3AId: UUID? = null,
    var ka: PU,
    var kc: PU,
    var kg: PU,
    var ki: PU,
    var km: PU,
    var kp: PU,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var thetap: AngleDegrees,
    var tm: Seconds,
    var vbmax: PU,
    var vgmax: PU,
    var vimax: PU,
    var vimin: PU,
    var vmmax: PU,
    var vmmin: PU,
    var vrmax: PU,
    var vrmin: PU,
    var xl: PU
)

data class DeleteExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null)

// single association events
data class AssignKaToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignKaFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignKcToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignKgToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignKgFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignKiToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignKiFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignKmToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignKmFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignKpToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignKpFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignTaToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignTbToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignTcToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignThetapToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: AngleDegrees )
data class UnAssignThetapFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignTmToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: Seconds )
data class UnAssignTmFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignVbmaxToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignVbmaxFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignVgmaxToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignVgmaxFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignVimaxToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignViminToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignViminFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignVmmaxToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignVmmaxFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignVmminToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignVmminFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignVrmaxToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignVrminToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )
data class AssignXlToExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID, val assignment: PU )
data class UnAssignXlFromExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null )

// multiple association events


// ExcIEEEST4B Events

data class CreateExcIEEEST4BEvent(
     var excIEEEST4BId: UUID? = null
)

data class UpdateExcIEEEST4BEvent(
    @Id var excIEEEST4BId: UUID? = null,
    var kc: PU,
    var kg: PU,
    var ki: PU,
    var kim: PU,
    var kir: PU,
    var kp: PU,
    var kpm: PU,
    var kpr: PU,
    var ta: Seconds,
    var thetap: AngleDegrees,
    var vbmax: PU,
    var vmmax: PU,
    var vmmin: PU,
    var vrmax: PU,
    var vrmin: PU,
    var xl: PU
)

data class DeleteExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null)

// single association events
data class AssignKcToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignKgToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignKgFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignKiToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignKiFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignKimToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignKimFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignKirToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignKirFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignKpToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignKpFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignKpmToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignKpmFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignKprToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignKprFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignTaToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignThetapToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: AngleDegrees )
data class UnAssignThetapFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignVbmaxToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignVbmaxFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignVmmaxToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignVmmaxFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignVmminToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignVmminFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignVrmaxToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignVrminToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )
data class AssignXlToExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID, val assignment: PU )
data class UnAssignXlFromExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null )

// multiple association events


// ExcIEEEST5B Events

data class CreateExcIEEEST5BEvent(
     var excIEEEST5BId: UUID? = null
)

data class UpdateExcIEEEST5BEvent(
    @Id var excIEEEST5BId: UUID? = null,
    var kc: PU,
    var kr: PU,
    var t1: Seconds,
    var tb1: Seconds,
    var tb2: Seconds,
    var tc1: Seconds,
    var tc2: Seconds,
    var tob1: Seconds,
    var tob2: Seconds,
    var toc1: Seconds,
    var toc2: Seconds,
    var tub1: Seconds,
    var tub2: Seconds,
    var tuc1: Seconds,
    var tuc2: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null)

// single association events
data class AssignKcToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: PU )
data class UnAssignKcFromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignKrToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: PU )
data class UnAssignKrFromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignT1ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignT1FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTb1ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTb1FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTb2ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTb2FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTc1ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTc1FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTc2ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTc2FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTob1ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTob1FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTob2ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTob2FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignToc1ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignToc1FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignToc2ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignToc2FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTub1ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTub1FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTub2ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTub2FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTuc1ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTuc1FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignTuc2ToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: Seconds )
data class UnAssignTuc2FromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignVrmaxToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )
data class AssignVrminToExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null )

// multiple association events


// ExcIEEEST6B Events

data class CreateExcIEEEST6BEvent(
    @Id var excIEEEST6BId: UUID? = null,
    @Enumerated(EnumType.STRING) var oelin: ExcST6BOELselectorKind
)

data class UpdateExcIEEEST6BEvent(
    @Id var excIEEEST6BId: UUID? = null,
    var ilr: PU,
    var kci: PU,
    var kff: PU,
    var kg: PU,
    var kia: PU,
    var klr: PU,
    var km: PU,
    var kpa: PU,
    @Enumerated(EnumType.STRING) var oelin: ExcST6BOELselectorKind,
    var tg: Seconds,
    var vamax: PU,
    var vamin: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null)

// single association events
data class AssignIlrToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignIlrFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignKciToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignKciFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignKffToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignKffFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignKgToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignKgFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignKiaToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignKiaFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignKlrToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignKlrFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignKmToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignKmFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignKpaToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignKpaFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignTgToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: Seconds )
data class UnAssignTgFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignVamaxToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignVaminToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignVaminFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignVrmaxToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )
data class AssignVrminToExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null )

// multiple association events


// ExcIEEEST7B Events

data class CreateExcIEEEST7BEvent(
    @Id var excIEEEST7BId: UUID? = null,
    @Enumerated(EnumType.STRING) var oelin: ExcST7BOELselectorKind,
    @Enumerated(EnumType.STRING) var uelin: ExcST7BUELselectorKind
)

data class UpdateExcIEEEST7BEvent(
    @Id var excIEEEST7BId: UUID? = null,
    var kh: PU,
    var kia: PU,
    var kl: PU,
    var kpa: PU,
    @Enumerated(EnumType.STRING) var oelin: ExcST7BOELselectorKind,
    var tb: Seconds,
    var tc: Seconds,
    var tf: Seconds,
    var tg: Seconds,
    var tia: Seconds,
    @Enumerated(EnumType.STRING) var uelin: ExcST7BUELselectorKind,
    var vmax: PU,
    var vmin: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null)

// single association events
data class AssignKhToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: PU )
data class UnAssignKhFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignKiaToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: PU )
data class UnAssignKiaFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignKlToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: PU )
data class UnAssignKlFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignKpaToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: PU )
data class UnAssignKpaFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignTbToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignTcToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignTfToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignTgToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: Seconds )
data class UnAssignTgFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignTiaToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: Seconds )
data class UnAssignTiaFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignVmaxToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: PU )
data class UnAssignVmaxFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignVminToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: PU )
data class UnAssignVminFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignVrmaxToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )
data class AssignVrminToExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null )

// multiple association events


// ExcOEX3T Events

data class CreateExcOEX3TEvent(
     var excOEX3TId: UUID? = null
)

data class UpdateExcOEX3TEvent(
    @Id var excOEX3TId: UUID? = null,
    var e1: PU,
    var e2: PU,
    var ka: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kf: PU,
    var see1: PU,
    var see2: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcOEX3TEvent(@Id val excOEX3TId: UUID? = null)

// single association events
data class AssignE1ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignE1FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignE2ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignE2FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignKaToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignKaFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignKcToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignKcFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignKdToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignKdFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignKeToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignKeFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignKfToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignKfFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignSee1ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignSee1FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignSee2ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignSee2FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignT1ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: Seconds )
data class UnAssignT1FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignT2ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: Seconds )
data class UnAssignT2FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignT3ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: Seconds )
data class UnAssignT3FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignT4ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: Seconds )
data class UnAssignT4FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignT5ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: Seconds )
data class UnAssignT5FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignT6ToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: Seconds )
data class UnAssignT6FromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignTeToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignTfToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignVrmaxToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )
data class AssignVrminToExcOEX3TEvent(@Id val excOEX3TId: UUID, val assignment: PU )
data class UnAssignVrminFromExcOEX3TEvent(@Id val excOEX3TId: UUID? = null )

// multiple association events


// ExcPIC Events

data class CreateExcPICEvent(
     var excPICId: UUID? = null
)

data class UpdateExcPICEvent(
    @Id var excPICId: UUID? = null,
    var e1: PU,
    var e2: PU,
    var efdmax: PU,
    var efdmin: PU,
    var ka: PU,
    var kc: PU,
    var ke: PU,
    var kf: PU,
    var ki: PU,
    var kp: PU,
    var se1: PU,
    var se2: PU,
    var ta1: Seconds,
    var ta2: Seconds,
    var ta3: Seconds,
    var ta4: Seconds,
    var te: Seconds,
    var tf1: Seconds,
    var tf2: Seconds,
    var vr1: PU,
    var vr2: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcPICEvent(@Id val excPICId: UUID? = null)

// single association events
data class AssignE1ToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignE1FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignE2ToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignE2FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignEfdmaxToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignEfdmaxFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignEfdminToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignEfdminFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignKaToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignKaFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignKcToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignKcFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignKeToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignKeFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignKfToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignKfFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignKiToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignKiFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignKpToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignKpFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignSe1ToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignSe1FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignSe2ToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignSe2FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignTa1ToExcPICEvent(@Id val excPICId: UUID, val assignment: Seconds )
data class UnAssignTa1FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignTa2ToExcPICEvent(@Id val excPICId: UUID, val assignment: Seconds )
data class UnAssignTa2FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignTa3ToExcPICEvent(@Id val excPICId: UUID, val assignment: Seconds )
data class UnAssignTa3FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignTa4ToExcPICEvent(@Id val excPICId: UUID, val assignment: Seconds )
data class UnAssignTa4FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignTeToExcPICEvent(@Id val excPICId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignTf1ToExcPICEvent(@Id val excPICId: UUID, val assignment: Seconds )
data class UnAssignTf1FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignTf2ToExcPICEvent(@Id val excPICId: UUID, val assignment: Seconds )
data class UnAssignTf2FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignVr1ToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignVr1FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignVr2ToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignVr2FromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignVrmaxToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcPICEvent(@Id val excPICId: UUID? = null )
data class AssignVrminToExcPICEvent(@Id val excPICId: UUID, val assignment: PU )
data class UnAssignVrminFromExcPICEvent(@Id val excPICId: UUID? = null )

// multiple association events


// ExcREXS Events

data class CreateExcREXSEvent(
    @Id var excREXSId: UUID? = null,
    @Enumerated(EnumType.STRING) var fbf: ExcREXSFeedbackSignalKind
)

data class UpdateExcREXSEvent(
    @Id var excREXSId: UUID? = null,
    var e1: PU,
    var e2: PU,
    @Enumerated(EnumType.STRING) var fbf: ExcREXSFeedbackSignalKind,
    var flimf: PU,
    var kc: PU,
    var kd: PU,
    var ke: PU,
    var kefd: PU,
    var kf: Seconds,
    var kh: PU,
    var kii: PU,
    var kip: PU,
    var ks: PU,
    var kvi: PU,
    var kvp: PU,
    var kvphz: PU,
    var nvphz: PU,
    var se1: PU,
    var se2: PU,
    var ta: Seconds,
    var tb1: Seconds,
    var tb2: Seconds,
    var tc1: Seconds,
    var tc2: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var tf1: Seconds,
    var tf2: Seconds,
    var tp: Seconds,
    var vcmax: PU,
    var vfmax: PU,
    var vfmin: PU,
    var vimax: PU,
    var vrmax: PU,
    var vrmin: PU,
    var xc: PU
)

data class DeleteExcREXSEvent(@Id val excREXSId: UUID? = null)

// single association events
data class AssignE1ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignE1FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignE2ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignE2FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignFlimfToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignFlimfFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKcToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKcFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKdToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKdFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKeToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKeFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKefdToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKefdFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKfToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignKfFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKhToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKhFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKiiToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKiiFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKipToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKipFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKsToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKsFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKviToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKviFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKvpToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKvpFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignKvphzToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignKvphzFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignNvphzToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignNvphzFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignSe1ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignSe1FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignSe2ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignSe2FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTaToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTb1ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTb1FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTb2ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTb2FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTc1ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTc1FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTc2ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTc2FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTeToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTfToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTf1ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTf1FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTf2ToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTf2FromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignTpToExcREXSEvent(@Id val excREXSId: UUID, val assignment: Seconds )
data class UnAssignTpFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignVcmaxToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignVcmaxFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignVfmaxToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignVfmaxFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignVfminToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignVfminFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignVimaxToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignVrmaxToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignVrminToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignVrminFromExcREXSEvent(@Id val excREXSId: UUID? = null )
data class AssignXcToExcREXSEvent(@Id val excREXSId: UUID, val assignment: PU )
data class UnAssignXcFromExcREXSEvent(@Id val excREXSId: UUID? = null )

// multiple association events


// ExcSCRX Events

data class CreateExcSCRXEvent(
     var excSCRXId: UUID? = null
)

data class UpdateExcSCRXEvent(
    @Id var excSCRXId: UUID? = null,
    var cswitch: BooleanProxy,
    var emax: PU,
    var emin: PU,
    var k: PU,
    var rcrfd: Simple_Float,
    var tatb: Simple_Float,
    var tb: Seconds,
    var te: Seconds
)

data class DeleteExcSCRXEvent(@Id val excSCRXId: UUID? = null)

// single association events
data class AssignCswitchToExcSCRXEvent(@Id val excSCRXId: UUID, val assignment: BooleanProxy )
data class UnAssignCswitchFromExcSCRXEvent(@Id val excSCRXId: UUID? = null )
data class AssignEmaxToExcSCRXEvent(@Id val excSCRXId: UUID, val assignment: PU )
data class UnAssignEmaxFromExcSCRXEvent(@Id val excSCRXId: UUID? = null )
data class AssignEminToExcSCRXEvent(@Id val excSCRXId: UUID, val assignment: PU )
data class UnAssignEminFromExcSCRXEvent(@Id val excSCRXId: UUID? = null )
data class AssignKToExcSCRXEvent(@Id val excSCRXId: UUID, val assignment: PU )
data class UnAssignKFromExcSCRXEvent(@Id val excSCRXId: UUID? = null )
data class AssignRcrfdToExcSCRXEvent(@Id val excSCRXId: UUID, val assignment: Simple_Float )
data class UnAssignRcrfdFromExcSCRXEvent(@Id val excSCRXId: UUID? = null )
data class AssignTatbToExcSCRXEvent(@Id val excSCRXId: UUID, val assignment: Simple_Float )
data class UnAssignTatbFromExcSCRXEvent(@Id val excSCRXId: UUID? = null )
data class AssignTbToExcSCRXEvent(@Id val excSCRXId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcSCRXEvent(@Id val excSCRXId: UUID? = null )
data class AssignTeToExcSCRXEvent(@Id val excSCRXId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcSCRXEvent(@Id val excSCRXId: UUID? = null )

// multiple association events


// ExcSEXS Events

data class CreateExcSEXSEvent(
     var excSEXSId: UUID? = null
)

data class UpdateExcSEXSEvent(
    @Id var excSEXSId: UUID? = null,
    var efdmax: PU,
    var efdmin: PU,
    var emax: PU,
    var emin: PU,
    var k: PU,
    var kc: PU,
    var tatb: Simple_Float,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds
)

data class DeleteExcSEXSEvent(@Id val excSEXSId: UUID? = null)

// single association events
data class AssignEfdmaxToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: PU )
data class UnAssignEfdmaxFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignEfdminToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: PU )
data class UnAssignEfdminFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignEmaxToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: PU )
data class UnAssignEmaxFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignEminToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: PU )
data class UnAssignEminFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignKToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: PU )
data class UnAssignKFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignKcToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: PU )
data class UnAssignKcFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignTatbToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: Simple_Float )
data class UnAssignTatbFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignTbToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignTcToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )
data class AssignTeToExcSEXSEvent(@Id val excSEXSId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcSEXSEvent(@Id val excSEXSId: UUID? = null )

// multiple association events


// ExcSK Events

data class CreateExcSKEvent(
     var excSKId: UUID? = null
)

data class UpdateExcSKEvent(
    @Id var excSKId: UUID? = null,
    var efdmax: PU,
    var efdmin: PU,
    var emax: PU,
    var emin: PU,
    var k: PU,
    var k1: PU,
    var k2: PU,
    var kc: PU,
    var kce: PU,
    var kd: PU,
    var kgob: PU,
    var kp: PU,
    var kqi: PU,
    var kqob: PU,
    var kqp: PU,
    var nq: PU,
    var qconoff: BooleanProxy,
    var qz: PU,
    var remote: BooleanProxy,
    var sbase: ApparentPower,
    var tc: Seconds,
    var te: Seconds,
    var ti: Seconds,
    var tp: Seconds,
    var tr: Seconds,
    var uimax: PU,
    var uimin: PU,
    var urmax: PU,
    var urmin: PU,
    var vtmax: PU,
    var vtmin: PU,
    var yp: PU
)

data class DeleteExcSKEvent(@Id val excSKId: UUID? = null)

// single association events
data class AssignEfdmaxToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignEfdmaxFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignEfdminToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignEfdminFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignEmaxToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignEmaxFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignEminToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignEminFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignK1ToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignK1FromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignK2ToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignK2FromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKcToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKcFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKceToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKceFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKdToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKdFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKgobToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKgobFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKpToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKpFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKqiToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKqiFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKqobToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKqobFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignKqpToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignKqpFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignNqToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignNqFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignQconoffToExcSKEvent(@Id val excSKId: UUID, val assignment: BooleanProxy )
data class UnAssignQconoffFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignQzToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignQzFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignRemoteToExcSKEvent(@Id val excSKId: UUID, val assignment: BooleanProxy )
data class UnAssignRemoteFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignSbaseToExcSKEvent(@Id val excSKId: UUID, val assignment: ApparentPower )
data class UnAssignSbaseFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignTcToExcSKEvent(@Id val excSKId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignTeToExcSKEvent(@Id val excSKId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignTiToExcSKEvent(@Id val excSKId: UUID, val assignment: Seconds )
data class UnAssignTiFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignTpToExcSKEvent(@Id val excSKId: UUID, val assignment: Seconds )
data class UnAssignTpFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignTrToExcSKEvent(@Id val excSKId: UUID, val assignment: Seconds )
data class UnAssignTrFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignUimaxToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignUimaxFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignUiminToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignUiminFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignUrmaxToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignUrmaxFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignUrminToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignUrminFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignVtmaxToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignVtmaxFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignVtminToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignVtminFromExcSKEvent(@Id val excSKId: UUID? = null )
data class AssignYpToExcSKEvent(@Id val excSKId: UUID, val assignment: PU )
data class UnAssignYpFromExcSKEvent(@Id val excSKId: UUID? = null )

// multiple association events


// ExcST1A Events

data class CreateExcST1AEvent(
     var excST1AId: UUID? = null
)

data class UpdateExcST1AEvent(
    @Id var excST1AId: UUID? = null,
    var ilr: PU,
    var ka: PU,
    var kc: PU,
    var kf: PU,
    var klr: PU,
    var ta: Seconds,
    var tb: Seconds,
    var tb1: Seconds,
    var tc: Seconds,
    var tc1: Seconds,
    var tf: Seconds,
    var vamax: PU,
    var vamin: PU,
    var vimax: PU,
    var vimin: PU,
    var vrmax: PU,
    var vrmin: PU,
    var xe: PU
)

data class DeleteExcST1AEvent(@Id val excST1AId: UUID? = null)

// single association events
data class AssignIlrToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignIlrFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignKaToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignKaFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignKcToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignKcFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignKfToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignKfFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignKlrToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignKlrFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignTaToExcST1AEvent(@Id val excST1AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignTbToExcST1AEvent(@Id val excST1AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignTb1ToExcST1AEvent(@Id val excST1AId: UUID, val assignment: Seconds )
data class UnAssignTb1FromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignTcToExcST1AEvent(@Id val excST1AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignTc1ToExcST1AEvent(@Id val excST1AId: UUID, val assignment: Seconds )
data class UnAssignTc1FromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignTfToExcST1AEvent(@Id val excST1AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignVamaxToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignVaminToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignVaminFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignVimaxToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignViminToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignViminFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignVrmaxToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignVrminToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcST1AEvent(@Id val excST1AId: UUID? = null )
data class AssignXeToExcST1AEvent(@Id val excST1AId: UUID, val assignment: PU )
data class UnAssignXeFromExcST1AEvent(@Id val excST1AId: UUID? = null )

// multiple association events


// ExcST2A Events

data class CreateExcST2AEvent(
     var excST2AId: UUID? = null
)

data class UpdateExcST2AEvent(
    @Id var excST2AId: UUID? = null,
    var efdmax: PU,
    var ka: PU,
    var kc: PU,
    var ke: PU,
    var kf: PU,
    var ki: PU,
    var kp: PU,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var te: Seconds,
    var tf: Seconds,
    var uelin: BooleanProxy,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcST2AEvent(@Id val excST2AId: UUID? = null)

// single association events
data class AssignEfdmaxToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignEfdmaxFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignKaToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignKaFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignKcToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignKcFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignKeToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignKeFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignKfToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignKfFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignKiToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignKiFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignKpToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignKpFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignTaToExcST2AEvent(@Id val excST2AId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignTbToExcST2AEvent(@Id val excST2AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignTcToExcST2AEvent(@Id val excST2AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignTeToExcST2AEvent(@Id val excST2AId: UUID, val assignment: Seconds )
data class UnAssignTeFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignTfToExcST2AEvent(@Id val excST2AId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignUelinToExcST2AEvent(@Id val excST2AId: UUID, val assignment: BooleanProxy )
data class UnAssignUelinFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignVrmaxToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcST2AEvent(@Id val excST2AId: UUID? = null )
data class AssignVrminToExcST2AEvent(@Id val excST2AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcST2AEvent(@Id val excST2AId: UUID? = null )

// multiple association events


// ExcST3A Events

data class CreateExcST3AEvent(
     var excST3AId: UUID? = null
)

data class UpdateExcST3AEvent(
    @Id var excST3AId: UUID? = null,
    var efdmax: PU,
    var kc: PU,
    var kg: PU,
    var ki: PU,
    var kj: PU,
    var km: PU,
    var kp: PU,
    var ks: PU,
    var ks1: PU,
    var tb: Seconds,
    var tc: Seconds,
    var thetap: AngleDegrees,
    var tm: Seconds,
    var vbmax: PU,
    var vgmax: PU,
    var vimax: PU,
    var vimin: PU,
    var vrmax: PU,
    var vrmin: PU,
    var xl: PU
)

data class DeleteExcST3AEvent(@Id val excST3AId: UUID? = null)

// single association events
data class AssignEfdmaxToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignEfdmaxFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignKcToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignKcFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignKgToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignKgFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignKiToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignKiFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignKjToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignKjFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignKmToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignKmFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignKpToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignKpFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignKsToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignKsFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignKs1ToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignKs1FromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignTbToExcST3AEvent(@Id val excST3AId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignTcToExcST3AEvent(@Id val excST3AId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignThetapToExcST3AEvent(@Id val excST3AId: UUID, val assignment: AngleDegrees )
data class UnAssignThetapFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignTmToExcST3AEvent(@Id val excST3AId: UUID, val assignment: Seconds )
data class UnAssignTmFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignVbmaxToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignVbmaxFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignVgmaxToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignVgmaxFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignVimaxToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignViminToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignViminFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignVrmaxToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignVrminToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignVrminFromExcST3AEvent(@Id val excST3AId: UUID? = null )
data class AssignXlToExcST3AEvent(@Id val excST3AId: UUID, val assignment: PU )
data class UnAssignXlFromExcST3AEvent(@Id val excST3AId: UUID? = null )

// multiple association events


// ExcST4B Events

data class CreateExcST4BEvent(
     var excST4BId: UUID? = null
)

data class UpdateExcST4BEvent(
    @Id var excST4BId: UUID? = null,
    var kc: PU,
    var kg: PU,
    var ki: PU,
    var kim: PU,
    var kir: PU,
    var kp: PU,
    var kpm: PU,
    var kpr: PU,
    var lvgate: BooleanProxy,
    var ta: Seconds,
    var thetap: AngleDegrees,
    var uel: BooleanProxy,
    var vbmax: PU,
    var vgmax: PU,
    var vmmax: PU,
    var vmmin: PU,
    var vrmax: PU,
    var vrmin: PU,
    var xl: PU
)

data class DeleteExcST4BEvent(@Id val excST4BId: UUID? = null)

// single association events
data class AssignKcToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignKcFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignKgToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignKgFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignKiToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignKiFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignKimToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignKimFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignKirToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignKirFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignKpToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignKpFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignKpmToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignKpmFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignKprToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignKprFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignLvgateToExcST4BEvent(@Id val excST4BId: UUID, val assignment: BooleanProxy )
data class UnAssignLvgateFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignTaToExcST4BEvent(@Id val excST4BId: UUID, val assignment: Seconds )
data class UnAssignTaFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignThetapToExcST4BEvent(@Id val excST4BId: UUID, val assignment: AngleDegrees )
data class UnAssignThetapFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignUelToExcST4BEvent(@Id val excST4BId: UUID, val assignment: BooleanProxy )
data class UnAssignUelFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignVbmaxToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignVbmaxFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignVgmaxToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignVgmaxFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignVmmaxToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignVmmaxFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignVmminToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignVmminFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignVrmaxToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignVrminToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcST4BEvent(@Id val excST4BId: UUID? = null )
data class AssignXlToExcST4BEvent(@Id val excST4BId: UUID, val assignment: PU )
data class UnAssignXlFromExcST4BEvent(@Id val excST4BId: UUID? = null )

// multiple association events


// ExcST6B Events

data class CreateExcST6BEvent(
    @Id var excST6BId: UUID? = null,
    @Enumerated(EnumType.STRING) var oelin: ExcST6BOELselectorKind
)

data class UpdateExcST6BEvent(
    @Id var excST6BId: UUID? = null,
    var ilr: PU,
    var k1: BooleanProxy,
    var kcl: PU,
    var kff: PU,
    var kg: PU,
    var kia: PU,
    var klr: PU,
    var km: PU,
    var kpa: PU,
    var kvd: PU,
    @Enumerated(EnumType.STRING) var oelin: ExcST6BOELselectorKind,
    var tg: Seconds,
    var ts: Seconds,
    var tvd: Seconds,
    var vamax: PU,
    var vamin: PU,
    var vilim: BooleanProxy,
    var vimax: PU,
    var vimin: PU,
    var vmult: BooleanProxy,
    var vrmax: PU,
    var vrmin: PU,
    var xc: PU
)

data class DeleteExcST6BEvent(@Id val excST6BId: UUID? = null)

// single association events
data class AssignIlrToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignIlrFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignK1ToExcST6BEvent(@Id val excST6BId: UUID, val assignment: BooleanProxy )
data class UnAssignK1FromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignKclToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignKclFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignKffToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignKffFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignKgToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignKgFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignKiaToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignKiaFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignKlrToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignKlrFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignKmToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignKmFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignKpaToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignKpaFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignKvdToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignKvdFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignTgToExcST6BEvent(@Id val excST6BId: UUID, val assignment: Seconds )
data class UnAssignTgFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignTsToExcST6BEvent(@Id val excST6BId: UUID, val assignment: Seconds )
data class UnAssignTsFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignTvdToExcST6BEvent(@Id val excST6BId: UUID, val assignment: Seconds )
data class UnAssignTvdFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignVamaxToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignVamaxFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignVaminToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignVaminFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignVilimToExcST6BEvent(@Id val excST6BId: UUID, val assignment: BooleanProxy )
data class UnAssignVilimFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignVimaxToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignVimaxFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignViminToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignViminFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignVmultToExcST6BEvent(@Id val excST6BId: UUID, val assignment: BooleanProxy )
data class UnAssignVmultFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignVrmaxToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignVrminToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcST6BEvent(@Id val excST6BId: UUID? = null )
data class AssignXcToExcST6BEvent(@Id val excST6BId: UUID, val assignment: PU )
data class UnAssignXcFromExcST6BEvent(@Id val excST6BId: UUID? = null )

// multiple association events


// ExcST7B Events

data class CreateExcST7BEvent(
    @Id var excST7BId: UUID? = null,
    @Enumerated(EnumType.STRING) var oelin: ExcST7BOELselectorKind,
    @Enumerated(EnumType.STRING) var uelin: ExcST7BUELselectorKind
)

data class UpdateExcST7BEvent(
    @Id var excST7BId: UUID? = null,
    var kh: PU,
    var kia: PU,
    var kl: PU,
    var kpa: PU,
    @Enumerated(EnumType.STRING) var oelin: ExcST7BOELselectorKind,
    var tb: Seconds,
    var tc: Seconds,
    var tf: Seconds,
    var tg: Seconds,
    var tia: Seconds,
    var ts: Seconds,
    @Enumerated(EnumType.STRING) var uelin: ExcST7BUELselectorKind,
    var vmax: PU,
    var vmin: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeleteExcST7BEvent(@Id val excST7BId: UUID? = null)

// single association events
data class AssignKhToExcST7BEvent(@Id val excST7BId: UUID, val assignment: PU )
data class UnAssignKhFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignKiaToExcST7BEvent(@Id val excST7BId: UUID, val assignment: PU )
data class UnAssignKiaFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignKlToExcST7BEvent(@Id val excST7BId: UUID, val assignment: PU )
data class UnAssignKlFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignKpaToExcST7BEvent(@Id val excST7BId: UUID, val assignment: PU )
data class UnAssignKpaFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignTbToExcST7BEvent(@Id val excST7BId: UUID, val assignment: Seconds )
data class UnAssignTbFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignTcToExcST7BEvent(@Id val excST7BId: UUID, val assignment: Seconds )
data class UnAssignTcFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignTfToExcST7BEvent(@Id val excST7BId: UUID, val assignment: Seconds )
data class UnAssignTfFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignTgToExcST7BEvent(@Id val excST7BId: UUID, val assignment: Seconds )
data class UnAssignTgFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignTiaToExcST7BEvent(@Id val excST7BId: UUID, val assignment: Seconds )
data class UnAssignTiaFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignTsToExcST7BEvent(@Id val excST7BId: UUID, val assignment: Seconds )
data class UnAssignTsFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignVmaxToExcST7BEvent(@Id val excST7BId: UUID, val assignment: PU )
data class UnAssignVmaxFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignVminToExcST7BEvent(@Id val excST7BId: UUID, val assignment: PU )
data class UnAssignVminFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignVrmaxToExcST7BEvent(@Id val excST7BId: UUID, val assignment: PU )
data class UnAssignVrmaxFromExcST7BEvent(@Id val excST7BId: UUID? = null )
data class AssignVrminToExcST7BEvent(@Id val excST7BId: UUID, val assignment: PU )
data class UnAssignVrminFromExcST7BEvent(@Id val excST7BId: UUID? = null )

// multiple association events


// ExcitationSystemDynamics Events

data class CreateExcitationSystemDynamicsEvent(
     var excitationSystemDynamicsId: UUID? = null
)

data class UpdateExcitationSystemDynamicsEvent(
    @Id var excitationSystemDynamicsId: UUID? = null,
    var excitationSystemDynamics: ExcitationSystemDynamics
)

data class DeleteExcitationSystemDynamicsEvent(@Id val excitationSystemDynamicsId: UUID? = null)

// single association events
data class AssignExcitationSystemDynamicsToExcitationSystemDynamicsEvent(@Id val excitationSystemDynamicsId: UUID, val assignment: ExcitationSystemDynamics )
data class UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsEvent(@Id val excitationSystemDynamicsId: UUID? = null )

// multiple association events


// ExcitationSystemUserDefined Events

data class CreateExcitationSystemUserDefinedEvent(
     var excitationSystemUserDefinedId: UUID? = null
)

data class UpdateExcitationSystemUserDefinedEvent(
    @Id var excitationSystemUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteExcitationSystemUserDefinedEvent(@Id val excitationSystemUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToExcitationSystemUserDefinedEvent(@Id val excitationSystemUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromExcitationSystemUserDefinedEvent(@Id val excitationSystemUserDefinedId: UUID? = null )

// multiple association events


// ExtensionVersion Events

data class CreateExtensionVersionEvent(
     var extensionVersionId: UUID? = null
)

data class UpdateExtensionVersionEvent(
    @Id var extensionVersionId: UUID? = null,
    var date: DateProxy,
    var namespaceURI: StringProxy
)

data class DeleteExtensionVersionEvent(@Id val extensionVersionId: UUID? = null)

// single association events
data class AssignDateToExtensionVersionEvent(@Id val extensionVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromExtensionVersionEvent(@Id val extensionVersionId: UUID? = null )
data class AssignNamespaceURIToExtensionVersionEvent(@Id val extensionVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceURIFromExtensionVersionEvent(@Id val extensionVersionId: UUID? = null )

// multiple association events


// ExternalNetworkInjection Events

data class CreateExternalNetworkInjectionEvent(
     var externalNetworkInjectionId: UUID? = null
)

data class UpdateExternalNetworkInjectionEvent(
    @Id var externalNetworkInjectionId: UUID? = null,
    var governorSCD: ActivePowerPerFrequency,
    var ikSecond: BooleanProxy,
    var maxInitialSymShCCurrent: CurrentFlow,
    var maxP: ActivePower,
    var maxQ: ReactivePower,
    var maxR0ToX0Ratio: Simple_Float,
    var maxR1ToX1Ratio: Simple_Float,
    var maxZ0ToZ1Ratio: Simple_Float,
    var minInitialSymShCCurrent: CurrentFlow,
    var minP: ActivePower,
    var minQ: ReactivePower,
    var minR0ToX0Ratio: Simple_Float,
    var minR1ToX1Ratio: Simple_Float,
    var minZ0ToZ1Ratio: Simple_Float,
    var voltageFactor: PU
)

data class DeleteExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null)

// single association events
data class AssignGovernorSCDToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: ActivePowerPerFrequency )
data class UnAssignGovernorSCDFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignIkSecondToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: BooleanProxy )
data class UnAssignIkSecondFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMaxInitialSymShCCurrentToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: CurrentFlow )
data class UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMaxPToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: ActivePower )
data class UnAssignMaxPFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMaxQToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: ReactivePower )
data class UnAssignMaxQFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMaxR0ToX0RatioToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: Simple_Float )
data class UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMaxR1ToX1RatioToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: Simple_Float )
data class UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMaxZ0ToZ1RatioToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: Simple_Float )
data class UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMinInitialSymShCCurrentToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: CurrentFlow )
data class UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMinPToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: ActivePower )
data class UnAssignMinPFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMinQToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: ReactivePower )
data class UnAssignMinQFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMinR0ToX0RatioToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: Simple_Float )
data class UnAssignMinR0ToX0RatioFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMinR1ToX1RatioToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: Simple_Float )
data class UnAssignMinR1ToX1RatioFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignMinZ0ToZ1RatioToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: Simple_Float )
data class UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )
data class AssignVoltageFactorToExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID, val assignment: PU )
data class UnAssignVoltageFactorFromExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null )

// multiple association events


// FloatProxy Events

data class CreateFloatProxyEvent(
     var floatProxyId: UUID? = null
)

data class UpdateFloatProxyEvent(
     var floatProxyId: UUID? = null
)

data class DeleteFloatProxyEvent(@Id val floatProxyId: UUID? = null)

// single association events

// multiple association events


// FossilFuel Events

data class CreateFossilFuelEvent(
    @Id var fossilFuelId: UUID? = null,
    @Enumerated(EnumType.STRING) var fossilFuelType: FuelType
)

data class UpdateFossilFuelEvent(
    @Id var fossilFuelId: UUID? = null,
    @Enumerated(EnumType.STRING) var fossilFuelType: FuelType,
    var fossilFuels:  Set<FossilFuel>
)

data class DeleteFossilFuelEvent(@Id val fossilFuelId: UUID? = null)

// single association events

// multiple association events
data class AssignFossilFuelsToFossilFuelEvent(@Id val fossilFuelId: UUID, val addTo: FossilFuel )
data class RemoveFossilFuelsFromFossilFuelEvent(@Id val fossilFuelId: UUID, val removeFrom: FossilFuel )


// Frequency Events

data class CreateFrequencyEvent(
    @Id var frequencyId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateFrequencyEvent(
    @Id var frequencyId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteFrequencyEvent(@Id val frequencyId: UUID? = null)

// single association events
data class AssignValueToFrequencyEvent(@Id val frequencyId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromFrequencyEvent(@Id val frequencyId: UUID? = null )

// multiple association events


// GenICompensationForGenJ Events

data class CreateGenICompensationForGenJEvent(
     var genICompensationForGenJId: UUID? = null
)

data class UpdateGenICompensationForGenJEvent(
    @Id var genICompensationForGenJId: UUID? = null,
    var rcij: PU,
    var xcij: PU,
    var genICompensationForGenJ:  Set<GenICompensationForGenJ>
)

data class DeleteGenICompensationForGenJEvent(@Id val genICompensationForGenJId: UUID? = null)

// single association events
data class AssignRcijToGenICompensationForGenJEvent(@Id val genICompensationForGenJId: UUID, val assignment: PU )
data class UnAssignRcijFromGenICompensationForGenJEvent(@Id val genICompensationForGenJId: UUID? = null )
data class AssignXcijToGenICompensationForGenJEvent(@Id val genICompensationForGenJId: UUID, val assignment: PU )
data class UnAssignXcijFromGenICompensationForGenJEvent(@Id val genICompensationForGenJId: UUID? = null )

// multiple association events
data class AssignGenICompensationForGenJToGenICompensationForGenJEvent(@Id val genICompensationForGenJId: UUID, val addTo: GenICompensationForGenJ )
data class RemoveGenICompensationForGenJFromGenICompensationForGenJEvent(@Id val genICompensationForGenJId: UUID, val removeFrom: GenICompensationForGenJ )


// GeneratingUnit Events

data class CreateGeneratingUnitEvent(
    @Id var generatingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var genControlSource: GeneratorControlSource
)

data class UpdateGeneratingUnitEvent(
    @Id var generatingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var genControlSource: GeneratorControlSource,
    var governorSCD: PerCent,
    var initialP: ActivePower,
    var longPF: Simple_Float,
    var maximumAllowableSpinningReserve: ActivePower,
    var maxOperatingP: ActivePower,
    var minOperatingP: ActivePower,
    var nominalP: ActivePower,
    var ratedGrossMaxP: ActivePower,
    var ratedGrossMinP: ActivePower,
    var ratedNetMaxP: ActivePower,
    var shortPF: Simple_Float,
    var startupCost: Money,
    var totalEfficiency: PerCent,
    var variableCost: Money
)

data class DeleteGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null)

// single association events
data class AssignGovernorSCDToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: PerCent )
data class UnAssignGovernorSCDFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignInitialPToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: ActivePower )
data class UnAssignInitialPFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignLongPFToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: Simple_Float )
data class UnAssignLongPFFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignMaximumAllowableSpinningReserveToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: ActivePower )
data class UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignMaxOperatingPToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: ActivePower )
data class UnAssignMaxOperatingPFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignMinOperatingPToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: ActivePower )
data class UnAssignMinOperatingPFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignNominalPToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: ActivePower )
data class UnAssignNominalPFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignRatedGrossMaxPToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: ActivePower )
data class UnAssignRatedGrossMaxPFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignRatedGrossMinPToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: ActivePower )
data class UnAssignRatedGrossMinPFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignRatedNetMaxPToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: ActivePower )
data class UnAssignRatedNetMaxPFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignShortPFToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: Simple_Float )
data class UnAssignShortPFFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignStartupCostToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: Money )
data class UnAssignStartupCostFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignTotalEfficiencyToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: PerCent )
data class UnAssignTotalEfficiencyFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )
data class AssignVariableCostToGeneratingUnitEvent(@Id val generatingUnitId: UUID, val assignment: Money )
data class UnAssignVariableCostFromGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null )

// multiple association events


// GeographicalLocationVersion Events

data class CreateGeographicalLocationVersionEvent(
     var geographicalLocationVersionId: UUID? = null
)

data class UpdateGeographicalLocationVersionEvent(
    @Id var geographicalLocationVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURI: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURI: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignBaseURIToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignDateToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignDifferenceModelURIToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignEntsoeUMLToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignEntsoeURIToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignModelDescriptionURIToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignNamespaceRDFToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignNamespaceUMLToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )
data class AssignShortNameToGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null )

// multiple association events


// GeographicalRegion Events

data class CreateGeographicalRegionEvent(
     var geographicalRegionId: UUID? = null
)

data class UpdateGeographicalRegionEvent(
     var geographicalRegionId: UUID? = null
)

data class DeleteGeographicalRegionEvent(@Id val geographicalRegionId: UUID? = null)

// single association events

// multiple association events


// GovCT1 Events

data class CreateGovCT1Event(
    @Id var govCT1Id: UUID? = null,
    @Enumerated(EnumType.STRING) var rselect: DroopSignalFeedbackKind
)

data class UpdateGovCT1Event(
    @Id var govCT1Id: UUID? = null,
    var aset: Simple_Float,
    var db: PU,
    var dm: PU,
    var ka: PU,
    var kdgov: PU,
    var kigov: PU,
    var kiload: PU,
    var kimw: PU,
    var kpgov: PU,
    var kpload: PU,
    var kturb: PU,
    var ldref: PU,
    var maxerr: PU,
    var minerr: PU,
    var mwbase: ActivePower,
    var r: PU,
    var rclose: Simple_Float,
    var rdown: PU,
    var ropen: Simple_Float,
    @Enumerated(EnumType.STRING) var rselect: DroopSignalFeedbackKind,
    var rup: PU,
    var ta: Seconds,
    var tact: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var tdgov: Seconds,
    var teng: Seconds,
    var tfload: Seconds,
    var tpelec: Seconds,
    var tsa: Seconds,
    var tsb: Seconds,
    var vmax: PU,
    var vmin: PU,
    var wfnl: PU,
    var wfspd: BooleanProxy
)

data class DeleteGovCT1Event(@Id val govCT1Id: UUID? = null)

// single association events
data class AssignAsetToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Simple_Float )
data class UnAssignAsetFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignDbToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignDbFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignDmToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignDmFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignKaToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignKaFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignKdgovToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignKdgovFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignKigovToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignKigovFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignKiloadToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignKiloadFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignKimwToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignKimwFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignKpgovToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignKpgovFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignKploadToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignKploadFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignKturbToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignKturbFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignLdrefToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignLdrefFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignMaxerrToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignMaxerrFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignMinerrToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignMinerrFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignMwbaseToGovCT1Event(@Id val govCT1Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignRToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignRFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignRcloseToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Simple_Float )
data class UnAssignRcloseFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignRdownToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignRdownFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignRopenToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Simple_Float )
data class UnAssignRopenFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignRupToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignRupFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTaToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTaFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTactToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTactFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTbToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTbFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTcToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTcFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTdgovToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTdgovFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTengToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTengFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTfloadToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTfloadFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTpelecToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTpelecFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTsaToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTsaFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignTsbToGovCT1Event(@Id val govCT1Id: UUID, val assignment: Seconds )
data class UnAssignTsbFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignVmaxToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignVmaxFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignVminToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignVminFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignWfnlToGovCT1Event(@Id val govCT1Id: UUID, val assignment: PU )
data class UnAssignWfnlFromGovCT1Event(@Id val govCT1Id: UUID? = null )
data class AssignWfspdToGovCT1Event(@Id val govCT1Id: UUID, val assignment: BooleanProxy )
data class UnAssignWfspdFromGovCT1Event(@Id val govCT1Id: UUID? = null )

// multiple association events


// GovCT2 Events

data class CreateGovCT2Event(
    @Id var govCT2Id: UUID? = null,
    @Enumerated(EnumType.STRING) var rselect: DroopSignalFeedbackKind
)

data class UpdateGovCT2Event(
    @Id var govCT2Id: UUID? = null,
    var aset: Simple_Float,
    var db: PU,
    var dm: PU,
    var flim1: Frequency,
    var flim10: Frequency,
    var flim2: Frequency,
    var flim3: Frequency,
    var flim4: Frequency,
    var flim5: Frequency,
    var flim6: Frequency,
    var flim7: Frequency,
    var flim8: Frequency,
    var flim9: Frequency,
    var ka: PU,
    var kdgov: PU,
    var kigov: PU,
    var kiload: PU,
    var kimw: PU,
    var kpgov: PU,
    var kpload: PU,
    var kturb: PU,
    var ldref: PU,
    var maxerr: PU,
    var minerr: PU,
    var mwbase: ActivePower,
    var plim1: PU,
    var plim10: PU,
    var plim2: PU,
    var plim3: PU,
    var plim4: PU,
    var plim5: PU,
    var plim6: PU,
    var plim7: PU,
    var plim8: PU,
    var plim9: PU,
    var prate: PU,
    var r: PU,
    var rclose: Simple_Float,
    var rdown: PU,
    var ropen: Simple_Float,
    @Enumerated(EnumType.STRING) var rselect: DroopSignalFeedbackKind,
    var rup: PU,
    var ta: Seconds,
    var tact: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var tdgov: Seconds,
    var teng: Seconds,
    var tfload: Seconds,
    var tpelec: Seconds,
    var tsa: Seconds,
    var tsb: Seconds,
    var vmax: PU,
    var vmin: PU,
    var wfnl: PU,
    var wfspd: BooleanProxy
)

data class DeleteGovCT2Event(@Id val govCT2Id: UUID? = null)

// single association events
data class AssignAsetToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Simple_Float )
data class UnAssignAsetFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignDbToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignDbFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignDmToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignDmFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim1ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim1FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim10ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim10FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim2ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim2FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim3ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim3FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim4ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim4FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim5ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim5FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim6ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim6FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim7ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim7FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim8ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim8FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignFlim9ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Frequency )
data class UnAssignFlim9FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignKaToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignKaFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignKdgovToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignKdgovFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignKigovToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignKigovFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignKiloadToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignKiloadFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignKimwToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignKimwFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignKpgovToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignKpgovFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignKploadToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignKploadFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignKturbToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignKturbFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignLdrefToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignLdrefFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignMaxerrToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignMaxerrFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignMinerrToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignMinerrFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignMwbaseToGovCT2Event(@Id val govCT2Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim1ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim1FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim10ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim10FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim2ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim2FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim3ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim3FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim4ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim4FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim5ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim5FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim6ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim6FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim7ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim7FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim8ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim8FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPlim9ToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPlim9FromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignPrateToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignPrateFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignRToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignRFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignRcloseToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Simple_Float )
data class UnAssignRcloseFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignRdownToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignRdownFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignRopenToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Simple_Float )
data class UnAssignRopenFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignRupToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignRupFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTaToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTaFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTactToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTactFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTbToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTbFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTcToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTcFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTdgovToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTdgovFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTengToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTengFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTfloadToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTfloadFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTpelecToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTpelecFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTsaToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTsaFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignTsbToGovCT2Event(@Id val govCT2Id: UUID, val assignment: Seconds )
data class UnAssignTsbFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignVmaxToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignVmaxFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignVminToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignVminFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignWfnlToGovCT2Event(@Id val govCT2Id: UUID, val assignment: PU )
data class UnAssignWfnlFromGovCT2Event(@Id val govCT2Id: UUID? = null )
data class AssignWfspdToGovCT2Event(@Id val govCT2Id: UUID, val assignment: BooleanProxy )
data class UnAssignWfspdFromGovCT2Event(@Id val govCT2Id: UUID? = null )

// multiple association events


// GovGAST Events

data class CreateGovGASTEvent(
     var govGASTId: UUID? = null
)

data class UpdateGovGASTEvent(
    @Id var govGASTId: UUID? = null,
    var at: PU,
    var dturb: PU,
    var kt: PU,
    var mwbase: ActivePower,
    var r: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var vmax: PU,
    var vmin: PU
)

data class DeleteGovGASTEvent(@Id val govGASTId: UUID? = null)

// single association events
data class AssignAtToGovGASTEvent(@Id val govGASTId: UUID, val assignment: PU )
data class UnAssignAtFromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignDturbToGovGASTEvent(@Id val govGASTId: UUID, val assignment: PU )
data class UnAssignDturbFromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignKtToGovGASTEvent(@Id val govGASTId: UUID, val assignment: PU )
data class UnAssignKtFromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignMwbaseToGovGASTEvent(@Id val govGASTId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignRToGovGASTEvent(@Id val govGASTId: UUID, val assignment: PU )
data class UnAssignRFromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignT1ToGovGASTEvent(@Id val govGASTId: UUID, val assignment: Seconds )
data class UnAssignT1FromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignT2ToGovGASTEvent(@Id val govGASTId: UUID, val assignment: Seconds )
data class UnAssignT2FromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignT3ToGovGASTEvent(@Id val govGASTId: UUID, val assignment: Seconds )
data class UnAssignT3FromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignVmaxToGovGASTEvent(@Id val govGASTId: UUID, val assignment: PU )
data class UnAssignVmaxFromGovGASTEvent(@Id val govGASTId: UUID? = null )
data class AssignVminToGovGASTEvent(@Id val govGASTId: UUID, val assignment: PU )
data class UnAssignVminFromGovGASTEvent(@Id val govGASTId: UUID? = null )

// multiple association events


// GovGAST1 Events

data class CreateGovGAST1Event(
     var govGAST1Id: UUID? = null
)

data class UpdateGovGAST1Event(
    @Id var govGAST1Id: UUID? = null,
    var a: Simple_Float,
    var b: Simple_Float,
    var db1: Frequency,
    var db2: ActivePower,
    var eps: Frequency,
    var fidle: PU,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var gv6: PU,
    var ka: PU,
    var kt: PU,
    var lmax: PU,
    var loadinc: PU,
    var ltrate: Simple_Float,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var pgv6: PU,
    var r: PU,
    var rmax: Simple_Float,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var tltr: Seconds,
    var vmax: PU,
    var vmin: PU
)

data class DeleteGovGAST1Event(@Id val govGAST1Id: UUID? = null)

// single association events
data class AssignAToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Simple_Float )
data class UnAssignAFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignBToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Simple_Float )
data class UnAssignBFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignDb1ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignDb2ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: ActivePower )
data class UnAssignDb2FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignEpsToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Frequency )
data class UnAssignEpsFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignFidleToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignFidleFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignGv1ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignGv1FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignGv2ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignGv2FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignGv3ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignGv3FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignGv4ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignGv4FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignGv5ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignGv5FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignGv6ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignGv6FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignKaToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignKaFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignKtToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignKtFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignLmaxToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignLmaxFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignLoadincToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignLoadincFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignLtrateToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Simple_Float )
data class UnAssignLtrateFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignMwbaseToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignPgv1ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignPgv1FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignPgv2ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignPgv2FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignPgv3ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignPgv3FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignPgv4ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignPgv4FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignPgv5ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignPgv5FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignPgv6ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignPgv6FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignRToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignRFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignRmaxToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Simple_Float )
data class UnAssignRmaxFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignT1ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Seconds )
data class UnAssignT1FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignT2ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Seconds )
data class UnAssignT2FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignT3ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Seconds )
data class UnAssignT3FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignT4ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Seconds )
data class UnAssignT4FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignT5ToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Seconds )
data class UnAssignT5FromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignTltrToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: Seconds )
data class UnAssignTltrFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignVmaxToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignVmaxFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )
data class AssignVminToGovGAST1Event(@Id val govGAST1Id: UUID, val assignment: PU )
data class UnAssignVminFromGovGAST1Event(@Id val govGAST1Id: UUID? = null )

// multiple association events


// GovGAST2 Events

data class CreateGovGAST2Event(
     var govGAST2Id: UUID? = null
)

data class UpdateGovGAST2Event(
    @Id var govGAST2Id: UUID? = null,
    var a: Simple_Float,
    var af1: PU,
    var af2: PU,
    var b: Simple_Float,
    var bf1: PU,
    var bf2: PU,
    var c: Simple_Float,
    var cf2: PU,
    var ecr: Seconds,
    var etd: Seconds,
    var k3: PU,
    var k4: PU,
    var k5: PU,
    var k6: PU,
    var kf: PU,
    var mwbase: ActivePower,
    var t: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var tc: Temperature,
    var tcd: Seconds,
    var tf: Seconds,
    var tmax: PU,
    var tmin: PU,
    var tr: Temperature,
    var trate: ActivePower,
    var tt: Seconds,
    var w: PU,
    var x: Seconds,
    var y: Seconds,
    var z: BooleanProxy
)

data class DeleteGovGAST2Event(@Id val govGAST2Id: UUID? = null)

// single association events
data class AssignAToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Simple_Float )
data class UnAssignAFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignAf1ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignAf1FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignAf2ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignAf2FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignBToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Simple_Float )
data class UnAssignBFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignBf1ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignBf1FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignBf2ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignBf2FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignCToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Simple_Float )
data class UnAssignCFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignCf2ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignCf2FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignEcrToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignEcrFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignEtdToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignEtdFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignK3ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignK3FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignK4ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignK4FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignK5ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignK5FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignK6ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignK6FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignKfToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignKfFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignMwbaseToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignTFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignT3ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignT3FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignT4ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignT4FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignT5ToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignT5FromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTcToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Temperature )
data class UnAssignTcFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTcdToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignTcdFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTfToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignTfFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTmaxToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignTmaxFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTminToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignTminFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTrToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Temperature )
data class UnAssignTrFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTrateToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: ActivePower )
data class UnAssignTrateFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignTtToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignTtFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignWToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: PU )
data class UnAssignWFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignXToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignXFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignYToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: Seconds )
data class UnAssignYFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )
data class AssignZToGovGAST2Event(@Id val govGAST2Id: UUID, val assignment: BooleanProxy )
data class UnAssignZFromGovGAST2Event(@Id val govGAST2Id: UUID? = null )

// multiple association events


// GovGAST3 Events

data class CreateGovGAST3Event(
     var govGAST3Id: UUID? = null
)

data class UpdateGovGAST3Event(
    @Id var govGAST3Id: UUID? = null,
    var bca: Simple_Float,
    var bp: PU,
    var dtc: Temperature,
    var ka: PU,
    var kac: Simple_Float,
    var kca: Simple_Float,
    var ksi: Simple_Float,
    var ky: Simple_Float,
    var mnef: PU,
    var mxef: PU,
    var rcmn: PU,
    var rcmx: PU,
    var tac: Seconds,
    var tc: Seconds,
    var td: Seconds,
    var tfen: Temperature,
    var tg: Seconds,
    var tsi: Seconds,
    var tt: Temperature,
    var ttc: Seconds,
    var ty: Seconds
)

data class DeleteGovGAST3Event(@Id val govGAST3Id: UUID? = null)

// single association events
data class AssignBcaToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Simple_Float )
data class UnAssignBcaFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignBpToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: PU )
data class UnAssignBpFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignDtcToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Temperature )
data class UnAssignDtcFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignKaToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: PU )
data class UnAssignKaFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignKacToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Simple_Float )
data class UnAssignKacFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignKcaToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Simple_Float )
data class UnAssignKcaFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignKsiToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Simple_Float )
data class UnAssignKsiFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignKyToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Simple_Float )
data class UnAssignKyFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignMnefToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: PU )
data class UnAssignMnefFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignMxefToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: PU )
data class UnAssignMxefFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignRcmnToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: PU )
data class UnAssignRcmnFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignRcmxToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: PU )
data class UnAssignRcmxFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTacToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Seconds )
data class UnAssignTacFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTcToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Seconds )
data class UnAssignTcFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTdToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Seconds )
data class UnAssignTdFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTfenToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Temperature )
data class UnAssignTfenFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTgToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Seconds )
data class UnAssignTgFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTsiToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Seconds )
data class UnAssignTsiFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTtToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Temperature )
data class UnAssignTtFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTtcToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Seconds )
data class UnAssignTtcFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )
data class AssignTyToGovGAST3Event(@Id val govGAST3Id: UUID, val assignment: Seconds )
data class UnAssignTyFromGovGAST3Event(@Id val govGAST3Id: UUID? = null )

// multiple association events


// GovGAST4 Events

data class CreateGovGAST4Event(
     var govGAST4Id: UUID? = null
)

data class UpdateGovGAST4Event(
    @Id var govGAST4Id: UUID? = null,
    var bp: PU,
    var ktm: PU,
    var mnef: PU,
    var mxef: PU,
    var rymn: PU,
    var rymx: PU,
    var ta: Seconds,
    var tc: Seconds,
    var tcm: Seconds,
    var tm: Seconds,
    var tv: Seconds
)

data class DeleteGovGAST4Event(@Id val govGAST4Id: UUID? = null)

// single association events
data class AssignBpToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: PU )
data class UnAssignBpFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignKtmToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: PU )
data class UnAssignKtmFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignMnefToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: PU )
data class UnAssignMnefFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignMxefToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: PU )
data class UnAssignMxefFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignRymnToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: PU )
data class UnAssignRymnFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignRymxToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: PU )
data class UnAssignRymxFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignTaToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: Seconds )
data class UnAssignTaFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignTcToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: Seconds )
data class UnAssignTcFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignTcmToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: Seconds )
data class UnAssignTcmFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignTmToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: Seconds )
data class UnAssignTmFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )
data class AssignTvToGovGAST4Event(@Id val govGAST4Id: UUID, val assignment: Seconds )
data class UnAssignTvFromGovGAST4Event(@Id val govGAST4Id: UUID? = null )

// multiple association events


// GovGASTWD Events

data class CreateGovGASTWDEvent(
     var govGASTWDId: UUID? = null
)

data class UpdateGovGASTWDEvent(
    @Id var govGASTWDId: UUID? = null,
    var a: Simple_Float,
    var af1: PU,
    var af2: PU,
    var b: Simple_Float,
    var bf1: PU,
    var bf2: PU,
    var c: Simple_Float,
    var cf2: PU,
    var ecr: Seconds,
    var etd: Seconds,
    var k3: PU,
    var k4: PU,
    var k5: PU,
    var k6: PU,
    var kd: PU,
    var kdroop: PU,
    var kf: PU,
    var ki: PU,
    var kp: PU,
    var mwbase: ActivePower,
    var t: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var tc: Temperature,
    var tcd: Seconds,
    var td: Seconds,
    var tf: Seconds,
    var tmax: PU,
    var tmin: PU,
    var tr: Temperature,
    var trate: ActivePower,
    var tt: Seconds
)

data class DeleteGovGASTWDEvent(@Id val govGASTWDId: UUID? = null)

// single association events
data class AssignAToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Simple_Float )
data class UnAssignAFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignAf1ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignAf1FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignAf2ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignAf2FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignBToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Simple_Float )
data class UnAssignBFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignBf1ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignBf1FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignBf2ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignBf2FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignCToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Simple_Float )
data class UnAssignCFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignCf2ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignCf2FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignEcrToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignEcrFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignEtdToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignEtdFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignK3ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignK3FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignK4ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignK4FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignK5ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignK5FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignK6ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignK6FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignKdToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignKdFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignKdroopToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignKdroopFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignKfToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignKfFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignKiToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignKiFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignKpToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignKpFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignMwbaseToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignTFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignT3ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignT3FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignT4ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignT4FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignT5ToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignT5FromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTcToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Temperature )
data class UnAssignTcFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTcdToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignTcdFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTdToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignTdFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTfToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignTfFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTmaxToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignTmaxFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTminToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: PU )
data class UnAssignTminFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTrToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Temperature )
data class UnAssignTrFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTrateToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: ActivePower )
data class UnAssignTrateFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )
data class AssignTtToGovGASTWDEvent(@Id val govGASTWDId: UUID, val assignment: Seconds )
data class UnAssignTtFromGovGASTWDEvent(@Id val govGASTWDId: UUID? = null )

// multiple association events


// GovHydro1 Events

data class CreateGovHydro1Event(
     var govHydro1Id: UUID? = null
)

data class UpdateGovHydro1Event(
    @Id var govHydro1Id: UUID? = null,
    var at: PU,
    var dturb: PU,
    var gmax: PU,
    var gmin: PU,
    var hdam: PU,
    var mwbase: ActivePower,
    var qnl: PU,
    var rperm: PU,
    var rtemp: PU,
    var tf: Seconds,
    var tg: Seconds,
    var tr: Seconds,
    var tw: Seconds,
    var velm: Simple_Float
)

data class DeleteGovHydro1Event(@Id val govHydro1Id: UUID? = null)

// single association events
data class AssignAtToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: PU )
data class UnAssignAtFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignDturbToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: PU )
data class UnAssignDturbFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignGmaxToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: PU )
data class UnAssignGmaxFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignGminToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: PU )
data class UnAssignGminFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignHdamToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: PU )
data class UnAssignHdamFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignMwbaseToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignQnlToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: PU )
data class UnAssignQnlFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignRpermToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: PU )
data class UnAssignRpermFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignRtempToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: PU )
data class UnAssignRtempFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignTfToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: Seconds )
data class UnAssignTfFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignTgToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: Seconds )
data class UnAssignTgFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignTrToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: Seconds )
data class UnAssignTrFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignTwToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )
data class AssignVelmToGovHydro1Event(@Id val govHydro1Id: UUID, val assignment: Simple_Float )
data class UnAssignVelmFromGovHydro1Event(@Id val govHydro1Id: UUID? = null )

// multiple association events


// GovHydro2 Events

data class CreateGovHydro2Event(
     var govHydro2Id: UUID? = null
)

data class UpdateGovHydro2Event(
    @Id var govHydro2Id: UUID? = null,
    var aturb: PU,
    var bturb: PU,
    var db1: Frequency,
    var db2: ActivePower,
    var eps: Frequency,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var gv6: PU,
    var kturb: PU,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var pgv6: PU,
    var pmax: PU,
    var pmin: PU,
    var rperm: PU,
    var rtemp: PU,
    var tg: Seconds,
    var tp: Seconds,
    var tr: Seconds,
    var tw: Seconds,
    var uc: Simple_Float,
    var uo: Simple_Float
)

data class DeleteGovHydro2Event(@Id val govHydro2Id: UUID? = null)

// single association events
data class AssignAturbToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignAturbFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignBturbToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignBturbFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignDb1ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignDb2ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: ActivePower )
data class UnAssignDb2FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignEpsToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: Frequency )
data class UnAssignEpsFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignGv1ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignGv2ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignGv3ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignGv4ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignGv4FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignGv5ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignGv5FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignGv6ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignGv6FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignKturbToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignKturbFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignMwbaseToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignPgv1ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignPgv1FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignPgv2ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignPgv2FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignPgv3ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignPgv3FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignPgv4ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignPgv4FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignPgv5ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignPgv5FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignPgv6ToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignPgv6FromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignPmaxToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignPmaxFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignPminToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignPminFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignRpermToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignRpermFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignRtempToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: PU )
data class UnAssignRtempFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignTgToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: Seconds )
data class UnAssignTgFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignTpToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: Seconds )
data class UnAssignTpFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignTrToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: Seconds )
data class UnAssignTrFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignTwToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignUcToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: Simple_Float )
data class UnAssignUcFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )
data class AssignUoToGovHydro2Event(@Id val govHydro2Id: UUID, val assignment: Simple_Float )
data class UnAssignUoFromGovHydro2Event(@Id val govHydro2Id: UUID? = null )

// multiple association events


// GovHydro3 Events

data class CreateGovHydro3Event(
     var govHydro3Id: UUID? = null
)

data class UpdateGovHydro3Event(
    @Id var govHydro3Id: UUID? = null,
    var at: PU,
    var db1: Frequency,
    var db2: ActivePower,
    var dturb: PU,
    var eps: Frequency,
    var governorControl: BooleanProxy,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var gv6: PU,
    var h0: PU,
    var k1: PU,
    var k2: PU,
    var kg: PU,
    var ki: PU,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var pgv6: PU,
    var pmax: PU,
    var pmin: PU,
    var qnl: PU,
    var relec: PU,
    var rgate: PU,
    var td: Seconds,
    var tf: Seconds,
    var tp: Seconds,
    var tt: Seconds,
    var tw: Seconds,
    var velcl: Simple_Float,
    var velop: Simple_Float
)

data class DeleteGovHydro3Event(@Id val govHydro3Id: UUID? = null)

// single association events
data class AssignAtToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignAtFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignDb1ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignDb2ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: ActivePower )
data class UnAssignDb2FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignDturbToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignDturbFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignEpsToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Frequency )
data class UnAssignEpsFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignGovernorControlToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: BooleanProxy )
data class UnAssignGovernorControlFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignGv1ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignGv2ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignGv3ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignGv4ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignGv4FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignGv5ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignGv5FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignGv6ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignGv6FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignH0ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignH0FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignK1ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignK1FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignK2ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignK2FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignKgToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignKgFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignKiToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignKiFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignMwbaseToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignPgv1ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignPgv1FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignPgv2ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignPgv2FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignPgv3ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignPgv3FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignPgv4ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignPgv4FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignPgv5ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignPgv5FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignPgv6ToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignPgv6FromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignPmaxToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignPmaxFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignPminToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignPminFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignQnlToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignQnlFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignRelecToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignRelecFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignRgateToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: PU )
data class UnAssignRgateFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignTdToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Seconds )
data class UnAssignTdFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignTfToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Seconds )
data class UnAssignTfFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignTpToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Seconds )
data class UnAssignTpFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignTtToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Seconds )
data class UnAssignTtFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignTwToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignVelclToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Simple_Float )
data class UnAssignVelclFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )
data class AssignVelopToGovHydro3Event(@Id val govHydro3Id: UUID, val assignment: Simple_Float )
data class UnAssignVelopFromGovHydro3Event(@Id val govHydro3Id: UUID? = null )

// multiple association events


// GovHydro4 Events

data class CreateGovHydro4Event(
     var govHydro4Id: UUID? = null
)

data class UpdateGovHydro4Event(
    @Id var govHydro4Id: UUID? = null,
    var at: PU,
    var bgv0: PU,
    var bgv1: PU,
    var bgv2: PU,
    var bgv3: PU,
    var bgv4: PU,
    var bgv5: PU,
    var bmax: Simple_Float,
    var db1: Frequency,
    var db2: ActivePower,
    var dturb: PU,
    var eps: Frequency,
    var gmax: PU,
    var gmin: PU,
    var gv0: PU,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var hdam: PU,
    var mwbase: ActivePower,
    var pgv0: PU,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var qn1: PU,
    var rperm: Seconds,
    var rtemp: Seconds,
    var tblade: Seconds,
    var tg: Seconds,
    var tp: Seconds,
    var tr: Seconds,
    var tw: Seconds,
    var uc: Simple_Float,
    var uo: Simple_Float
)

data class DeleteGovHydro4Event(@Id val govHydro4Id: UUID? = null)

// single association events
data class AssignAtToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignAtFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignBgv0ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignBgv0FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignBgv1ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignBgv1FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignBgv2ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignBgv2FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignBgv3ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignBgv3FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignBgv4ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignBgv4FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignBgv5ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignBgv5FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignBmaxToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Simple_Float )
data class UnAssignBmaxFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignDb1ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignDb2ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: ActivePower )
data class UnAssignDb2FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignDturbToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignDturbFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignEpsToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Frequency )
data class UnAssignEpsFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignGmaxToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignGmaxFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignGminToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignGminFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignGv0ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignGv0FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignGv1ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignGv2ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignGv3ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignGv4ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignGv4FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignGv5ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignGv5FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignHdamToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignHdamFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignMwbaseToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignPgv0ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignPgv0FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignPgv1ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignPgv1FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignPgv2ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignPgv2FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignPgv3ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignPgv3FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignPgv4ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignPgv4FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignPgv5ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignPgv5FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignQn1ToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: PU )
data class UnAssignQn1FromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignRpermToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Seconds )
data class UnAssignRpermFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignRtempToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Seconds )
data class UnAssignRtempFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignTbladeToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Seconds )
data class UnAssignTbladeFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignTgToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Seconds )
data class UnAssignTgFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignTpToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Seconds )
data class UnAssignTpFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignTrToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Seconds )
data class UnAssignTrFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignTwToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignUcToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Simple_Float )
data class UnAssignUcFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )
data class AssignUoToGovHydro4Event(@Id val govHydro4Id: UUID, val assignment: Simple_Float )
data class UnAssignUoFromGovHydro4Event(@Id val govHydro4Id: UUID? = null )

// multiple association events


// GovHydroDD Events

data class CreateGovHydroDDEvent(
     var govHydroDDId: UUID? = null
)

data class UpdateGovHydroDDEvent(
    @Id var govHydroDDId: UUID? = null,
    var aturb: PU,
    var bturb: PU,
    var db1: Frequency,
    var db2: ActivePower,
    var eps: Frequency,
    var gmax: PU,
    var gmin: PU,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var gv6: PU,
    var inputSignal: BooleanProxy,
    var k1: PU,
    var k2: PU,
    var kg: PU,
    var ki: PU,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var pgv6: PU,
    var pmax: PU,
    var pmin: PU,
    var r: PU,
    var td: Seconds,
    var tf: Seconds,
    var tp: Seconds,
    var tt: Seconds,
    var tturb: Seconds,
    var velcl: Simple_Float,
    var velop: Simple_Float
)

data class DeleteGovHydroDDEvent(@Id val govHydroDDId: UUID? = null)

// single association events
data class AssignAturbToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignAturbFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignBturbToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignBturbFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignDb1ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignDb2ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: ActivePower )
data class UnAssignDb2FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignEpsToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Frequency )
data class UnAssignEpsFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignGmaxToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignGmaxFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignGminToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignGminFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignGv1ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignGv2ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignGv3ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignGv4ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignGv4FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignGv5ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignGv5FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignGv6ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignGv6FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignInputSignalToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: BooleanProxy )
data class UnAssignInputSignalFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignK1ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignK1FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignK2ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignK2FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignKgToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignKgFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignKiToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignKiFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignMwbaseToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignPgv1ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignPgv1FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignPgv2ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignPgv2FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignPgv3ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignPgv3FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignPgv4ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignPgv4FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignPgv5ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignPgv5FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignPgv6ToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignPgv6FromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignPmaxToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignPmaxFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignPminToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignPminFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignRToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: PU )
data class UnAssignRFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignTdToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Seconds )
data class UnAssignTdFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignTfToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Seconds )
data class UnAssignTfFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignTpToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Seconds )
data class UnAssignTpFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignTtToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Seconds )
data class UnAssignTtFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignTturbToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Seconds )
data class UnAssignTturbFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignVelclToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Simple_Float )
data class UnAssignVelclFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )
data class AssignVelopToGovHydroDDEvent(@Id val govHydroDDId: UUID, val assignment: Simple_Float )
data class UnAssignVelopFromGovHydroDDEvent(@Id val govHydroDDId: UUID? = null )

// multiple association events


// GovHydroFrancis Events

data class CreateGovHydroFrancisEvent(
    @Id var govHydroFrancisId: UUID? = null,
    @Enumerated(EnumType.STRING) var governorControl: FrancisGovernorControlKind
)

data class UpdateGovHydroFrancisEvent(
    @Id var govHydroFrancisId: UUID? = null,
    var am: PU,
    var av0: Area,
    var av1: Area,
    var bp: PU,
    var db1: Frequency,
    var etamax: PU,
    @Enumerated(EnumType.STRING) var governorControl: FrancisGovernorControlKind,
    var h1: Length,
    var h2: Length,
    var hn: Length,
    var kc: PU,
    var kg: PU,
    var kt: PU,
    var qc0: PU,
    var qn: VolumeFlowRate,
    var ta: Seconds,
    var td: Seconds,
    var ts: Seconds,
    var twnc: Seconds,
    var twng: Seconds,
    var tx: Seconds,
    var va: Simple_Float,
    var valvmax: PU,
    var valvmin: PU,
    var vc: Simple_Float,
    var waterTunnelSurgeChamberSimulation: BooleanProxy,
    var zsfc: Length
)

data class DeleteGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null)

// single association events
data class AssignAmToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignAmFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignAv0ToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Area )
data class UnAssignAv0FromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignAv1ToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Area )
data class UnAssignAv1FromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignBpToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignBpFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignDb1ToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignEtamaxToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignEtamaxFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignH1ToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Length )
data class UnAssignH1FromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignH2ToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Length )
data class UnAssignH2FromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignHnToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Length )
data class UnAssignHnFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignKcToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignKcFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignKgToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignKgFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignKtToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignKtFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignQc0ToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignQc0FromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignQnToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: VolumeFlowRate )
data class UnAssignQnFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignTaToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Seconds )
data class UnAssignTaFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignTdToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Seconds )
data class UnAssignTdFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignTsToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Seconds )
data class UnAssignTsFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignTwncToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Seconds )
data class UnAssignTwncFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignTwngToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Seconds )
data class UnAssignTwngFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignTxToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Seconds )
data class UnAssignTxFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignVaToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Simple_Float )
data class UnAssignVaFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignValvmaxToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignValvmaxFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignValvminToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: PU )
data class UnAssignValvminFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignVcToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Simple_Float )
data class UnAssignVcFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: BooleanProxy )
data class UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )
data class AssignZsfcToGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID, val assignment: Length )
data class UnAssignZsfcFromGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null )

// multiple association events


// GovHydroIEEE0 Events

data class CreateGovHydroIEEE0Event(
     var govHydroIEEE0Id: UUID? = null
)

data class UpdateGovHydroIEEE0Event(
    @Id var govHydroIEEE0Id: UUID? = null,
    var k: PU,
    var mwbase: ActivePower,
    var pmax: PU,
    var pmin: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds
)

data class DeleteGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null)

// single association events
data class AssignKToGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID, val assignment: PU )
data class UnAssignKFromGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null )
data class AssignMwbaseToGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null )
data class AssignPmaxToGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID, val assignment: PU )
data class UnAssignPmaxFromGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null )
data class AssignPminToGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID, val assignment: PU )
data class UnAssignPminFromGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null )
data class AssignT1ToGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID, val assignment: Seconds )
data class UnAssignT1FromGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null )
data class AssignT2ToGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID, val assignment: Seconds )
data class UnAssignT2FromGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null )
data class AssignT3ToGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID, val assignment: Seconds )
data class UnAssignT3FromGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null )
data class AssignT4ToGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID, val assignment: Seconds )
data class UnAssignT4FromGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null )

// multiple association events


// GovHydroIEEE2 Events

data class CreateGovHydroIEEE2Event(
     var govHydroIEEE2Id: UUID? = null
)

data class UpdateGovHydroIEEE2Event(
    @Id var govHydroIEEE2Id: UUID? = null,
    var aturb: PU,
    var bturb: PU,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var gv6: PU,
    var kturb: PU,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var pgv6: PU,
    var pmax: PU,
    var pmin: PU,
    var rperm: PU,
    var rtemp: PU,
    var tg: Seconds,
    var tp: Seconds,
    var tr: Seconds,
    var tw: Seconds,
    var uc: Simple_Float,
    var uo: Simple_Float
)

data class DeleteGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null)

// single association events
data class AssignAturbToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignAturbFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignBturbToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignBturbFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignGv1ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignGv2ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignGv3ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignGv4ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignGv4FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignGv5ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignGv5FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignGv6ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignGv6FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignKturbToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignKturbFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignMwbaseToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignPgv1ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignPgv1FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignPgv2ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignPgv2FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignPgv3ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignPgv3FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignPgv4ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignPgv4FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignPgv5ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignPgv5FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignPgv6ToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignPgv6FromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignPmaxToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignPmaxFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignPminToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignPminFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignRpermToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignRpermFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignRtempToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: PU )
data class UnAssignRtempFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignTgToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTgFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignTpToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTpFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignTrToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTrFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignTwToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignUcToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: Simple_Float )
data class UnAssignUcFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )
data class AssignUoToGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID, val assignment: Simple_Float )
data class UnAssignUoFromGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null )

// multiple association events


// GovHydroPID Events

data class CreateGovHydroPIDEvent(
     var govHydroPIDId: UUID? = null
)

data class UpdateGovHydroPIDEvent(
    @Id var govHydroPIDId: UUID? = null,
    var aturb: PU,
    var bturb: PU,
    var db1: Frequency,
    var db2: ActivePower,
    var eps: Frequency,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var gv6: PU,
    var inputSignal: BooleanProxy,
    var kd: PU,
    var kg: PU,
    var ki: PU,
    var kp: PU,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var pgv6: PU,
    var pmax: PU,
    var pmin: PU,
    var r: PU,
    var td: Seconds,
    var tf: Seconds,
    var tp: Seconds,
    var tt: Seconds,
    var tturb: Seconds,
    var velcl: Simple_Float,
    var velop: Simple_Float
)

data class DeleteGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null)

// single association events
data class AssignAturbToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignAturbFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignBturbToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignBturbFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignDb1ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignDb2ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: ActivePower )
data class UnAssignDb2FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignEpsToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Frequency )
data class UnAssignEpsFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignGv1ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignGv2ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignGv3ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignGv4ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignGv4FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignGv5ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignGv5FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignGv6ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignGv6FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignInputSignalToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: BooleanProxy )
data class UnAssignInputSignalFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignKdToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignKdFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignKgToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignKgFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignKiToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignKiFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignKpToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignKpFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignMwbaseToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignPgv1ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignPgv1FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignPgv2ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignPgv2FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignPgv3ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignPgv3FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignPgv4ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignPgv4FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignPgv5ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignPgv5FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignPgv6ToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignPgv6FromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignPmaxToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignPmaxFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignPminToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignPminFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignRToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: PU )
data class UnAssignRFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignTdToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Seconds )
data class UnAssignTdFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignTfToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Seconds )
data class UnAssignTfFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignTpToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Seconds )
data class UnAssignTpFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignTtToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Seconds )
data class UnAssignTtFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignTturbToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Seconds )
data class UnAssignTturbFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignVelclToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Simple_Float )
data class UnAssignVelclFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )
data class AssignVelopToGovHydroPIDEvent(@Id val govHydroPIDId: UUID, val assignment: Simple_Float )
data class UnAssignVelopFromGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null )

// multiple association events


// GovHydroPID2 Events

data class CreateGovHydroPID2Event(
     var govHydroPID2Id: UUID? = null
)

data class UpdateGovHydroPID2Event(
    @Id var govHydroPID2Id: UUID? = null,
    var atw: PU,
    var d: PU,
    var feedbackSignal: BooleanProxy,
    var g0: PU,
    var g1: PU,
    var g2: PU,
    var gmax: PU,
    var gmin: PU,
    var kd: PU,
    var ki: Simple_Float,
    var kp: PU,
    var mwbase: ActivePower,
    var p1: PU,
    var p2: PU,
    var p3: PU,
    var rperm: PU,
    var ta: Seconds,
    var tb: Seconds,
    var treg: Seconds,
    var tw: Seconds,
    var velmax: Simple_Float,
    var velmin: Simple_Float
)

data class DeleteGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null)

// single association events
data class AssignAtwToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignAtwFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignDToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignDFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignFeedbackSignalToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: BooleanProxy )
data class UnAssignFeedbackSignalFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignG0ToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignG0FromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignG1ToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignG1FromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignG2ToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignG2FromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignGmaxToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignGmaxFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignGminToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignGminFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignKdToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignKdFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignKiToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: Simple_Float )
data class UnAssignKiFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignKpToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignKpFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignMwbaseToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignP1ToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignP1FromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignP2ToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignP2FromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignP3ToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignP3FromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignRpermToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: PU )
data class UnAssignRpermFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignTaToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: Seconds )
data class UnAssignTaFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignTbToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: Seconds )
data class UnAssignTbFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignTregToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: Seconds )
data class UnAssignTregFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignTwToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignVelmaxToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: Simple_Float )
data class UnAssignVelmaxFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )
data class AssignVelminToGovHydroPID2Event(@Id val govHydroPID2Id: UUID, val assignment: Simple_Float )
data class UnAssignVelminFromGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null )

// multiple association events


// GovHydroPelton Events

data class CreateGovHydroPeltonEvent(
     var govHydroPeltonId: UUID? = null
)

data class UpdateGovHydroPeltonEvent(
    @Id var govHydroPeltonId: UUID? = null,
    var av0: Area,
    var av1: Area,
    var bp: PU,
    var db1: Frequency,
    var db2: Frequency,
    var h1: Length,
    var h2: Length,
    var hn: Length,
    var kc: PU,
    var kg: PU,
    var qc0: PU,
    var qn: VolumeFlowRate,
    var simplifiedPelton: BooleanProxy,
    var staticCompensating: BooleanProxy,
    var ta: Seconds,
    var ts: Seconds,
    var tv: Seconds,
    var twnc: Seconds,
    var twng: Seconds,
    var tx: Seconds,
    var va: Simple_Float,
    var valvmax: PU,
    var valvmin: PU,
    var vav: PU,
    var vc: Simple_Float,
    var vcv: PU,
    var waterTunnelSurgeChamberSimulation: BooleanProxy,
    var zsfc: Length
)

data class DeleteGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null)

// single association events
data class AssignAv0ToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Area )
data class UnAssignAv0FromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignAv1ToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Area )
data class UnAssignAv1FromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignBpToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: PU )
data class UnAssignBpFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignDb1ToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignDb2ToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Frequency )
data class UnAssignDb2FromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignH1ToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Length )
data class UnAssignH1FromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignH2ToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Length )
data class UnAssignH2FromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignHnToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Length )
data class UnAssignHnFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignKcToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: PU )
data class UnAssignKcFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignKgToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: PU )
data class UnAssignKgFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignQc0ToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: PU )
data class UnAssignQc0FromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignQnToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: VolumeFlowRate )
data class UnAssignQnFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignSimplifiedPeltonToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: BooleanProxy )
data class UnAssignSimplifiedPeltonFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignStaticCompensatingToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: BooleanProxy )
data class UnAssignStaticCompensatingFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignTaToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Seconds )
data class UnAssignTaFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignTsToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Seconds )
data class UnAssignTsFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignTvToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Seconds )
data class UnAssignTvFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignTwncToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Seconds )
data class UnAssignTwncFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignTwngToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Seconds )
data class UnAssignTwngFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignTxToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Seconds )
data class UnAssignTxFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignVaToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Simple_Float )
data class UnAssignVaFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignValvmaxToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: PU )
data class UnAssignValvmaxFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignValvminToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: PU )
data class UnAssignValvminFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignVavToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: PU )
data class UnAssignVavFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignVcToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Simple_Float )
data class UnAssignVcFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignVcvToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: PU )
data class UnAssignVcvFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: BooleanProxy )
data class UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )
data class AssignZsfcToGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID, val assignment: Length )
data class UnAssignZsfcFromGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null )

// multiple association events


// GovHydroR Events

data class CreateGovHydroREvent(
     var govHydroRId: UUID? = null
)

data class UpdateGovHydroREvent(
    @Id var govHydroRId: UUID? = null,
    var at: PU,
    var db1: Frequency,
    var db2: ActivePower,
    var dturb: PU,
    var eps: Frequency,
    var gmax: PU,
    var gmin: PU,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var gv6: PU,
    var h0: PU,
    var inputSignal: BooleanProxy,
    var kg: PU,
    var ki: PU,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var pgv6: PU,
    var pmax: PU,
    var pmin: PU,
    var qnl: PU,
    var r: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var t7: Seconds,
    var t8: Seconds,
    var td: Seconds,
    var tp: Seconds,
    var tt: Seconds,
    var tw: Seconds,
    var velcl: Simple_Float,
    var velop: Simple_Float
)

data class DeleteGovHydroREvent(@Id val govHydroRId: UUID? = null)

// single association events
data class AssignAtToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignAtFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignDb1ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignDb2ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: ActivePower )
data class UnAssignDb2FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignDturbToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignDturbFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignEpsToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Frequency )
data class UnAssignEpsFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignGmaxToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignGmaxFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignGminToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignGminFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignGv1ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignGv2ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignGv3ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignGv4ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignGv4FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignGv5ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignGv5FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignGv6ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignGv6FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignH0ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignH0FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignInputSignalToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: BooleanProxy )
data class UnAssignInputSignalFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignKgToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignKgFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignKiToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignKiFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignMwbaseToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignPgv1ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignPgv1FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignPgv2ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignPgv2FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignPgv3ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignPgv3FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignPgv4ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignPgv4FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignPgv5ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignPgv5FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignPgv6ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignPgv6FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignPmaxToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignPmaxFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignPminToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignPminFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignQnlToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignQnlFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignRToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: PU )
data class UnAssignRFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignT1ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignT1FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignT2ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignT2FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignT3ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignT3FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignT4ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignT4FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignT5ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignT5FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignT6ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignT6FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignT7ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignT7FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignT8ToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignT8FromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignTdToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignTdFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignTpToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignTpFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignTtToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignTtFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignTwToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignVelclToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Simple_Float )
data class UnAssignVelclFromGovHydroREvent(@Id val govHydroRId: UUID? = null )
data class AssignVelopToGovHydroREvent(@Id val govHydroRId: UUID, val assignment: Simple_Float )
data class UnAssignVelopFromGovHydroREvent(@Id val govHydroRId: UUID? = null )

// multiple association events


// GovHydroWEH Events

data class CreateGovHydroWEHEvent(
     var govHydroWEHId: UUID? = null
)

data class UpdateGovHydroWEHEvent(
    @Id var govHydroWEHId: UUID? = null,
    var db: PU,
    var dicn: PU,
    var dpv: PU,
    var dturb: PU,
    var feedbackSignal: BooleanProxy,
    var fl1: PU,
    var fl2: PU,
    var fl3: PU,
    var fl4: PU,
    var fl5: PU,
    var fp1: PU,
    var fp10: PU,
    var fp2: PU,
    var fp3: PU,
    var fp4: PU,
    var fp5: PU,
    var fp6: PU,
    var fp7: PU,
    var fp8: PU,
    var fp9: PU,
    var gmax: PU,
    var gmin: PU,
    var gtmxcl: PU,
    var gtmxop: PU,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var kd: PU,
    var ki: PU,
    var kp: PU,
    var mwbase: ActivePower,
    var pmss1: PU,
    var pmss10: PU,
    var pmss2: PU,
    var pmss3: PU,
    var pmss4: PU,
    var pmss5: PU,
    var pmss6: PU,
    var pmss7: PU,
    var pmss8: PU,
    var pmss9: PU,
    var rpg: Simple_Float,
    var rpp: Simple_Float,
    var td: Seconds,
    var tdv: Seconds,
    var tg: Seconds,
    var tp: Seconds,
    var tpe: Seconds,
    var tw: Seconds
)

data class DeleteGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null)

// single association events
data class AssignDbToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignDbFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignDicnToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignDicnFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignDpvToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignDpvFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignDturbToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignDturbFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFeedbackSignalToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: BooleanProxy )
data class UnAssignFeedbackSignalFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFl1ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFl1FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFl2ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFl2FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFl3ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFl3FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFl4ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFl4FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFl5ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFl5FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp1ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp1FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp10ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp10FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp2ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp2FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp3ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp3FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp4ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp4FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp5ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp5FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp6ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp6FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp7ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp7FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp8ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp8FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignFp9ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignFp9FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGmaxToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGmaxFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGminToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGminFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGtmxclToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGtmxclFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGtmxopToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGtmxopFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGv1ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGv2ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGv3ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGv4ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGv4FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignGv5ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignGv5FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignKdToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignKdFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignKiToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignKiFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignKpToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignKpFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignMwbaseToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss1ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss1FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss10ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss10FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss2ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss2FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss3ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss3FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss4ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss4FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss5ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss5FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss6ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss6FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss7ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss7FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss8ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss8FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignPmss9ToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: PU )
data class UnAssignPmss9FromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignRpgToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: Simple_Float )
data class UnAssignRpgFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignRppToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: Simple_Float )
data class UnAssignRppFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignTdToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: Seconds )
data class UnAssignTdFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignTdvToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: Seconds )
data class UnAssignTdvFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignTgToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: Seconds )
data class UnAssignTgFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignTpToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: Seconds )
data class UnAssignTpFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignTpeToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: Seconds )
data class UnAssignTpeFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )
data class AssignTwToGovHydroWEHEvent(@Id val govHydroWEHId: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null )

// multiple association events


// GovHydroWPID Events

data class CreateGovHydroWPIDEvent(
     var govHydroWPIDId: UUID? = null
)

data class UpdateGovHydroWPIDEvent(
    @Id var govHydroWPIDId: UUID? = null,
    var d: PU,
    var gatmax: PU,
    var gatmin: PU,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var kd: PU,
    var ki: PU,
    var kp: PU,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pmax: PU,
    var pmin: PU,
    var reg: PU,
    var ta: Seconds,
    var tb: Seconds,
    var treg: Seconds,
    var tw: Seconds,
    var velmax: PU,
    var velmin: PU
)

data class DeleteGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null)

// single association events
data class AssignDToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignDFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignGatmaxToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignGatmaxFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignGatminToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignGatminFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignGv1ToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignGv1FromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignGv2ToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignGv2FromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignGv3ToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignGv3FromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignKdToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignKdFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignKiToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignKiFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignKpToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignKpFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignMwbaseToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignPgv1ToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignPgv1FromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignPgv2ToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignPgv2FromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignPgv3ToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignPgv3FromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignPmaxToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignPmaxFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignPminToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignPminFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignRegToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignRegFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignTaToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: Seconds )
data class UnAssignTaFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignTbToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: Seconds )
data class UnAssignTbFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignTregToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: Seconds )
data class UnAssignTregFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignTwToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: Seconds )
data class UnAssignTwFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignVelmaxToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignVelmaxFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )
data class AssignVelminToGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID, val assignment: PU )
data class UnAssignVelminFromGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null )

// multiple association events


// GovSteam0 Events

data class CreateGovSteam0Event(
     var govSteam0Id: UUID? = null
)

data class UpdateGovSteam0Event(
    @Id var govSteam0Id: UUID? = null,
    var dt: PU,
    var mwbase: ActivePower,
    var r: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var vmax: PU,
    var vmin: PU
)

data class DeleteGovSteam0Event(@Id val govSteam0Id: UUID? = null)

// single association events
data class AssignDtToGovSteam0Event(@Id val govSteam0Id: UUID, val assignment: PU )
data class UnAssignDtFromGovSteam0Event(@Id val govSteam0Id: UUID? = null )
data class AssignMwbaseToGovSteam0Event(@Id val govSteam0Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovSteam0Event(@Id val govSteam0Id: UUID? = null )
data class AssignRToGovSteam0Event(@Id val govSteam0Id: UUID, val assignment: PU )
data class UnAssignRFromGovSteam0Event(@Id val govSteam0Id: UUID? = null )
data class AssignT1ToGovSteam0Event(@Id val govSteam0Id: UUID, val assignment: Seconds )
data class UnAssignT1FromGovSteam0Event(@Id val govSteam0Id: UUID? = null )
data class AssignT2ToGovSteam0Event(@Id val govSteam0Id: UUID, val assignment: Seconds )
data class UnAssignT2FromGovSteam0Event(@Id val govSteam0Id: UUID? = null )
data class AssignT3ToGovSteam0Event(@Id val govSteam0Id: UUID, val assignment: Seconds )
data class UnAssignT3FromGovSteam0Event(@Id val govSteam0Id: UUID? = null )
data class AssignVmaxToGovSteam0Event(@Id val govSteam0Id: UUID, val assignment: PU )
data class UnAssignVmaxFromGovSteam0Event(@Id val govSteam0Id: UUID? = null )
data class AssignVminToGovSteam0Event(@Id val govSteam0Id: UUID, val assignment: PU )
data class UnAssignVminFromGovSteam0Event(@Id val govSteam0Id: UUID? = null )

// multiple association events


// GovSteam1 Events

data class CreateGovSteam1Event(
     var govSteam1Id: UUID? = null
)

data class UpdateGovSteam1Event(
    @Id var govSteam1Id: UUID? = null,
    var db1: Frequency,
    var db2: ActivePower,
    var eps: Frequency,
    var gv1: PU,
    var gv2: PU,
    var gv3: PU,
    var gv4: PU,
    var gv5: PU,
    var gv6: PU,
    var k: PU,
    var k1: Simple_Float,
    var k2: Simple_Float,
    var k3: Simple_Float,
    var k4: Simple_Float,
    var k5: Simple_Float,
    var k6: Simple_Float,
    var k7: Simple_Float,
    var k8: Simple_Float,
    var mwbase: ActivePower,
    var pgv1: PU,
    var pgv2: PU,
    var pgv3: PU,
    var pgv4: PU,
    var pgv5: PU,
    var pgv6: PU,
    var pmax: PU,
    var pmin: PU,
    var sdb1: BooleanProxy,
    var sdb2: BooleanProxy,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var t7: Seconds,
    var uc: Simple_Float,
    var uo: Simple_Float,
    var valve: BooleanProxy
)

data class DeleteGovSteam1Event(@Id val govSteam1Id: UUID? = null)

// single association events
data class AssignDb1ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Frequency )
data class UnAssignDb1FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignDb2ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: ActivePower )
data class UnAssignDb2FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignEpsToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Frequency )
data class UnAssignEpsFromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignGv1ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignGv1FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignGv2ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignGv2FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignGv3ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignGv3FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignGv4ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignGv4FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignGv5ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignGv5FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignGv6ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignGv6FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignKToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignKFromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignK1ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignK1FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignK2ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignK2FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignK3ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignK3FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignK4ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignK4FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignK5ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignK5FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignK6ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignK6FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignK7ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignK7FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignK8ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignK8FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignMwbaseToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignPgv1ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignPgv1FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignPgv2ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignPgv2FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignPgv3ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignPgv3FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignPgv4ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignPgv4FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignPgv5ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignPgv5FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignPgv6ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignPgv6FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignPmaxToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignPmaxFromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignPminToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: PU )
data class UnAssignPminFromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignSdb1ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: BooleanProxy )
data class UnAssignSdb1FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignSdb2ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: BooleanProxy )
data class UnAssignSdb2FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignT1ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Seconds )
data class UnAssignT1FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignT2ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Seconds )
data class UnAssignT2FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignT3ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Seconds )
data class UnAssignT3FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignT4ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Seconds )
data class UnAssignT4FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignT5ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Seconds )
data class UnAssignT5FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignT6ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Seconds )
data class UnAssignT6FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignT7ToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Seconds )
data class UnAssignT7FromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignUcToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignUcFromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignUoToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: Simple_Float )
data class UnAssignUoFromGovSteam1Event(@Id val govSteam1Id: UUID? = null )
data class AssignValveToGovSteam1Event(@Id val govSteam1Id: UUID, val assignment: BooleanProxy )
data class UnAssignValveFromGovSteam1Event(@Id val govSteam1Id: UUID? = null )

// multiple association events


// GovSteam2 Events

data class CreateGovSteam2Event(
     var govSteam2Id: UUID? = null
)

data class UpdateGovSteam2Event(
    @Id var govSteam2Id: UUID? = null,
    var dbf: PU,
    var k: Simple_Float,
    var mnef: PU,
    var mxef: PU,
    var pmax: PU,
    var pmin: PU,
    var t1: Seconds,
    var t2: Seconds
)

data class DeleteGovSteam2Event(@Id val govSteam2Id: UUID? = null)

// single association events
data class AssignDbfToGovSteam2Event(@Id val govSteam2Id: UUID, val assignment: PU )
data class UnAssignDbfFromGovSteam2Event(@Id val govSteam2Id: UUID? = null )
data class AssignKToGovSteam2Event(@Id val govSteam2Id: UUID, val assignment: Simple_Float )
data class UnAssignKFromGovSteam2Event(@Id val govSteam2Id: UUID? = null )
data class AssignMnefToGovSteam2Event(@Id val govSteam2Id: UUID, val assignment: PU )
data class UnAssignMnefFromGovSteam2Event(@Id val govSteam2Id: UUID? = null )
data class AssignMxefToGovSteam2Event(@Id val govSteam2Id: UUID, val assignment: PU )
data class UnAssignMxefFromGovSteam2Event(@Id val govSteam2Id: UUID? = null )
data class AssignPmaxToGovSteam2Event(@Id val govSteam2Id: UUID, val assignment: PU )
data class UnAssignPmaxFromGovSteam2Event(@Id val govSteam2Id: UUID? = null )
data class AssignPminToGovSteam2Event(@Id val govSteam2Id: UUID, val assignment: PU )
data class UnAssignPminFromGovSteam2Event(@Id val govSteam2Id: UUID? = null )
data class AssignT1ToGovSteam2Event(@Id val govSteam2Id: UUID, val assignment: Seconds )
data class UnAssignT1FromGovSteam2Event(@Id val govSteam2Id: UUID? = null )
data class AssignT2ToGovSteam2Event(@Id val govSteam2Id: UUID, val assignment: Seconds )
data class UnAssignT2FromGovSteam2Event(@Id val govSteam2Id: UUID? = null )

// multiple association events


// GovSteamCC Events

data class CreateGovSteamCCEvent(
     var govSteamCCId: UUID? = null
)

data class UpdateGovSteamCCEvent(
    @Id var govSteamCCId: UUID? = null,
    var dhp: PU,
    var dlp: PU,
    var fhp: PU,
    var flp: PU,
    var mwbase: ActivePower,
    var pmaxhp: PU,
    var pmaxlp: PU,
    var rhp: PU,
    var rlp: PU,
    var t1hp: Seconds,
    var t1lp: Seconds,
    var t3hp: Seconds,
    var t3lp: Seconds,
    var t4hp: Seconds,
    var t4lp: Seconds,
    var t5hp: Seconds,
    var t5lp: Seconds
)

data class DeleteGovSteamCCEvent(@Id val govSteamCCId: UUID? = null)

// single association events
data class AssignDhpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: PU )
data class UnAssignDhpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignDlpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: PU )
data class UnAssignDlpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignFhpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: PU )
data class UnAssignFhpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignFlpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: PU )
data class UnAssignFlpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignMwbaseToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignPmaxhpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: PU )
data class UnAssignPmaxhpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignPmaxlpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: PU )
data class UnAssignPmaxlpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignRhpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: PU )
data class UnAssignRhpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignRlpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: PU )
data class UnAssignRlpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignT1hpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: Seconds )
data class UnAssignT1hpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignT1lpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: Seconds )
data class UnAssignT1lpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignT3hpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: Seconds )
data class UnAssignT3hpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignT3lpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: Seconds )
data class UnAssignT3lpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignT4hpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: Seconds )
data class UnAssignT4hpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignT4lpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: Seconds )
data class UnAssignT4lpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignT5hpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: Seconds )
data class UnAssignT5hpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )
data class AssignT5lpToGovSteamCCEvent(@Id val govSteamCCId: UUID, val assignment: Seconds )
data class UnAssignT5lpFromGovSteamCCEvent(@Id val govSteamCCId: UUID? = null )

// multiple association events


// GovSteamEU Events

data class CreateGovSteamEUEvent(
     var govSteamEUId: UUID? = null
)

data class UpdateGovSteamEUEvent(
    @Id var govSteamEUId: UUID? = null,
    var chc: Simple_Float,
    var cho: Simple_Float,
    var cic: PU,
    var cio: PU,
    var db1: PU,
    var db2: PU,
    var hhpmax: PU,
    var ke: PU,
    var kfcor: PU,
    var khp: PU,
    var klp: PU,
    var kwcor: PU,
    var mwbase: ActivePower,
    var pmax: PU,
    var prhmax: PU,
    var simx: PU,
    var tb: Seconds,
    var tdp: Seconds,
    var ten: Seconds,
    var tf: Seconds,
    var tfp: Seconds,
    var thp: Seconds,
    var tip: Seconds,
    var tlp: Seconds,
    var tp: Seconds,
    var trh: Seconds,
    var tvhp: Seconds,
    var tvip: Seconds,
    var tw: Seconds,
    var wfmax: PU,
    var wfmin: PU,
    var wmax1: PU,
    var wmax2: PU,
    var wwmax: PU,
    var wwmin: PU
)

data class DeleteGovSteamEUEvent(@Id val govSteamEUId: UUID? = null)

// single association events
data class AssignChcToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Simple_Float )
data class UnAssignChcFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignChoToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Simple_Float )
data class UnAssignChoFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignCicToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignCicFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignCioToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignCioFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignDb1ToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignDb1FromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignDb2ToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignDb2FromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignHhpmaxToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignHhpmaxFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignKeToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignKeFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignKfcorToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignKfcorFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignKhpToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignKhpFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignKlpToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignKlpFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignKwcorToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignKwcorFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignMwbaseToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignPmaxToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignPmaxFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignPrhmaxToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignPrhmaxFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignSimxToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignSimxFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTbToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTbFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTdpToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTdpFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTenToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTenFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTfToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTfFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTfpToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTfpFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignThpToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignThpFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTipToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTipFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTlpToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTlpFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTpToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTpFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTrhToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTrhFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTvhpToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTvhpFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTvipToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTvipFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignTwToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: Seconds )
data class UnAssignTwFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignWfmaxToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignWfmaxFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignWfminToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignWfminFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignWmax1ToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignWmax1FromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignWmax2ToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignWmax2FromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignWwmaxToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignWwmaxFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )
data class AssignWwminToGovSteamEUEvent(@Id val govSteamEUId: UUID, val assignment: PU )
data class UnAssignWwminFromGovSteamEUEvent(@Id val govSteamEUId: UUID? = null )

// multiple association events


// GovSteamFV2 Events

data class CreateGovSteamFV2Event(
     var govSteamFV2Id: UUID? = null
)

data class UpdateGovSteamFV2Event(
    @Id var govSteamFV2Id: UUID? = null,
    var dt: PU,
    var k: PU,
    var mwbase: ActivePower,
    var r: PU,
    var t1: Seconds,
    var t3: Seconds,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var ti: Seconds,
    var tt: Seconds,
    var vmax: PU,
    var vmin: PU
)

data class DeleteGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null)

// single association events
data class AssignDtToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: PU )
data class UnAssignDtFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignKToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: PU )
data class UnAssignKFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignMwbaseToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignRToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: PU )
data class UnAssignRFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignT1ToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: Seconds )
data class UnAssignT1FromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignT3ToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: Seconds )
data class UnAssignT3FromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignTaToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: Seconds )
data class UnAssignTaFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignTbToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: Seconds )
data class UnAssignTbFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignTcToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: Seconds )
data class UnAssignTcFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignTiToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: Seconds )
data class UnAssignTiFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignTtToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: Seconds )
data class UnAssignTtFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignVmaxToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: PU )
data class UnAssignVmaxFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )
data class AssignVminToGovSteamFV2Event(@Id val govSteamFV2Id: UUID, val assignment: PU )
data class UnAssignVminFromGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null )

// multiple association events


// GovSteamFV3 Events

data class CreateGovSteamFV3Event(
     var govSteamFV3Id: UUID? = null
)

data class UpdateGovSteamFV3Event(
    @Id var govSteamFV3Id: UUID? = null,
    var k: PU,
    var k1: PU,
    var k2: PU,
    var k3: PU,
    var mwbase: ActivePower,
    var pmax: PU,
    var pmin: PU,
    var prmax: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var uc: Simple_Float,
    var uo: Simple_Float
)

data class DeleteGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null)

// single association events
data class AssignKToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: PU )
data class UnAssignKFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignK1ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: PU )
data class UnAssignK1FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignK2ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: PU )
data class UnAssignK2FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignK3ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: PU )
data class UnAssignK3FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignMwbaseToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignPmaxToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: PU )
data class UnAssignPmaxFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignPminToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: PU )
data class UnAssignPminFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignPrmaxToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: PU )
data class UnAssignPrmaxFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignT1ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignT1FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignT2ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignT2FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignT3ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignT3FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignT4ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignT4FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignT5ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignT5FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignT6ToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignT6FromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignTaToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignTaFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignTbToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignTbFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignTcToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Seconds )
data class UnAssignTcFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignUcToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Simple_Float )
data class UnAssignUcFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )
data class AssignUoToGovSteamFV3Event(@Id val govSteamFV3Id: UUID, val assignment: Simple_Float )
data class UnAssignUoFromGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null )

// multiple association events


// GovSteamFV4 Events

data class CreateGovSteamFV4Event(
     var govSteamFV4Id: UUID? = null
)

data class UpdateGovSteamFV4Event(
    @Id var govSteamFV4Id: UUID? = null,
    var cpsmn: PU,
    var cpsmx: PU,
    var crmn: PU,
    var crmx: PU,
    var kdc: PU,
    var kf1: PU,
    var kf3: PU,
    var khp: PU,
    var kic: PU,
    var kip: PU,
    var kit: PU,
    var kmp1: PU,
    var kmp2: PU,
    var kpc: PU,
    var kpp: PU,
    var kpt: PU,
    var krc: PU,
    var ksh: PU,
    var lpi: PU,
    var lps: PU,
    var mnef: PU,
    var mxef: PU,
    var pr1: PU,
    var pr2: PU,
    var psmn: PU,
    var rsmimn: PU,
    var rsmimx: PU,
    var rvgmn: PU,
    var rvgmx: PU,
    var srmn: PU,
    var srmx: PU,
    var srsmp: PU,
    var svmn: Simple_Float,
    var svmx: Simple_Float,
    var ta: Seconds,
    var tam: Seconds,
    var tc: Seconds,
    var tcm: Seconds,
    var tdc: Seconds,
    var tf1: Seconds,
    var tf2: Seconds,
    var thp: Seconds,
    var tmp: Seconds,
    var trh: Seconds,
    var tv: Seconds,
    var ty: Seconds,
    var y: PU,
    var yhpmn: PU,
    var yhpmx: PU,
    var ympmn: PU,
    var ympmx: PU
)

data class DeleteGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null)

// single association events
data class AssignCpsmnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignCpsmnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignCpsmxToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignCpsmxFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignCrmnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignCrmnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignCrmxToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignCrmxFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKdcToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKdcFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKf1ToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKf1FromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKf3ToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKf3FromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKhpToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKhpFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKicToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKicFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKipToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKipFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKitToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKitFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKmp1ToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKmp1FromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKmp2ToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKmp2FromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKpcToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKpcFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKppToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKppFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKptToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKptFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKrcToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKrcFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignKshToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignKshFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignLpiToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignLpiFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignLpsToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignLpsFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignMnefToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignMnefFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignMxefToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignMxefFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignPr1ToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignPr1FromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignPr2ToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignPr2FromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignPsmnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignPsmnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignRsmimnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignRsmimnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignRsmimxToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignRsmimxFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignRvgmnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignRvgmnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignRvgmxToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignRvgmxFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignSrmnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignSrmnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignSrmxToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignSrmxFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignSrsmpToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignSrsmpFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignSvmnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Simple_Float )
data class UnAssignSvmnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignSvmxToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Simple_Float )
data class UnAssignSvmxFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTaToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTaFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTamToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTamFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTcToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTcFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTcmToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTcmFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTdcToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTdcFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTf1ToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTf1FromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTf2ToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTf2FromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignThpToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignThpFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTmpToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTmpFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTrhToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTrhFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTvToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTvFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignTyToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: Seconds )
data class UnAssignTyFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignYToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignYFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignYhpmnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignYhpmnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignYhpmxToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignYhpmxFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignYmpmnToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignYmpmnFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )
data class AssignYmpmxToGovSteamFV4Event(@Id val govSteamFV4Id: UUID, val assignment: PU )
data class UnAssignYmpmxFromGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null )

// multiple association events


// GovSteamIEEE1 Events

data class CreateGovSteamIEEE1Event(
     var govSteamIEEE1Id: UUID? = null
)

data class UpdateGovSteamIEEE1Event(
    @Id var govSteamIEEE1Id: UUID? = null,
    var k: PU,
    var k1: Simple_Float,
    var k2: Simple_Float,
    var k3: Simple_Float,
    var k4: Simple_Float,
    var k5: Simple_Float,
    var k6: Simple_Float,
    var k7: Simple_Float,
    var k8: Simple_Float,
    var mwbase: ActivePower,
    var pmax: PU,
    var pmin: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var t7: Seconds,
    var uc: Simple_Float,
    var uo: Simple_Float
)

data class DeleteGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null)

// single association events
data class AssignKToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: PU )
data class UnAssignKFromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignK1ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignK1FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignK2ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignK2FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignK3ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignK3FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignK4ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignK4FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignK5ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignK5FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignK6ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignK6FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignK7ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignK7FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignK8ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignK8FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignMwbaseToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignPmaxToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: PU )
data class UnAssignPmaxFromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignPminToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: PU )
data class UnAssignPminFromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignT1ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignT1FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignT2ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignT2FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignT3ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignT3FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignT4ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignT4FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignT5ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignT5FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignT6ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignT6FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignT7ToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignT7FromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignUcToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignUcFromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )
data class AssignUoToGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID, val assignment: Simple_Float )
data class UnAssignUoFromGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null )

// multiple association events


// GovSteamSGO Events

data class CreateGovSteamSGOEvent(
     var govSteamSGOId: UUID? = null
)

data class UpdateGovSteamSGOEvent(
    @Id var govSteamSGOId: UUID? = null,
    var k1: PU,
    var k2: PU,
    var k3: PU,
    var mwbase: ActivePower,
    var pmax: PU,
    var pmin: Seconds,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds
)

data class DeleteGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null)

// single association events
data class AssignK1ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: PU )
data class UnAssignK1FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignK2ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: PU )
data class UnAssignK2FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignK3ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: PU )
data class UnAssignK3FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignMwbaseToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignPmaxToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: PU )
data class UnAssignPmaxFromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignPminToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: Seconds )
data class UnAssignPminFromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignT1ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: Seconds )
data class UnAssignT1FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignT2ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: Seconds )
data class UnAssignT2FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignT3ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: Seconds )
data class UnAssignT3FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignT4ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: Seconds )
data class UnAssignT4FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignT5ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: Seconds )
data class UnAssignT5FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )
data class AssignT6ToGovSteamSGOEvent(@Id val govSteamSGOId: UUID, val assignment: Seconds )
data class UnAssignT6FromGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null )

// multiple association events


// GrossToNetActivePowerCurve Events

data class CreateGrossToNetActivePowerCurveEvent(
     var grossToNetActivePowerCurveId: UUID? = null
)

data class UpdateGrossToNetActivePowerCurveEvent(
    @Id var grossToNetActivePowerCurveId: UUID? = null,
    var grossToNetActivePowerCurves:  Set<GrossToNetActivePowerCurve>
)

data class DeleteGrossToNetActivePowerCurveEvent(@Id val grossToNetActivePowerCurveId: UUID? = null)

// single association events

// multiple association events
data class AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent(@Id val grossToNetActivePowerCurveId: UUID, val addTo: GrossToNetActivePowerCurve )
data class RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent(@Id val grossToNetActivePowerCurveId: UUID, val removeFrom: GrossToNetActivePowerCurve )


// Ground Events

data class CreateGroundEvent(
     var groundId: UUID? = null
)

data class UpdateGroundEvent(
     var groundId: UUID? = null
)

data class DeleteGroundEvent(@Id val groundId: UUID? = null)

// single association events

// multiple association events


// GroundDisconnector Events

data class CreateGroundDisconnectorEvent(
     var groundDisconnectorId: UUID? = null
)

data class UpdateGroundDisconnectorEvent(
     var groundDisconnectorId: UUID? = null
)

data class DeleteGroundDisconnectorEvent(@Id val groundDisconnectorId: UUID? = null)

// single association events

// multiple association events


// GroundingImpedance Events

data class CreateGroundingImpedanceEvent(
     var groundingImpedanceId: UUID? = null
)

data class UpdateGroundingImpedanceEvent(
    @Id var groundingImpedanceId: UUID? = null,
    var x: Reactance
)

data class DeleteGroundingImpedanceEvent(@Id val groundingImpedanceId: UUID? = null)

// single association events
data class AssignXToGroundingImpedanceEvent(@Id val groundingImpedanceId: UUID, val assignment: Reactance )
data class UnAssignXFromGroundingImpedanceEvent(@Id val groundingImpedanceId: UUID? = null )

// multiple association events


// HydroGeneratingUnit Events

data class CreateHydroGeneratingUnitEvent(
    @Id var hydroGeneratingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var energyConversionCapability: HydroEnergyConversionKind
)

data class UpdateHydroGeneratingUnitEvent(
    @Id var hydroGeneratingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var energyConversionCapability: HydroEnergyConversionKind,
    var hydroGeneratingUnits:  Set<HydroGeneratingUnit>
)

data class DeleteHydroGeneratingUnitEvent(@Id val hydroGeneratingUnitId: UUID? = null)

// single association events

// multiple association events
data class AssignHydroGeneratingUnitsToHydroGeneratingUnitEvent(@Id val hydroGeneratingUnitId: UUID, val addTo: HydroGeneratingUnit )
data class RemoveHydroGeneratingUnitsFromHydroGeneratingUnitEvent(@Id val hydroGeneratingUnitId: UUID, val removeFrom: HydroGeneratingUnit )


// HydroPowerPlant Events

data class CreateHydroPowerPlantEvent(
    @Id var hydroPowerPlantId: UUID? = null,
    @Enumerated(EnumType.STRING) var hydroPlantStorageType: HydroPlantStorageKind
)

data class UpdateHydroPowerPlantEvent(
    @Id var hydroPowerPlantId: UUID? = null,
    @Enumerated(EnumType.STRING) var hydroPlantStorageType: HydroPlantStorageKind
)

data class DeleteHydroPowerPlantEvent(@Id val hydroPowerPlantId: UUID? = null)

// single association events

// multiple association events


// HydroPump Events

data class CreateHydroPumpEvent(
     var hydroPumpId: UUID? = null
)

data class UpdateHydroPumpEvent(
    @Id var hydroPumpId: UUID? = null,
    var hydroPump: HydroPump,
    var hydroPumps:  Set<HydroPump>
)

data class DeleteHydroPumpEvent(@Id val hydroPumpId: UUID? = null)

// single association events
data class AssignHydroPumpToHydroPumpEvent(@Id val hydroPumpId: UUID, val assignment: HydroPump )
data class UnAssignHydroPumpFromHydroPumpEvent(@Id val hydroPumpId: UUID? = null )

// multiple association events
data class AssignHydroPumpsToHydroPumpEvent(@Id val hydroPumpId: UUID, val addTo: HydroPump )
data class RemoveHydroPumpsFromHydroPumpEvent(@Id val hydroPumpId: UUID, val removeFrom: HydroPump )


// IdentifiedObject Events

data class CreateIdentifiedObjectEvent(
     var identifiedObjectId: UUID? = null
)

data class UpdateIdentifiedObjectEvent(
    @Id var identifiedObjectId: UUID? = null,
    var description: StringProxy,
    var energyIdentCodeEic: StringProxy,
    var mRID: StringProxy,
    var name: StringProxy,
    var shortName: StringProxy
)

data class DeleteIdentifiedObjectEvent(@Id val identifiedObjectId: UUID? = null)

// single association events
data class AssignDescriptionToIdentifiedObjectEvent(@Id val identifiedObjectId: UUID, val assignment: StringProxy )
data class UnAssignDescriptionFromIdentifiedObjectEvent(@Id val identifiedObjectId: UUID? = null )
data class AssignEnergyIdentCodeEicToIdentifiedObjectEvent(@Id val identifiedObjectId: UUID, val assignment: StringProxy )
data class UnAssignEnergyIdentCodeEicFromIdentifiedObjectEvent(@Id val identifiedObjectId: UUID? = null )
data class AssignMRIDToIdentifiedObjectEvent(@Id val identifiedObjectId: UUID, val assignment: StringProxy )
data class UnAssignMRIDFromIdentifiedObjectEvent(@Id val identifiedObjectId: UUID? = null )
data class AssignNameToIdentifiedObjectEvent(@Id val identifiedObjectId: UUID, val assignment: StringProxy )
data class UnAssignNameFromIdentifiedObjectEvent(@Id val identifiedObjectId: UUID? = null )
data class AssignShortNameToIdentifiedObjectEvent(@Id val identifiedObjectId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromIdentifiedObjectEvent(@Id val identifiedObjectId: UUID? = null )

// multiple association events


// Inductance Events

data class CreateInductanceEvent(
    @Id var inductanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateInductanceEvent(
    @Id var inductanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteInductanceEvent(@Id val inductanceId: UUID? = null)

// single association events
data class AssignValueToInductanceEvent(@Id val inductanceId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromInductanceEvent(@Id val inductanceId: UUID? = null )

// multiple association events


// InductancePerLength Events

data class CreateInductancePerLengthEvent(
    @Id var inductancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateInductancePerLengthEvent(
    @Id var inductancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteInductancePerLengthEvent(@Id val inductancePerLengthId: UUID? = null)

// single association events
data class AssignValueToInductancePerLengthEvent(@Id val inductancePerLengthId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromInductancePerLengthEvent(@Id val inductancePerLengthId: UUID? = null )

// multiple association events


// IntegerProxy Events

data class CreateIntegerProxyEvent(
     var integerProxyId: UUID? = null
)

data class UpdateIntegerProxyEvent(
     var integerProxyId: UUID? = null
)

data class DeleteIntegerProxyEvent(@Id val integerProxyId: UUID? = null)

// single association events

// multiple association events


// Junction Events

data class CreateJunctionEvent(
     var junctionId: UUID? = null
)

data class UpdateJunctionEvent(
     var junctionId: UUID? = null
)

data class DeleteJunctionEvent(@Id val junctionId: UUID? = null)

// single association events

// multiple association events


// Length Events

data class CreateLengthEvent(
    @Id var lengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateLengthEvent(
    @Id var lengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteLengthEvent(@Id val lengthId: UUID? = null)

// single association events
data class AssignValueToLengthEvent(@Id val lengthId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromLengthEvent(@Id val lengthId: UUID? = null )

// multiple association events


// Limit Events

data class CreateLimitEvent(
     var limitId: UUID? = null
)

data class UpdateLimitEvent(
     var limitId: UUID? = null
)

data class DeleteLimitEvent(@Id val limitId: UUID? = null)

// single association events

// multiple association events


// LimitSet Events

data class CreateLimitSetEvent(
     var limitSetId: UUID? = null
)

data class UpdateLimitSetEvent(
    @Id var limitSetId: UUID? = null,
    var percentageLimitsFlag: BooleanProxy
)

data class DeleteLimitSetEvent(@Id val limitSetId: UUID? = null)

// single association events
data class AssignPercentageLimitsFlagToLimitSetEvent(@Id val limitSetId: UUID, val assignment: BooleanProxy )
data class UnAssignPercentageLimitsFlagFromLimitSetEvent(@Id val limitSetId: UUID? = null )

// multiple association events


// Line Events

data class CreateLineEvent(
     var lineId: UUID? = null
)

data class UpdateLineEvent(
    @Id var lineId: UUID? = null,
    var lines:  Set<Line>
)

data class DeleteLineEvent(@Id val lineId: UUID? = null)

// single association events

// multiple association events
data class AssignLinesToLineEvent(@Id val lineId: UUID, val addTo: Line )
data class RemoveLinesFromLineEvent(@Id val lineId: UUID, val removeFrom: Line )


// LinearShuntCompensator Events

data class CreateLinearShuntCompensatorEvent(
     var linearShuntCompensatorId: UUID? = null
)

data class UpdateLinearShuntCompensatorEvent(
    @Id var linearShuntCompensatorId: UUID? = null,
    var b0PerSection: Susceptance,
    var bPerSection: Susceptance,
    var g0PerSection: Conductance,
    var gPerSection: Conductance
)

data class DeleteLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID? = null)

// single association events
data class AssignB0PerSectionToLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID, val assignment: Susceptance )
data class UnAssignB0PerSectionFromLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID? = null )
data class AssignBPerSectionToLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID, val assignment: Susceptance )
data class UnAssignBPerSectionFromLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID? = null )
data class AssignG0PerSectionToLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID, val assignment: Conductance )
data class UnAssignG0PerSectionFromLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID? = null )
data class AssignGPerSectionToLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID, val assignment: Conductance )
data class UnAssignGPerSectionFromLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID? = null )

// multiple association events


// LoadAggregate Events

data class CreateLoadAggregateEvent(
     var loadAggregateId: UUID? = null
)

data class UpdateLoadAggregateEvent(
     var loadAggregateId: UUID? = null
)

data class DeleteLoadAggregateEvent(@Id val loadAggregateId: UUID? = null)

// single association events

// multiple association events


// LoadArea Events

data class CreateLoadAreaEvent(
     var loadAreaId: UUID? = null
)

data class UpdateLoadAreaEvent(
     var loadAreaId: UUID? = null
)

data class DeleteLoadAreaEvent(@Id val loadAreaId: UUID? = null)

// single association events

// multiple association events


// LoadBreakSwitch Events

data class CreateLoadBreakSwitchEvent(
     var loadBreakSwitchId: UUID? = null
)

data class UpdateLoadBreakSwitchEvent(
     var loadBreakSwitchId: UUID? = null
)

data class DeleteLoadBreakSwitchEvent(@Id val loadBreakSwitchId: UUID? = null)

// single association events

// multiple association events


// LoadComposite Events

data class CreateLoadCompositeEvent(
     var loadCompositeId: UUID? = null
)

data class UpdateLoadCompositeEvent(
    @Id var loadCompositeId: UUID? = null,
    var epfd: Simple_Float,
    var epfs: Simple_Float,
    var epvd: Simple_Float,
    var epvs: Simple_Float,
    var eqfd: Simple_Float,
    var eqfs: Simple_Float,
    var eqvd: Simple_Float,
    var eqvs: Simple_Float,
    var h: Seconds,
    var lfrac: Simple_Float,
    var pfrac: Simple_Float
)

data class DeleteLoadCompositeEvent(@Id val loadCompositeId: UUID? = null)

// single association events
data class AssignEpfdToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignEpfdFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignEpfsToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignEpfsFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignEpvdToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignEpvdFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignEpvsToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignEpvsFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignEqfdToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignEqfdFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignEqfsToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignEqfsFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignEqvdToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignEqvdFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignEqvsToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignEqvsFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignHToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Seconds )
data class UnAssignHFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignLfracToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignLfracFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )
data class AssignPfracToLoadCompositeEvent(@Id val loadCompositeId: UUID, val assignment: Simple_Float )
data class UnAssignPfracFromLoadCompositeEvent(@Id val loadCompositeId: UUID? = null )

// multiple association events


// LoadDynamics Events

data class CreateLoadDynamicsEvent(
     var loadDynamicsId: UUID? = null
)

data class UpdateLoadDynamicsEvent(
     var loadDynamicsId: UUID? = null
)

data class DeleteLoadDynamicsEvent(@Id val loadDynamicsId: UUID? = null)

// single association events

// multiple association events


// LoadGenericNonLinear Events

data class CreateLoadGenericNonLinearEvent(
    @Id var loadGenericNonLinearId: UUID? = null,
    @Enumerated(EnumType.STRING) var genericNonLinearLoadModelType: GenericNonLinearLoadModelKind
)

data class UpdateLoadGenericNonLinearEvent(
    @Id var loadGenericNonLinearId: UUID? = null,
    var bs: Simple_Float,
    var bt: Simple_Float,
    @Enumerated(EnumType.STRING) var genericNonLinearLoadModelType: GenericNonLinearLoadModelKind,
    var ls: Simple_Float,
    var lt: Simple_Float,
    var pt: Simple_Float,
    var qt: Simple_Float,
    var tp: Seconds,
    var tq: Seconds
)

data class DeleteLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null)

// single association events
data class AssignBsToLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID, val assignment: Simple_Float )
data class UnAssignBsFromLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null )
data class AssignBtToLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID, val assignment: Simple_Float )
data class UnAssignBtFromLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null )
data class AssignLsToLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID, val assignment: Simple_Float )
data class UnAssignLsFromLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null )
data class AssignLtToLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID, val assignment: Simple_Float )
data class UnAssignLtFromLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null )
data class AssignPtToLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID, val assignment: Simple_Float )
data class UnAssignPtFromLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null )
data class AssignQtToLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID, val assignment: Simple_Float )
data class UnAssignQtFromLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null )
data class AssignTpToLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID, val assignment: Seconds )
data class UnAssignTpFromLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null )
data class AssignTqToLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID, val assignment: Seconds )
data class UnAssignTqFromLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null )

// multiple association events


// LoadGroup Events

data class CreateLoadGroupEvent(
     var loadGroupId: UUID? = null
)

data class UpdateLoadGroupEvent(
    @Id var loadGroupId: UUID? = null,
    var loadGroups:  Set<LoadGroup>
)

data class DeleteLoadGroupEvent(@Id val loadGroupId: UUID? = null)

// single association events

// multiple association events
data class AssignLoadGroupsToLoadGroupEvent(@Id val loadGroupId: UUID, val addTo: LoadGroup )
data class RemoveLoadGroupsFromLoadGroupEvent(@Id val loadGroupId: UUID, val removeFrom: LoadGroup )


// LoadMotor Events

data class CreateLoadMotorEvent(
     var loadMotorId: UUID? = null
)

data class UpdateLoadMotorEvent(
    @Id var loadMotorId: UUID? = null,
    var d: Simple_Float,
    var h: Seconds,
    var lfac: Simple_Float,
    var lp: PU,
    var lpp: PU,
    var ls: PU,
    var pfrac: Simple_Float,
    var ra: PU,
    var tbkr: Seconds,
    var tpo: Seconds,
    var tppo: Seconds,
    var tv: Seconds,
    var vt: PU,
    var loadMotor: LoadMotor
)

data class DeleteLoadMotorEvent(@Id val loadMotorId: UUID? = null)

// single association events
data class AssignDToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: Simple_Float )
data class UnAssignDFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignHToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: Seconds )
data class UnAssignHFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignLfacToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: Simple_Float )
data class UnAssignLfacFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignLpToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: PU )
data class UnAssignLpFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignLppToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: PU )
data class UnAssignLppFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignLsToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: PU )
data class UnAssignLsFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignPfracToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: Simple_Float )
data class UnAssignPfracFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignRaToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: PU )
data class UnAssignRaFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignTbkrToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: Seconds )
data class UnAssignTbkrFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignTpoToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: Seconds )
data class UnAssignTpoFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignTppoToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: Seconds )
data class UnAssignTppoFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignTvToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: Seconds )
data class UnAssignTvFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignVtToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: PU )
data class UnAssignVtFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )
data class AssignLoadMotorToLoadMotorEvent(@Id val loadMotorId: UUID, val assignment: LoadMotor )
data class UnAssignLoadMotorFromLoadMotorEvent(@Id val loadMotorId: UUID? = null )

// multiple association events


// LoadResponseCharacteristic Events

data class CreateLoadResponseCharacteristicEvent(
     var loadResponseCharacteristicId: UUID? = null
)

data class UpdateLoadResponseCharacteristicEvent(
    @Id var loadResponseCharacteristicId: UUID? = null,
    var exponentModel: BooleanProxy,
    var pConstantCurrent: Simple_Float,
    var pConstantImpedance: Simple_Float,
    var pConstantPower: Simple_Float,
    var pFrequencyExponent: Simple_Float,
    var pVoltageExponent: Simple_Float,
    var qConstantCurrent: Simple_Float,
    var qConstantImpedance: Simple_Float,
    var qConstantPower: Simple_Float,
    var qFrequencyExponent: Simple_Float,
    var qVoltageExponent: Simple_Float
)

data class DeleteLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null)

// single association events
data class AssignExponentModelToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: BooleanProxy )
data class UnAssignExponentModelFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignPConstantCurrentToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignPConstantCurrentFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignPConstantImpedanceToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignPConstantImpedanceFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignPConstantPowerToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignPConstantPowerFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignPFrequencyExponentToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignPFrequencyExponentFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignPVoltageExponentToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignPVoltageExponentFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignQConstantCurrentToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignQConstantCurrentFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignQConstantImpedanceToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignQConstantImpedanceFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignQConstantPowerToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignQConstantPowerFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignQFrequencyExponentToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignQFrequencyExponentFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )
data class AssignQVoltageExponentToLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID, val assignment: Simple_Float )
data class UnAssignQVoltageExponentFromLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null )

// multiple association events


// LoadStatic Events

data class CreateLoadStaticEvent(
    @Id var loadStaticId: UUID? = null,
    @Enumerated(EnumType.STRING) var staticLoadModelType: StaticLoadModelKind
)

data class UpdateLoadStaticEvent(
    @Id var loadStaticId: UUID? = null,
    var ep1: Simple_Float,
    var ep2: Simple_Float,
    var ep3: Simple_Float,
    var eq1: Simple_Float,
    var eq2: Simple_Float,
    var eq3: Simple_Float,
    var kp1: Simple_Float,
    var kp2: Simple_Float,
    var kp3: Simple_Float,
    var kp4: Simple_Float,
    var kpf: Simple_Float,
    var kq1: Simple_Float,
    var kq2: Simple_Float,
    var kq3: Simple_Float,
    var kq4: Simple_Float,
    var kqf: Simple_Float,
    @Enumerated(EnumType.STRING) var staticLoadModelType: StaticLoadModelKind,
    var loadStatic: LoadStatic
)

data class DeleteLoadStaticEvent(@Id val loadStaticId: UUID? = null)

// single association events
data class AssignEp1ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignEp1FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignEp2ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignEp2FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignEp3ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignEp3FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignEq1ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignEq1FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignEq2ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignEq2FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignEq3ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignEq3FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKp1ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKp1FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKp2ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKp2FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKp3ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKp3FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKp4ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKp4FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKpfToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKpfFromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKq1ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKq1FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKq2ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKq2FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKq3ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKq3FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKq4ToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKq4FromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignKqfToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: Simple_Float )
data class UnAssignKqfFromLoadStaticEvent(@Id val loadStaticId: UUID? = null )
data class AssignLoadStaticToLoadStaticEvent(@Id val loadStaticId: UUID, val assignment: LoadStatic )
data class UnAssignLoadStaticFromLoadStaticEvent(@Id val loadStaticId: UUID? = null )

// multiple association events


// LoadUserDefined Events

data class CreateLoadUserDefinedEvent(
     var loadUserDefinedId: UUID? = null
)

data class UpdateLoadUserDefinedEvent(
    @Id var loadUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteLoadUserDefinedEvent(@Id val loadUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToLoadUserDefinedEvent(@Id val loadUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromLoadUserDefinedEvent(@Id val loadUserDefinedId: UUID? = null )

// multiple association events


// Location Events

data class CreateLocationEvent(
     var locationId: UUID? = null
)

data class UpdateLocationEvent(
    @Id var locationId: UUID? = null,
    var location: Location
)

data class DeleteLocationEvent(@Id val locationId: UUID? = null)

// single association events
data class AssignLocationToLocationEvent(@Id val locationId: UUID, val assignment: Location )
data class UnAssignLocationFromLocationEvent(@Id val locationId: UUID? = null )

// multiple association events


// Measurement Events

data class CreateMeasurementEvent(
    @Id var measurementId: UUID? = null,
    @Enumerated(EnumType.STRING) var phases: PhaseCode,
    @Enumerated(EnumType.STRING) var unitMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unitSymbol: UnitSymbol
)

data class UpdateMeasurementEvent(
    @Id var measurementId: UUID? = null,
    var measurementType: StringProxy,
    @Enumerated(EnumType.STRING) var phases: PhaseCode,
    @Enumerated(EnumType.STRING) var unitMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unitSymbol: UnitSymbol,
    var measurements:  Set<Measurement>
)

data class DeleteMeasurementEvent(@Id val measurementId: UUID? = null)

// single association events
data class AssignMeasurementTypeToMeasurementEvent(@Id val measurementId: UUID, val assignment: StringProxy )
data class UnAssignMeasurementTypeFromMeasurementEvent(@Id val measurementId: UUID? = null )

// multiple association events
data class AssignMeasurementsToMeasurementEvent(@Id val measurementId: UUID, val addTo: Measurement )
data class RemoveMeasurementsFromMeasurementEvent(@Id val measurementId: UUID, val removeFrom: Measurement )


// MeasurementValue Events

data class CreateMeasurementValueEvent(
     var measurementValueId: UUID? = null
)

data class UpdateMeasurementValueEvent(
    @Id var measurementValueId: UUID? = null,
    var sensorAccuracy: PerCent,
    var timeStamp: DateTime,
    var measurementValues:  Set<MeasurementValue>
)

data class DeleteMeasurementValueEvent(@Id val measurementValueId: UUID? = null)

// single association events
data class AssignSensorAccuracyToMeasurementValueEvent(@Id val measurementValueId: UUID, val assignment: PerCent )
data class UnAssignSensorAccuracyFromMeasurementValueEvent(@Id val measurementValueId: UUID? = null )
data class AssignTimeStampToMeasurementValueEvent(@Id val measurementValueId: UUID, val assignment: DateTime )
data class UnAssignTimeStampFromMeasurementValueEvent(@Id val measurementValueId: UUID? = null )

// multiple association events
data class AssignMeasurementValuesToMeasurementValueEvent(@Id val measurementValueId: UUID, val addTo: MeasurementValue )
data class RemoveMeasurementValuesFromMeasurementValueEvent(@Id val measurementValueId: UUID, val removeFrom: MeasurementValue )


// MeasurementValueQuality Events

data class CreateMeasurementValueQualityEvent(
     var measurementValueQualityId: UUID? = null
)

data class UpdateMeasurementValueQualityEvent(
    @Id var measurementValueQualityId: UUID? = null,
    var measurementValueQuality: MeasurementValueQuality
)

data class DeleteMeasurementValueQualityEvent(@Id val measurementValueQualityId: UUID? = null)

// single association events
data class AssignMeasurementValueQualityToMeasurementValueQualityEvent(@Id val measurementValueQualityId: UUID, val assignment: MeasurementValueQuality )
data class UnAssignMeasurementValueQualityFromMeasurementValueQualityEvent(@Id val measurementValueQualityId: UUID? = null )

// multiple association events


// MeasurementValueSource Events

data class CreateMeasurementValueSourceEvent(
     var measurementValueSourceId: UUID? = null
)

data class UpdateMeasurementValueSourceEvent(
     var measurementValueSourceId: UUID? = null
)

data class DeleteMeasurementValueSourceEvent(@Id val measurementValueSourceId: UUID? = null)

// single association events

// multiple association events


// MechLoad1 Events

data class CreateMechLoad1Event(
     var mechLoad1Id: UUID? = null
)

data class UpdateMechLoad1Event(
    @Id var mechLoad1Id: UUID? = null,
    var a: Simple_Float,
    var b: Simple_Float,
    var d: Simple_Float,
    var e: Simple_Float
)

data class DeleteMechLoad1Event(@Id val mechLoad1Id: UUID? = null)

// single association events
data class AssignAToMechLoad1Event(@Id val mechLoad1Id: UUID, val assignment: Simple_Float )
data class UnAssignAFromMechLoad1Event(@Id val mechLoad1Id: UUID? = null )
data class AssignBToMechLoad1Event(@Id val mechLoad1Id: UUID, val assignment: Simple_Float )
data class UnAssignBFromMechLoad1Event(@Id val mechLoad1Id: UUID? = null )
data class AssignDToMechLoad1Event(@Id val mechLoad1Id: UUID, val assignment: Simple_Float )
data class UnAssignDFromMechLoad1Event(@Id val mechLoad1Id: UUID? = null )
data class AssignEToMechLoad1Event(@Id val mechLoad1Id: UUID, val assignment: Simple_Float )
data class UnAssignEFromMechLoad1Event(@Id val mechLoad1Id: UUID? = null )

// multiple association events


// MechanicalLoadDynamics Events

data class CreateMechanicalLoadDynamicsEvent(
     var mechanicalLoadDynamicsId: UUID? = null
)

data class UpdateMechanicalLoadDynamicsEvent(
    @Id var mechanicalLoadDynamicsId: UUID? = null,
    var mechanicalLoadDynamics: MechanicalLoadDynamics
)

data class DeleteMechanicalLoadDynamicsEvent(@Id val mechanicalLoadDynamicsId: UUID? = null)

// single association events
data class AssignMechanicalLoadDynamicsToMechanicalLoadDynamicsEvent(@Id val mechanicalLoadDynamicsId: UUID, val assignment: MechanicalLoadDynamics )
data class UnAssignMechanicalLoadDynamicsFromMechanicalLoadDynamicsEvent(@Id val mechanicalLoadDynamicsId: UUID? = null )

// multiple association events


// MechanicalLoadUserDefined Events

data class CreateMechanicalLoadUserDefinedEvent(
     var mechanicalLoadUserDefinedId: UUID? = null
)

data class UpdateMechanicalLoadUserDefinedEvent(
    @Id var mechanicalLoadUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteMechanicalLoadUserDefinedEvent(@Id val mechanicalLoadUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToMechanicalLoadUserDefinedEvent(@Id val mechanicalLoadUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromMechanicalLoadUserDefinedEvent(@Id val mechanicalLoadUserDefinedId: UUID? = null )

// multiple association events


// Money Events

data class CreateMoneyEvent(
    @Id var moneyId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: CurrencyEnum
)

data class UpdateMoneyEvent(
    @Id var moneyId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: CurrencyEnum,
    var value: DecimalProxy
)

data class DeleteMoneyEvent(@Id val moneyId: UUID? = null)

// single association events
data class AssignValueToMoneyEvent(@Id val moneyId: UUID, val assignment: DecimalProxy )
data class UnAssignValueFromMoneyEvent(@Id val moneyId: UUID? = null )

// multiple association events


// MonthDay Events

data class CreateMonthDayEvent(
     var monthDayId: UUID? = null
)

data class UpdateMonthDayEvent(
     var monthDayId: UUID? = null
)

data class DeleteMonthDayEvent(@Id val monthDayId: UUID? = null)

// single association events

// multiple association events


// MonthDayInterval Events

data class CreateMonthDayIntervalEvent(
     var monthDayIntervalId: UUID? = null
)

data class UpdateMonthDayIntervalEvent(
    @Id var monthDayIntervalId: UUID? = null,
    var end: MonthDay,
    var start: MonthDay
)

data class DeleteMonthDayIntervalEvent(@Id val monthDayIntervalId: UUID? = null)

// single association events
data class AssignEndToMonthDayIntervalEvent(@Id val monthDayIntervalId: UUID, val assignment: MonthDay )
data class UnAssignEndFromMonthDayIntervalEvent(@Id val monthDayIntervalId: UUID? = null )
data class AssignStartToMonthDayIntervalEvent(@Id val monthDayIntervalId: UUID, val assignment: MonthDay )
data class UnAssignStartFromMonthDayIntervalEvent(@Id val monthDayIntervalId: UUID? = null )

// multiple association events


// MutualCoupling Events

data class CreateMutualCouplingEvent(
     var mutualCouplingId: UUID? = null
)

data class UpdateMutualCouplingEvent(
    @Id var mutualCouplingId: UUID? = null,
    var b0ch: Susceptance,
    var distance11: Length,
    var distance12: Length,
    var distance21: Length,
    var distance22: Length,
    var g0ch: Conductance,
    var r0: Resistance,
    var x0: Reactance,
    var hasSecondMutualCoupling:  Set<MutualCoupling>,
    var hasFirstMutualCoupling:  Set<MutualCoupling>
)

data class DeleteMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null)

// single association events
data class AssignB0chToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val assignment: Susceptance )
data class UnAssignB0chFromMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null )
data class AssignDistance11ToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val assignment: Length )
data class UnAssignDistance11FromMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null )
data class AssignDistance12ToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val assignment: Length )
data class UnAssignDistance12FromMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null )
data class AssignDistance21ToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val assignment: Length )
data class UnAssignDistance21FromMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null )
data class AssignDistance22ToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val assignment: Length )
data class UnAssignDistance22FromMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null )
data class AssignG0chToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val assignment: Conductance )
data class UnAssignG0chFromMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null )
data class AssignR0ToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val assignment: Resistance )
data class UnAssignR0FromMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null )
data class AssignX0ToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val assignment: Reactance )
data class UnAssignX0FromMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null )

// multiple association events
data class AssignHasSecondMutualCouplingToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val addTo: MutualCoupling )
data class RemoveHasSecondMutualCouplingFromMutualCouplingEvent(@Id val mutualCouplingId: UUID, val removeFrom: MutualCoupling )
data class AssignHasFirstMutualCouplingToMutualCouplingEvent(@Id val mutualCouplingId: UUID, val addTo: MutualCoupling )
data class RemoveHasFirstMutualCouplingFromMutualCouplingEvent(@Id val mutualCouplingId: UUID, val removeFrom: MutualCoupling )


// NonConformLoad Events

data class CreateNonConformLoadEvent(
     var nonConformLoadId: UUID? = null
)

data class UpdateNonConformLoadEvent(
    @Id var nonConformLoadId: UUID? = null,
    var energyConsumers:  Set<NonConformLoad>
)

data class DeleteNonConformLoadEvent(@Id val nonConformLoadId: UUID? = null)

// single association events

// multiple association events
data class AssignEnergyConsumersToNonConformLoadEvent(@Id val nonConformLoadId: UUID, val addTo: NonConformLoad )
data class RemoveEnergyConsumersFromNonConformLoadEvent(@Id val nonConformLoadId: UUID, val removeFrom: NonConformLoad )


// NonConformLoadGroup Events

data class CreateNonConformLoadGroupEvent(
     var nonConformLoadGroupId: UUID? = null
)

data class UpdateNonConformLoadGroupEvent(
     var nonConformLoadGroupId: UUID? = null
)

data class DeleteNonConformLoadGroupEvent(@Id val nonConformLoadGroupId: UUID? = null)

// single association events

// multiple association events


// NonConformLoadSchedule Events

data class CreateNonConformLoadScheduleEvent(
     var nonConformLoadScheduleId: UUID? = null
)

data class UpdateNonConformLoadScheduleEvent(
    @Id var nonConformLoadScheduleId: UUID? = null,
    var nonConformLoadSchedules:  Set<NonConformLoadSchedule>
)

data class DeleteNonConformLoadScheduleEvent(@Id val nonConformLoadScheduleId: UUID? = null)

// single association events

// multiple association events
data class AssignNonConformLoadSchedulesToNonConformLoadScheduleEvent(@Id val nonConformLoadScheduleId: UUID, val addTo: NonConformLoadSchedule )
data class RemoveNonConformLoadSchedulesFromNonConformLoadScheduleEvent(@Id val nonConformLoadScheduleId: UUID, val removeFrom: NonConformLoadSchedule )


// NonlinearShuntCompensator Events

data class CreateNonlinearShuntCompensatorEvent(
     var nonlinearShuntCompensatorId: UUID? = null
)

data class UpdateNonlinearShuntCompensatorEvent(
     var nonlinearShuntCompensatorId: UUID? = null
)

data class DeleteNonlinearShuntCompensatorEvent(@Id val nonlinearShuntCompensatorId: UUID? = null)

// single association events

// multiple association events


// NonlinearShuntCompensatorPoint Events

data class CreateNonlinearShuntCompensatorPointEvent(
     var nonlinearShuntCompensatorPointId: UUID? = null
)

data class UpdateNonlinearShuntCompensatorPointEvent(
    @Id var nonlinearShuntCompensatorPointId: UUID? = null,
    var b: Susceptance,
    var b0: Susceptance,
    var g: Conductance,
    var g0: Conductance,
    var sectionNumber: IntegerProxy,
    var nonlinearShuntCompensatorPoints:  Set<NonlinearShuntCompensatorPoint>
)

data class DeleteNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID? = null)

// single association events
data class AssignBToNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID, val assignment: Susceptance )
data class UnAssignBFromNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID? = null )
data class AssignB0ToNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID, val assignment: Susceptance )
data class UnAssignB0FromNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID? = null )
data class AssignGToNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID, val assignment: Conductance )
data class UnAssignGFromNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID? = null )
data class AssignG0ToNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID, val assignment: Conductance )
data class UnAssignG0FromNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID? = null )
data class AssignSectionNumberToNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID, val assignment: IntegerProxy )
data class UnAssignSectionNumberFromNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID? = null )

// multiple association events
data class AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID, val addTo: NonlinearShuntCompensatorPoint )
data class RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID, val removeFrom: NonlinearShuntCompensatorPoint )


// NuclearGeneratingUnit Events

data class CreateNuclearGeneratingUnitEvent(
     var nuclearGeneratingUnitId: UUID? = null
)

data class UpdateNuclearGeneratingUnitEvent(
     var nuclearGeneratingUnitId: UUID? = null
)

data class DeleteNuclearGeneratingUnitEvent(@Id val nuclearGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// OperationalLimit Events

data class CreateOperationalLimitEvent(
     var operationalLimitId: UUID? = null
)

data class UpdateOperationalLimitEvent(
    @Id var operationalLimitId: UUID? = null,
    var operationalLimit:  Set<OperationalLimit>,
    var operationalLimitValue:  Set<OperationalLimit>
)

data class DeleteOperationalLimitEvent(@Id val operationalLimitId: UUID? = null)

// single association events

// multiple association events
data class AssignOperationalLimitToOperationalLimitEvent(@Id val operationalLimitId: UUID, val addTo: OperationalLimit )
data class RemoveOperationalLimitFromOperationalLimitEvent(@Id val operationalLimitId: UUID, val removeFrom: OperationalLimit )
data class AssignOperationalLimitValueToOperationalLimitEvent(@Id val operationalLimitId: UUID, val addTo: OperationalLimit )
data class RemoveOperationalLimitValueFromOperationalLimitEvent(@Id val operationalLimitId: UUID, val removeFrom: OperationalLimit )


// OperationalLimitSet Events

data class CreateOperationalLimitSetEvent(
     var operationalLimitSetId: UUID? = null
)

data class UpdateOperationalLimitSetEvent(
    @Id var operationalLimitSetId: UUID? = null,
    var operationalLimitSet:  Set<OperationalLimitSet>
)

data class DeleteOperationalLimitSetEvent(@Id val operationalLimitSetId: UUID? = null)

// single association events

// multiple association events
data class AssignOperationalLimitSetToOperationalLimitSetEvent(@Id val operationalLimitSetId: UUID, val addTo: OperationalLimitSet )
data class RemoveOperationalLimitSetFromOperationalLimitSetEvent(@Id val operationalLimitSetId: UUID, val removeFrom: OperationalLimitSet )


// OperationalLimitType Events

data class CreateOperationalLimitTypeEvent(
    @Id var operationalLimitTypeId: UUID? = null,
    @Enumerated(EnumType.STRING) var direction: OperationalLimitDirectionKind,
    @Enumerated(EnumType.STRING) var limitType: LimitTypeEnum
)

data class UpdateOperationalLimitTypeEvent(
    @Id var operationalLimitTypeId: UUID? = null,
    var acceptableDuration: Seconds,
    @Enumerated(EnumType.STRING) var direction: OperationalLimitDirectionKind,
    @Enumerated(EnumType.STRING) var limitType: LimitTypeEnum
)

data class DeleteOperationalLimitTypeEvent(@Id val operationalLimitTypeId: UUID? = null)

// single association events
data class AssignAcceptableDurationToOperationalLimitTypeEvent(@Id val operationalLimitTypeId: UUID, val assignment: Seconds )
data class UnAssignAcceptableDurationFromOperationalLimitTypeEvent(@Id val operationalLimitTypeId: UUID? = null )

// multiple association events


// OverexcLim2 Events

data class CreateOverexcLim2Event(
     var overexcLim2Id: UUID? = null
)

data class UpdateOverexcLim2Event(
    @Id var overexcLim2Id: UUID? = null,
    var ifdlim: PU,
    var koi: PU,
    var voimax: PU,
    var voimin: PU
)

data class DeleteOverexcLim2Event(@Id val overexcLim2Id: UUID? = null)

// single association events
data class AssignIfdlimToOverexcLim2Event(@Id val overexcLim2Id: UUID, val assignment: PU )
data class UnAssignIfdlimFromOverexcLim2Event(@Id val overexcLim2Id: UUID? = null )
data class AssignKoiToOverexcLim2Event(@Id val overexcLim2Id: UUID, val assignment: PU )
data class UnAssignKoiFromOverexcLim2Event(@Id val overexcLim2Id: UUID? = null )
data class AssignVoimaxToOverexcLim2Event(@Id val overexcLim2Id: UUID, val assignment: PU )
data class UnAssignVoimaxFromOverexcLim2Event(@Id val overexcLim2Id: UUID? = null )
data class AssignVoiminToOverexcLim2Event(@Id val overexcLim2Id: UUID, val assignment: PU )
data class UnAssignVoiminFromOverexcLim2Event(@Id val overexcLim2Id: UUID? = null )

// multiple association events


// OverexcLimIEEE Events

data class CreateOverexcLimIEEEEvent(
     var overexcLimIEEEId: UUID? = null
)

data class UpdateOverexcLimIEEEEvent(
    @Id var overexcLimIEEEId: UUID? = null,
    var hyst: PU,
    var ifdlim: PU,
    var ifdmax: PU,
    var itfpu: PU,
    var kcd: PU,
    var kramp: Simple_Float
)

data class DeleteOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID? = null)

// single association events
data class AssignHystToOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID, val assignment: PU )
data class UnAssignHystFromOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID? = null )
data class AssignIfdlimToOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID, val assignment: PU )
data class UnAssignIfdlimFromOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID? = null )
data class AssignIfdmaxToOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID, val assignment: PU )
data class UnAssignIfdmaxFromOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID? = null )
data class AssignItfpuToOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID, val assignment: PU )
data class UnAssignItfpuFromOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID? = null )
data class AssignKcdToOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID, val assignment: PU )
data class UnAssignKcdFromOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID? = null )
data class AssignKrampToOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID, val assignment: Simple_Float )
data class UnAssignKrampFromOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID? = null )

// multiple association events


// OverexcLimX1 Events

data class CreateOverexcLimX1Event(
     var overexcLimX1Id: UUID? = null
)

data class UpdateOverexcLimX1Event(
    @Id var overexcLimX1Id: UUID? = null,
    var efd1: PU,
    var efd2: PU,
    var efd3: PU,
    var efddes: PU,
    var efdrated: PU,
    var kmx: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var vlow: PU
)

data class DeleteOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null)

// single association events
data class AssignEfd1ToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: PU )
data class UnAssignEfd1FromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignEfd2ToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: PU )
data class UnAssignEfd2FromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignEfd3ToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: PU )
data class UnAssignEfd3FromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignEfddesToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: PU )
data class UnAssignEfddesFromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignEfdratedToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: PU )
data class UnAssignEfdratedFromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignKmxToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: PU )
data class UnAssignKmxFromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignT1ToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: Seconds )
data class UnAssignT1FromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignT2ToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: Seconds )
data class UnAssignT2FromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignT3ToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: Seconds )
data class UnAssignT3FromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )
data class AssignVlowToOverexcLimX1Event(@Id val overexcLimX1Id: UUID, val assignment: PU )
data class UnAssignVlowFromOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null )

// multiple association events


// OverexcLimX2 Events

data class CreateOverexcLimX2Event(
     var overexcLimX2Id: UUID? = null
)

data class UpdateOverexcLimX2Event(
    @Id var overexcLimX2Id: UUID? = null,
    var efd1: PU,
    var efd2: PU,
    var efd3: PU,
    var efddes: PU,
    var efdrated: PU,
    var kmx: PU,
    var m: BooleanProxy,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var vlow: PU
)

data class DeleteOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null)

// single association events
data class AssignEfd1ToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: PU )
data class UnAssignEfd1FromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignEfd2ToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: PU )
data class UnAssignEfd2FromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignEfd3ToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: PU )
data class UnAssignEfd3FromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignEfddesToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: PU )
data class UnAssignEfddesFromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignEfdratedToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: PU )
data class UnAssignEfdratedFromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignKmxToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: PU )
data class UnAssignKmxFromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignMToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: BooleanProxy )
data class UnAssignMFromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignT1ToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: Seconds )
data class UnAssignT1FromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignT2ToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: Seconds )
data class UnAssignT2FromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignT3ToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: Seconds )
data class UnAssignT3FromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )
data class AssignVlowToOverexcLimX2Event(@Id val overexcLimX2Id: UUID, val assignment: PU )
data class UnAssignVlowFromOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null )

// multiple association events


// OverexcitationLimiterDynamics Events

data class CreateOverexcitationLimiterDynamicsEvent(
     var overexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateOverexcitationLimiterDynamicsEvent(
    @Id var overexcitationLimiterDynamicsId: UUID? = null,
    var overexcitationLimiterDynamics: OverexcitationLimiterDynamics
)

data class DeleteOverexcitationLimiterDynamicsEvent(@Id val overexcitationLimiterDynamicsId: UUID? = null)

// single association events
data class AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsEvent(@Id val overexcitationLimiterDynamicsId: UUID, val assignment: OverexcitationLimiterDynamics )
data class UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsEvent(@Id val overexcitationLimiterDynamicsId: UUID? = null )

// multiple association events


// OverexcitationLimiterUserDefined Events

data class CreateOverexcitationLimiterUserDefinedEvent(
     var overexcitationLimiterUserDefinedId: UUID? = null
)

data class UpdateOverexcitationLimiterUserDefinedEvent(
    @Id var overexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteOverexcitationLimiterUserDefinedEvent(@Id val overexcitationLimiterUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToOverexcitationLimiterUserDefinedEvent(@Id val overexcitationLimiterUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromOverexcitationLimiterUserDefinedEvent(@Id val overexcitationLimiterUserDefinedId: UUID? = null )

// multiple association events


// PFVArControllerType1Dynamics Events

data class CreatePFVArControllerType1DynamicsEvent(
     var pFVArControllerType1DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType1DynamicsEvent(
    @Id var pFVArControllerType1DynamicsId: UUID? = null,
    var pFVArControllerType1Dynamics: PFVArControllerType1Dynamics
)

data class DeletePFVArControllerType1DynamicsEvent(@Id val pFVArControllerType1DynamicsId: UUID? = null)

// single association events
data class AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsEvent(@Id val pFVArControllerType1DynamicsId: UUID, val assignment: PFVArControllerType1Dynamics )
data class UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsEvent(@Id val pFVArControllerType1DynamicsId: UUID? = null )

// multiple association events


// PFVArControllerType1UserDefined Events

data class CreatePFVArControllerType1UserDefinedEvent(
     var pFVArControllerType1UserDefinedId: UUID? = null
)

data class UpdatePFVArControllerType1UserDefinedEvent(
    @Id var pFVArControllerType1UserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeletePFVArControllerType1UserDefinedEvent(@Id val pFVArControllerType1UserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToPFVArControllerType1UserDefinedEvent(@Id val pFVArControllerType1UserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromPFVArControllerType1UserDefinedEvent(@Id val pFVArControllerType1UserDefinedId: UUID? = null )

// multiple association events


// PFVArControllerType2Dynamics Events

data class CreatePFVArControllerType2DynamicsEvent(
     var pFVArControllerType2DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType2DynamicsEvent(
    @Id var pFVArControllerType2DynamicsId: UUID? = null,
    var pFVArControllerType2Dynamics: PFVArControllerType2Dynamics
)

data class DeletePFVArControllerType2DynamicsEvent(@Id val pFVArControllerType2DynamicsId: UUID? = null)

// single association events
data class AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsEvent(@Id val pFVArControllerType2DynamicsId: UUID, val assignment: PFVArControllerType2Dynamics )
data class UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsEvent(@Id val pFVArControllerType2DynamicsId: UUID? = null )

// multiple association events


// PFVArControllerType2UserDefined Events

data class CreatePFVArControllerType2UserDefinedEvent(
     var pFVArControllerType2UserDefinedId: UUID? = null
)

data class UpdatePFVArControllerType2UserDefinedEvent(
    @Id var pFVArControllerType2UserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeletePFVArControllerType2UserDefinedEvent(@Id val pFVArControllerType2UserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToPFVArControllerType2UserDefinedEvent(@Id val pFVArControllerType2UserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromPFVArControllerType2UserDefinedEvent(@Id val pFVArControllerType2UserDefinedId: UUID? = null )

// multiple association events


// PFVArType1IEEEPFController Events

data class CreatePFVArType1IEEEPFControllerEvent(
     var pFVArType1IEEEPFControllerId: UUID? = null
)

data class UpdatePFVArType1IEEEPFControllerEvent(
    @Id var pFVArType1IEEEPFControllerId: UUID? = null,
    var ovex: BooleanProxy,
    var tpfc: Seconds,
    var vitmin: PU,
    var vpf: PU,
    var vpfcbw: Simple_Float,
    var vpfref: PU,
    var vvtmax: PU,
    var vvtmin: PU
)

data class DeletePFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null)

// single association events
data class AssignOvexToPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID, val assignment: BooleanProxy )
data class UnAssignOvexFromPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null )
data class AssignTpfcToPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID, val assignment: Seconds )
data class UnAssignTpfcFromPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null )
data class AssignVitminToPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignVitminFromPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null )
data class AssignVpfToPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignVpfFromPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null )
data class AssignVpfcbwToPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID, val assignment: Simple_Float )
data class UnAssignVpfcbwFromPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null )
data class AssignVpfrefToPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignVpfrefFromPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null )
data class AssignVvtmaxToPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignVvtmaxFromPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null )
data class AssignVvtminToPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignVvtminFromPFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null )

// multiple association events


// PFVArType1IEEEVArController Events

data class CreatePFVArType1IEEEVArControllerEvent(
     var pFVArType1IEEEVArControllerId: UUID? = null
)

data class UpdatePFVArType1IEEEVArControllerEvent(
    @Id var pFVArType1IEEEVArControllerId: UUID? = null,
    var tvarc: Seconds,
    var vvar: PU,
    var vvarcbw: Simple_Float,
    var vvarref: PU,
    var vvtmax: PU,
    var vvtmin: PU
)

data class DeletePFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID? = null)

// single association events
data class AssignTvarcToPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID, val assignment: Seconds )
data class UnAssignTvarcFromPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID? = null )
data class AssignVvarToPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignVvarFromPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID? = null )
data class AssignVvarcbwToPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID, val assignment: Simple_Float )
data class UnAssignVvarcbwFromPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID? = null )
data class AssignVvarrefToPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignVvarrefFromPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID? = null )
data class AssignVvtmaxToPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignVvtmaxFromPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID? = null )
data class AssignVvtminToPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignVvtminFromPFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID? = null )

// multiple association events


// PFVArType2Common1 Events

data class CreatePFVArType2Common1Event(
     var pFVArType2Common1Id: UUID? = null
)

data class UpdatePFVArType2Common1Event(
    @Id var pFVArType2Common1Id: UUID? = null,
    var j: BooleanProxy,
    var ki: PU,
    var kp: PU,
    var max: PU,
    var ref: PU
)

data class DeletePFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID? = null)

// single association events
data class AssignJToPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID, val assignment: BooleanProxy )
data class UnAssignJFromPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID? = null )
data class AssignKiToPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID, val assignment: PU )
data class UnAssignKiFromPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID? = null )
data class AssignKpToPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID, val assignment: PU )
data class UnAssignKpFromPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID? = null )
data class AssignMaxToPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID, val assignment: PU )
data class UnAssignMaxFromPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID? = null )
data class AssignRefToPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID, val assignment: PU )
data class UnAssignRefFromPFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID? = null )

// multiple association events


// PFVArType2IEEEPFController Events

data class CreatePFVArType2IEEEPFControllerEvent(
     var pFVArType2IEEEPFControllerId: UUID? = null
)

data class UpdatePFVArType2IEEEPFControllerEvent(
    @Id var pFVArType2IEEEPFControllerId: UUID? = null,
    var exlon: BooleanProxy,
    var ki: PU,
    var kp: PU,
    var pfref: PU,
    var vclmt: PU,
    var vref: PU,
    var vs: Simple_Float
)

data class DeletePFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null)

// single association events
data class AssignExlonToPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID, val assignment: BooleanProxy )
data class UnAssignExlonFromPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null )
data class AssignKiToPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignKiFromPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null )
data class AssignKpToPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignKpFromPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null )
data class AssignPfrefToPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignPfrefFromPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null )
data class AssignVclmtToPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignVclmtFromPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null )
data class AssignVrefToPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID, val assignment: PU )
data class UnAssignVrefFromPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null )
data class AssignVsToPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID, val assignment: Simple_Float )
data class UnAssignVsFromPFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null )

// multiple association events


// PFVArType2IEEEVArController Events

data class CreatePFVArType2IEEEVArControllerEvent(
     var pFVArType2IEEEVArControllerId: UUID? = null
)

data class UpdatePFVArType2IEEEVArControllerEvent(
    @Id var pFVArType2IEEEVArControllerId: UUID? = null,
    var exlon: BooleanProxy,
    var ki: PU,
    var kp: PU,
    var qref: PU,
    var vclmt: PU,
    var vref: PU,
    var vs: Simple_Float
)

data class DeletePFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null)

// single association events
data class AssignExlonToPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID, val assignment: BooleanProxy )
data class UnAssignExlonFromPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null )
data class AssignKiToPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignKiFromPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null )
data class AssignKpToPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignKpFromPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null )
data class AssignQrefToPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignQrefFromPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null )
data class AssignVclmtToPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignVclmtFromPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null )
data class AssignVrefToPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID, val assignment: PU )
data class UnAssignVrefFromPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null )
data class AssignVsToPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID, val assignment: Simple_Float )
data class UnAssignVsFromPFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null )

// multiple association events


// PU Events

data class CreatePUEvent(
    @Id var pUId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdatePUEvent(
    @Id var pUId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeletePUEvent(@Id val pUId: UUID? = null)

// single association events
data class AssignValueToPUEvent(@Id val pUId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromPUEvent(@Id val pUId: UUID? = null )

// multiple association events


// PerCent Events

data class CreatePerCentEvent(
    @Id var perCentId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdatePerCentEvent(
    @Id var perCentId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeletePerCentEvent(@Id val perCentId: UUID? = null)

// single association events
data class AssignValueToPerCentEvent(@Id val perCentId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromPerCentEvent(@Id val perCentId: UUID? = null )

// multiple association events


// PerLengthDCLineParameter Events

data class CreatePerLengthDCLineParameterEvent(
     var perLengthDCLineParameterId: UUID? = null
)

data class UpdatePerLengthDCLineParameterEvent(
    @Id var perLengthDCLineParameterId: UUID? = null,
    var capacitance: CapacitancePerLength,
    var inductance: InductancePerLength,
    var resistance: ResistancePerLength
)

data class DeletePerLengthDCLineParameterEvent(@Id val perLengthDCLineParameterId: UUID? = null)

// single association events
data class AssignCapacitanceToPerLengthDCLineParameterEvent(@Id val perLengthDCLineParameterId: UUID, val assignment: CapacitancePerLength )
data class UnAssignCapacitanceFromPerLengthDCLineParameterEvent(@Id val perLengthDCLineParameterId: UUID? = null )
data class AssignInductanceToPerLengthDCLineParameterEvent(@Id val perLengthDCLineParameterId: UUID, val assignment: InductancePerLength )
data class UnAssignInductanceFromPerLengthDCLineParameterEvent(@Id val perLengthDCLineParameterId: UUID? = null )
data class AssignResistanceToPerLengthDCLineParameterEvent(@Id val perLengthDCLineParameterId: UUID, val assignment: ResistancePerLength )
data class UnAssignResistanceFromPerLengthDCLineParameterEvent(@Id val perLengthDCLineParameterId: UUID? = null )

// multiple association events


// PetersenCoil Events

data class CreatePetersenCoilEvent(
    @Id var petersenCoilId: UUID? = null,
    @Enumerated(EnumType.STRING) var mode: PetersenCoilModeKind
)

data class UpdatePetersenCoilEvent(
    @Id var petersenCoilId: UUID? = null,
    @Enumerated(EnumType.STRING) var mode: PetersenCoilModeKind,
    var nominalU: Voltage,
    var offsetCurrent: CurrentFlow,
    var positionCurrent: CurrentFlow,
    var xGroundMax: Reactance,
    var xGroundMin: Reactance,
    var xGroundNominal: Reactance
)

data class DeletePetersenCoilEvent(@Id val petersenCoilId: UUID? = null)

// single association events
data class AssignNominalUToPetersenCoilEvent(@Id val petersenCoilId: UUID, val assignment: Voltage )
data class UnAssignNominalUFromPetersenCoilEvent(@Id val petersenCoilId: UUID? = null )
data class AssignOffsetCurrentToPetersenCoilEvent(@Id val petersenCoilId: UUID, val assignment: CurrentFlow )
data class UnAssignOffsetCurrentFromPetersenCoilEvent(@Id val petersenCoilId: UUID? = null )
data class AssignPositionCurrentToPetersenCoilEvent(@Id val petersenCoilId: UUID, val assignment: CurrentFlow )
data class UnAssignPositionCurrentFromPetersenCoilEvent(@Id val petersenCoilId: UUID? = null )
data class AssignXGroundMaxToPetersenCoilEvent(@Id val petersenCoilId: UUID, val assignment: Reactance )
data class UnAssignXGroundMaxFromPetersenCoilEvent(@Id val petersenCoilId: UUID? = null )
data class AssignXGroundMinToPetersenCoilEvent(@Id val petersenCoilId: UUID, val assignment: Reactance )
data class UnAssignXGroundMinFromPetersenCoilEvent(@Id val petersenCoilId: UUID? = null )
data class AssignXGroundNominalToPetersenCoilEvent(@Id val petersenCoilId: UUID, val assignment: Reactance )
data class UnAssignXGroundNominalFromPetersenCoilEvent(@Id val petersenCoilId: UUID? = null )

// multiple association events


// PhaseTapChanger Events

data class CreatePhaseTapChangerEvent(
     var phaseTapChangerId: UUID? = null
)

data class UpdatePhaseTapChangerEvent(
    @Id var phaseTapChangerId: UUID? = null,
    var phaseTapChanger: PhaseTapChanger
)

data class DeletePhaseTapChangerEvent(@Id val phaseTapChangerId: UUID? = null)

// single association events
data class AssignPhaseTapChangerToPhaseTapChangerEvent(@Id val phaseTapChangerId: UUID, val assignment: PhaseTapChanger )
data class UnAssignPhaseTapChangerFromPhaseTapChangerEvent(@Id val phaseTapChangerId: UUID? = null )

// multiple association events


// PhaseTapChangerAsymmetrical Events

data class CreatePhaseTapChangerAsymmetricalEvent(
     var phaseTapChangerAsymmetricalId: UUID? = null
)

data class UpdatePhaseTapChangerAsymmetricalEvent(
    @Id var phaseTapChangerAsymmetricalId: UUID? = null,
    var windingConnectionAngle: AngleDegrees
)

data class DeletePhaseTapChangerAsymmetricalEvent(@Id val phaseTapChangerAsymmetricalId: UUID? = null)

// single association events
data class AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalEvent(@Id val phaseTapChangerAsymmetricalId: UUID, val assignment: AngleDegrees )
data class UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalEvent(@Id val phaseTapChangerAsymmetricalId: UUID? = null )

// multiple association events


// PhaseTapChangerLinear Events

data class CreatePhaseTapChangerLinearEvent(
     var phaseTapChangerLinearId: UUID? = null
)

data class UpdatePhaseTapChangerLinearEvent(
    @Id var phaseTapChangerLinearId: UUID? = null,
    var stepPhaseShiftIncrement: AngleDegrees,
    var xMax: Reactance,
    var xMin: Reactance
)

data class DeletePhaseTapChangerLinearEvent(@Id val phaseTapChangerLinearId: UUID? = null)

// single association events
data class AssignStepPhaseShiftIncrementToPhaseTapChangerLinearEvent(@Id val phaseTapChangerLinearId: UUID, val assignment: AngleDegrees )
data class UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearEvent(@Id val phaseTapChangerLinearId: UUID? = null )
data class AssignXMaxToPhaseTapChangerLinearEvent(@Id val phaseTapChangerLinearId: UUID, val assignment: Reactance )
data class UnAssignXMaxFromPhaseTapChangerLinearEvent(@Id val phaseTapChangerLinearId: UUID? = null )
data class AssignXMinToPhaseTapChangerLinearEvent(@Id val phaseTapChangerLinearId: UUID, val assignment: Reactance )
data class UnAssignXMinFromPhaseTapChangerLinearEvent(@Id val phaseTapChangerLinearId: UUID? = null )

// multiple association events


// PhaseTapChangerNonLinear Events

data class CreatePhaseTapChangerNonLinearEvent(
     var phaseTapChangerNonLinearId: UUID? = null
)

data class UpdatePhaseTapChangerNonLinearEvent(
    @Id var phaseTapChangerNonLinearId: UUID? = null,
    var voltageStepIncrement: PerCent,
    var xMax: Reactance,
    var xMin: Reactance
)

data class DeletePhaseTapChangerNonLinearEvent(@Id val phaseTapChangerNonLinearId: UUID? = null)

// single association events
data class AssignVoltageStepIncrementToPhaseTapChangerNonLinearEvent(@Id val phaseTapChangerNonLinearId: UUID, val assignment: PerCent )
data class UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearEvent(@Id val phaseTapChangerNonLinearId: UUID? = null )
data class AssignXMaxToPhaseTapChangerNonLinearEvent(@Id val phaseTapChangerNonLinearId: UUID, val assignment: Reactance )
data class UnAssignXMaxFromPhaseTapChangerNonLinearEvent(@Id val phaseTapChangerNonLinearId: UUID? = null )
data class AssignXMinToPhaseTapChangerNonLinearEvent(@Id val phaseTapChangerNonLinearId: UUID, val assignment: Reactance )
data class UnAssignXMinFromPhaseTapChangerNonLinearEvent(@Id val phaseTapChangerNonLinearId: UUID? = null )

// multiple association events


// PhaseTapChangerSymmetrical Events

data class CreatePhaseTapChangerSymmetricalEvent(
     var phaseTapChangerSymmetricalId: UUID? = null
)

data class UpdatePhaseTapChangerSymmetricalEvent(
     var phaseTapChangerSymmetricalId: UUID? = null
)

data class DeletePhaseTapChangerSymmetricalEvent(@Id val phaseTapChangerSymmetricalId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerTable Events

data class CreatePhaseTapChangerTableEvent(
     var phaseTapChangerTableId: UUID? = null
)

data class UpdatePhaseTapChangerTableEvent(
     var phaseTapChangerTableId: UUID? = null
)

data class DeletePhaseTapChangerTableEvent(@Id val phaseTapChangerTableId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerTablePoint Events

data class CreatePhaseTapChangerTablePointEvent(
     var phaseTapChangerTablePointId: UUID? = null
)

data class UpdatePhaseTapChangerTablePointEvent(
    @Id var phaseTapChangerTablePointId: UUID? = null,
    var angle: AngleDegrees,
    var phaseTapChangerTablePoint:  Set<PhaseTapChangerTablePoint>
)

data class DeletePhaseTapChangerTablePointEvent(@Id val phaseTapChangerTablePointId: UUID? = null)

// single association events
data class AssignAngleToPhaseTapChangerTablePointEvent(@Id val phaseTapChangerTablePointId: UUID, val assignment: AngleDegrees )
data class UnAssignAngleFromPhaseTapChangerTablePointEvent(@Id val phaseTapChangerTablePointId: UUID? = null )

// multiple association events
data class AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointEvent(@Id val phaseTapChangerTablePointId: UUID, val addTo: PhaseTapChangerTablePoint )
data class RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointEvent(@Id val phaseTapChangerTablePointId: UUID, val removeFrom: PhaseTapChangerTablePoint )


// PhaseTapChangerTabular Events

data class CreatePhaseTapChangerTabularEvent(
     var phaseTapChangerTabularId: UUID? = null
)

data class UpdatePhaseTapChangerTabularEvent(
    @Id var phaseTapChangerTabularId: UUID? = null,
    var phaseTapChangerTabular:  Set<PhaseTapChangerTabular>
)

data class DeletePhaseTapChangerTabularEvent(@Id val phaseTapChangerTabularId: UUID? = null)

// single association events

// multiple association events
data class AssignPhaseTapChangerTabularToPhaseTapChangerTabularEvent(@Id val phaseTapChangerTabularId: UUID, val addTo: PhaseTapChangerTabular )
data class RemovePhaseTapChangerTabularFromPhaseTapChangerTabularEvent(@Id val phaseTapChangerTabularId: UUID, val removeFrom: PhaseTapChangerTabular )


// PositionPoint Events

data class CreatePositionPointEvent(
     var positionPointId: UUID? = null
)

data class UpdatePositionPointEvent(
    @Id var positionPointId: UUID? = null,
    var sequenceNumber: IntegerProxy,
    var xPosition: StringProxy,
    var yPosition: StringProxy,
    var zPosition: StringProxy,
    var positionPoints:  Set<PositionPoint>
)

data class DeletePositionPointEvent(@Id val positionPointId: UUID? = null)

// single association events
data class AssignSequenceNumberToPositionPointEvent(@Id val positionPointId: UUID, val assignment: IntegerProxy )
data class UnAssignSequenceNumberFromPositionPointEvent(@Id val positionPointId: UUID? = null )
data class AssignXPositionToPositionPointEvent(@Id val positionPointId: UUID, val assignment: StringProxy )
data class UnAssignXPositionFromPositionPointEvent(@Id val positionPointId: UUID? = null )
data class AssignYPositionToPositionPointEvent(@Id val positionPointId: UUID, val assignment: StringProxy )
data class UnAssignYPositionFromPositionPointEvent(@Id val positionPointId: UUID? = null )
data class AssignZPositionToPositionPointEvent(@Id val positionPointId: UUID, val assignment: StringProxy )
data class UnAssignZPositionFromPositionPointEvent(@Id val positionPointId: UUID? = null )

// multiple association events
data class AssignPositionPointsToPositionPointEvent(@Id val positionPointId: UUID, val addTo: PositionPoint )
data class RemovePositionPointsFromPositionPointEvent(@Id val positionPointId: UUID, val removeFrom: PositionPoint )


// PowerSystemResource Events

data class CreatePowerSystemResourceEvent(
     var powerSystemResourceId: UUID? = null
)

data class UpdatePowerSystemResourceEvent(
     var powerSystemResourceId: UUID? = null
)

data class DeletePowerSystemResourceEvent(@Id val powerSystemResourceId: UUID? = null)

// single association events

// multiple association events


// PowerSystemStabilizerDynamics Events

data class CreatePowerSystemStabilizerDynamicsEvent(
     var powerSystemStabilizerDynamicsId: UUID? = null
)

data class UpdatePowerSystemStabilizerDynamicsEvent(
    @Id var powerSystemStabilizerDynamicsId: UUID? = null,
    var powerSystemStabilizerDynamics: PowerSystemStabilizerDynamics
)

data class DeletePowerSystemStabilizerDynamicsEvent(@Id val powerSystemStabilizerDynamicsId: UUID? = null)

// single association events
data class AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsEvent(@Id val powerSystemStabilizerDynamicsId: UUID, val assignment: PowerSystemStabilizerDynamics )
data class UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsEvent(@Id val powerSystemStabilizerDynamicsId: UUID? = null )

// multiple association events


// PowerSystemStabilizerUserDefined Events

data class CreatePowerSystemStabilizerUserDefinedEvent(
     var powerSystemStabilizerUserDefinedId: UUID? = null
)

data class UpdatePowerSystemStabilizerUserDefinedEvent(
    @Id var powerSystemStabilizerUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeletePowerSystemStabilizerUserDefinedEvent(@Id val powerSystemStabilizerUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToPowerSystemStabilizerUserDefinedEvent(@Id val powerSystemStabilizerUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromPowerSystemStabilizerUserDefinedEvent(@Id val powerSystemStabilizerUserDefinedId: UUID? = null )

// multiple association events


// PowerTransformer Events

data class CreatePowerTransformerEvent(
     var powerTransformerId: UUID? = null
)

data class UpdatePowerTransformerEvent(
    @Id var powerTransformerId: UUID? = null,
    var beforeShCircuitHighestOperatingCurrent: CurrentFlow,
    var beforeShCircuitHighestOperatingVoltage: Voltage,
    var beforeShortCircuitAnglePf: AngleDegrees,
    var highSideMinOperatingU: Voltage,
    var partOfGeneratorUnitFlag: BooleanProxy,
    var operationalValuesConsidered: BooleanProxy
)

data class DeletePowerTransformerEvent(@Id val powerTransformerId: UUID? = null)

// single association events
data class AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerEvent(@Id val powerTransformerId: UUID, val assignment: CurrentFlow )
data class UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerEvent(@Id val powerTransformerId: UUID? = null )
data class AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerEvent(@Id val powerTransformerId: UUID, val assignment: Voltage )
data class UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerEvent(@Id val powerTransformerId: UUID? = null )
data class AssignBeforeShortCircuitAnglePfToPowerTransformerEvent(@Id val powerTransformerId: UUID, val assignment: AngleDegrees )
data class UnAssignBeforeShortCircuitAnglePfFromPowerTransformerEvent(@Id val powerTransformerId: UUID? = null )
data class AssignHighSideMinOperatingUToPowerTransformerEvent(@Id val powerTransformerId: UUID, val assignment: Voltage )
data class UnAssignHighSideMinOperatingUFromPowerTransformerEvent(@Id val powerTransformerId: UUID? = null )
data class AssignPartOfGeneratorUnitFlagToPowerTransformerEvent(@Id val powerTransformerId: UUID, val assignment: BooleanProxy )
data class UnAssignPartOfGeneratorUnitFlagFromPowerTransformerEvent(@Id val powerTransformerId: UUID? = null )
data class AssignOperationalValuesConsideredToPowerTransformerEvent(@Id val powerTransformerId: UUID, val assignment: BooleanProxy )
data class UnAssignOperationalValuesConsideredFromPowerTransformerEvent(@Id val powerTransformerId: UUID? = null )

// multiple association events


// PowerTransformerEnd Events

data class CreatePowerTransformerEndEvent(
    @Id var powerTransformerEndId: UUID? = null,
    @Enumerated(EnumType.STRING) var connectionKind: WindingConnection
)

data class UpdatePowerTransformerEndEvent(
    @Id var powerTransformerEndId: UUID? = null,
    var b: Susceptance,
    var b0: Susceptance,
    @Enumerated(EnumType.STRING) var connectionKind: WindingConnection,
    var g: Conductance,
    var g0: Conductance,
    var phaseAngleClock: IntegerProxy,
    var r: Resistance,
    var r0: Resistance,
    var ratedS: ApparentPower,
    var ratedU: Voltage,
    var x: Reactance,
    var x0: Reactance,
    var powerTransformerEnd:  Set<PowerTransformerEnd>
)

data class DeletePowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null)

// single association events
data class AssignBToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Susceptance )
data class UnAssignBFromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignB0ToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Susceptance )
data class UnAssignB0FromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignGToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Conductance )
data class UnAssignGFromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignG0ToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Conductance )
data class UnAssignG0FromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignPhaseAngleClockToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: IntegerProxy )
data class UnAssignPhaseAngleClockFromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignRToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Resistance )
data class UnAssignRFromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignR0ToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Resistance )
data class UnAssignR0FromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignRatedSToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: ApparentPower )
data class UnAssignRatedSFromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignRatedUToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Voltage )
data class UnAssignRatedUFromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignXToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Reactance )
data class UnAssignXFromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )
data class AssignX0ToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val assignment: Reactance )
data class UnAssignX0FromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null )

// multiple association events
data class AssignPowerTransformerEndToPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val addTo: PowerTransformerEnd )
data class RemovePowerTransformerEndFromPowerTransformerEndEvent(@Id val powerTransformerEndId: UUID, val removeFrom: PowerTransformerEnd )


// ProprietaryParameterDynamics Events

data class CreateProprietaryParameterDynamicsEvent(
     var proprietaryParameterDynamicsId: UUID? = null
)

data class UpdateProprietaryParameterDynamicsEvent(
    @Id var proprietaryParameterDynamicsId: UUID? = null,
    var booleanParameterValue: BooleanProxy,
    var floatParameterValue: Simple_Float,
    var integerParameterValue: IntegerProxy,
    var parameterNumber: IntegerProxy,
    var proprietaryParameterDynamics:  Set<ProprietaryParameterDynamics>
)

data class DeleteProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID? = null)

// single association events
data class AssignBooleanParameterValueToProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID, val assignment: BooleanProxy )
data class UnAssignBooleanParameterValueFromProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID? = null )
data class AssignFloatParameterValueToProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID, val assignment: Simple_Float )
data class UnAssignFloatParameterValueFromProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID? = null )
data class AssignIntegerParameterValueToProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID, val assignment: IntegerProxy )
data class UnAssignIntegerParameterValueFromProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID? = null )
data class AssignParameterNumberToProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID, val assignment: IntegerProxy )
data class UnAssignParameterNumberFromProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID? = null )

// multiple association events
data class AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID, val addTo: ProprietaryParameterDynamics )
data class RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID, val removeFrom: ProprietaryParameterDynamics )


// ProtectedSwitch Events

data class CreateProtectedSwitchEvent(
     var protectedSwitchId: UUID? = null
)

data class UpdateProtectedSwitchEvent(
     var protectedSwitchId: UUID? = null
)

data class DeleteProtectedSwitchEvent(@Id val protectedSwitchId: UUID? = null)

// single association events

// multiple association events


// Pss1 Events

data class CreatePss1Event(
     var pss1Id: UUID? = null
)

data class UpdatePss1Event(
    @Id var pss1Id: UUID? = null,
    var kf: Simple_Float,
    var kpe: Simple_Float,
    var ks: Simple_Float,
    var kw: Simple_Float,
    var pmin: PU,
    var t10: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var t7: Seconds,
    var t8: Seconds,
    var t9: Seconds,
    var tpe: Seconds,
    var vadat: BooleanProxy,
    var vsmn: PU,
    var vsmx: PU
)

data class DeletePss1Event(@Id val pss1Id: UUID? = null)

// single association events
data class AssignKfToPss1Event(@Id val pss1Id: UUID, val assignment: Simple_Float )
data class UnAssignKfFromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignKpeToPss1Event(@Id val pss1Id: UUID, val assignment: Simple_Float )
data class UnAssignKpeFromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignKsToPss1Event(@Id val pss1Id: UUID, val assignment: Simple_Float )
data class UnAssignKsFromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignKwToPss1Event(@Id val pss1Id: UUID, val assignment: Simple_Float )
data class UnAssignKwFromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignPminToPss1Event(@Id val pss1Id: UUID, val assignment: PU )
data class UnAssignPminFromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignT10ToPss1Event(@Id val pss1Id: UUID, val assignment: Seconds )
data class UnAssignT10FromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignT5ToPss1Event(@Id val pss1Id: UUID, val assignment: Seconds )
data class UnAssignT5FromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignT6ToPss1Event(@Id val pss1Id: UUID, val assignment: Seconds )
data class UnAssignT6FromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignT7ToPss1Event(@Id val pss1Id: UUID, val assignment: Seconds )
data class UnAssignT7FromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignT8ToPss1Event(@Id val pss1Id: UUID, val assignment: Seconds )
data class UnAssignT8FromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignT9ToPss1Event(@Id val pss1Id: UUID, val assignment: Seconds )
data class UnAssignT9FromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignTpeToPss1Event(@Id val pss1Id: UUID, val assignment: Seconds )
data class UnAssignTpeFromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignVadatToPss1Event(@Id val pss1Id: UUID, val assignment: BooleanProxy )
data class UnAssignVadatFromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignVsmnToPss1Event(@Id val pss1Id: UUID, val assignment: PU )
data class UnAssignVsmnFromPss1Event(@Id val pss1Id: UUID? = null )
data class AssignVsmxToPss1Event(@Id val pss1Id: UUID, val assignment: PU )
data class UnAssignVsmxFromPss1Event(@Id val pss1Id: UUID? = null )

// multiple association events


// Pss1A Events

data class CreatePss1AEvent(
    @Id var pss1AId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignalType: InputSignalKind
)

data class UpdatePss1AEvent(
    @Id var pss1AId: UUID? = null,
    var a1: PU,
    var a2: PU,
    var a3: PU,
    var a4: PU,
    var a5: PU,
    var a6: PU,
    var a7: PU,
    var a8: PU,
    @Enumerated(EnumType.STRING) var inputSignalType: InputSignalKind,
    var kd: BooleanProxy,
    var ks: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var tdelay: Seconds,
    var vcl: PU,
    var vcu: PU,
    var vrmax: PU,
    var vrmin: PU
)

data class DeletePss1AEvent(@Id val pss1AId: UUID? = null)

// single association events
data class AssignA1ToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignA1FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignA2ToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignA2FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignA3ToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignA3FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignA4ToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignA4FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignA5ToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignA5FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignA6ToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignA6FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignA7ToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignA7FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignA8ToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignA8FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignKdToPss1AEvent(@Id val pss1AId: UUID, val assignment: BooleanProxy )
data class UnAssignKdFromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignKsToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignKsFromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignT1ToPss1AEvent(@Id val pss1AId: UUID, val assignment: Seconds )
data class UnAssignT1FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignT2ToPss1AEvent(@Id val pss1AId: UUID, val assignment: Seconds )
data class UnAssignT2FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignT3ToPss1AEvent(@Id val pss1AId: UUID, val assignment: Seconds )
data class UnAssignT3FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignT4ToPss1AEvent(@Id val pss1AId: UUID, val assignment: Seconds )
data class UnAssignT4FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignT5ToPss1AEvent(@Id val pss1AId: UUID, val assignment: Seconds )
data class UnAssignT5FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignT6ToPss1AEvent(@Id val pss1AId: UUID, val assignment: Seconds )
data class UnAssignT6FromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignTdelayToPss1AEvent(@Id val pss1AId: UUID, val assignment: Seconds )
data class UnAssignTdelayFromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignVclToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignVclFromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignVcuToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignVcuFromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignVrmaxToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromPss1AEvent(@Id val pss1AId: UUID? = null )
data class AssignVrminToPss1AEvent(@Id val pss1AId: UUID, val assignment: PU )
data class UnAssignVrminFromPss1AEvent(@Id val pss1AId: UUID? = null )

// multiple association events


// Pss2B Events

data class CreatePss2BEvent(
    @Id var pss2BId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind
)

data class UpdatePss2BEvent(
    @Id var pss2BId: UUID? = null,
    var a: Simple_Float,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind,
    var ks1: PU,
    var ks2: PU,
    var ks3: PU,
    var ks4: PU,
    var m: IntegerProxy,
    var n: IntegerProxy,
    var t1: Seconds,
    var t10: Seconds,
    var t11: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t6: Seconds,
    var t7: Seconds,
    var t8: Seconds,
    var t9: Seconds,
    var ta: Seconds,
    var tb: Seconds,
    var tw1: Seconds,
    var tw2: Seconds,
    var tw3: Seconds,
    var tw4: Seconds,
    var vsi1max: PU,
    var vsi1min: PU,
    var vsi2max: PU,
    var vsi2min: PU,
    var vstmax: PU,
    var vstmin: PU
)

data class DeletePss2BEvent(@Id val pss2BId: UUID? = null)

// single association events
data class AssignAToPss2BEvent(@Id val pss2BId: UUID, val assignment: Simple_Float )
data class UnAssignAFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignKs1ToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignKs1FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignKs2ToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignKs2FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignKs3ToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignKs3FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignKs4ToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignKs4FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignMToPss2BEvent(@Id val pss2BId: UUID, val assignment: IntegerProxy )
data class UnAssignMFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignNToPss2BEvent(@Id val pss2BId: UUID, val assignment: IntegerProxy )
data class UnAssignNFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT1ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT1FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT10ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT10FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT11ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT11FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT2ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT2FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT3ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT3FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT4ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT4FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT6ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT6FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT7ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT7FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT8ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT8FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignT9ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignT9FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignTaToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignTaFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignTbToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignTbFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignTw1ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignTw1FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignTw2ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignTw2FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignTw3ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignTw3FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignTw4ToPss2BEvent(@Id val pss2BId: UUID, val assignment: Seconds )
data class UnAssignTw4FromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignVsi1maxToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignVsi1maxFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignVsi1minToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignVsi1minFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignVsi2maxToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignVsi2maxFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignVsi2minToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignVsi2minFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignVstmaxToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignVstmaxFromPss2BEvent(@Id val pss2BId: UUID? = null )
data class AssignVstminToPss2BEvent(@Id val pss2BId: UUID, val assignment: PU )
data class UnAssignVstminFromPss2BEvent(@Id val pss2BId: UUID? = null )

// multiple association events


// Pss2ST Events

data class CreatePss2STEvent(
    @Id var pss2STId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind
)

data class UpdatePss2STEvent(
    @Id var pss2STId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind,
    var k1: PU,
    var k2: PU,
    var lsmax: PU,
    var lsmin: PU,
    var t1: Seconds,
    var t10: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var t7: Seconds,
    var t8: Seconds,
    var t9: Seconds,
    var vcl: PU,
    var vcu: PU
)

data class DeletePss2STEvent(@Id val pss2STId: UUID? = null)

// single association events
data class AssignK1ToPss2STEvent(@Id val pss2STId: UUID, val assignment: PU )
data class UnAssignK1FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignK2ToPss2STEvent(@Id val pss2STId: UUID, val assignment: PU )
data class UnAssignK2FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignLsmaxToPss2STEvent(@Id val pss2STId: UUID, val assignment: PU )
data class UnAssignLsmaxFromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignLsminToPss2STEvent(@Id val pss2STId: UUID, val assignment: PU )
data class UnAssignLsminFromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT1ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT1FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT10ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT10FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT2ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT2FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT3ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT3FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT4ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT4FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT5ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT5FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT6ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT6FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT7ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT7FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT8ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT8FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignT9ToPss2STEvent(@Id val pss2STId: UUID, val assignment: Seconds )
data class UnAssignT9FromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignVclToPss2STEvent(@Id val pss2STId: UUID, val assignment: PU )
data class UnAssignVclFromPss2STEvent(@Id val pss2STId: UUID? = null )
data class AssignVcuToPss2STEvent(@Id val pss2STId: UUID, val assignment: PU )
data class UnAssignVcuFromPss2STEvent(@Id val pss2STId: UUID? = null )

// multiple association events


// Pss5 Events

data class CreatePss5Event(
     var pss5Id: UUID? = null
)

data class UpdatePss5Event(
    @Id var pss5Id: UUID? = null,
    var ctw2: BooleanProxy,
    var deadband: PU,
    var isfreq: BooleanProxy,
    var kf: Simple_Float,
    var kpe: Simple_Float,
    var kpss: Simple_Float,
    var pmm: PU,
    var tl1: Seconds,
    var tl2: Seconds,
    var tl3: Seconds,
    var tl4: Seconds,
    var tpe: Seconds,
    var tw1: Seconds,
    var tw2: Seconds,
    var vadat: BooleanProxy,
    var vsmn: PU,
    var vsmx: PU
)

data class DeletePss5Event(@Id val pss5Id: UUID? = null)

// single association events
data class AssignCtw2ToPss5Event(@Id val pss5Id: UUID, val assignment: BooleanProxy )
data class UnAssignCtw2FromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignDeadbandToPss5Event(@Id val pss5Id: UUID, val assignment: PU )
data class UnAssignDeadbandFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignIsfreqToPss5Event(@Id val pss5Id: UUID, val assignment: BooleanProxy )
data class UnAssignIsfreqFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignKfToPss5Event(@Id val pss5Id: UUID, val assignment: Simple_Float )
data class UnAssignKfFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignKpeToPss5Event(@Id val pss5Id: UUID, val assignment: Simple_Float )
data class UnAssignKpeFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignKpssToPss5Event(@Id val pss5Id: UUID, val assignment: Simple_Float )
data class UnAssignKpssFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignPmmToPss5Event(@Id val pss5Id: UUID, val assignment: PU )
data class UnAssignPmmFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignTl1ToPss5Event(@Id val pss5Id: UUID, val assignment: Seconds )
data class UnAssignTl1FromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignTl2ToPss5Event(@Id val pss5Id: UUID, val assignment: Seconds )
data class UnAssignTl2FromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignTl3ToPss5Event(@Id val pss5Id: UUID, val assignment: Seconds )
data class UnAssignTl3FromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignTl4ToPss5Event(@Id val pss5Id: UUID, val assignment: Seconds )
data class UnAssignTl4FromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignTpeToPss5Event(@Id val pss5Id: UUID, val assignment: Seconds )
data class UnAssignTpeFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignTw1ToPss5Event(@Id val pss5Id: UUID, val assignment: Seconds )
data class UnAssignTw1FromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignTw2ToPss5Event(@Id val pss5Id: UUID, val assignment: Seconds )
data class UnAssignTw2FromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignVadatToPss5Event(@Id val pss5Id: UUID, val assignment: BooleanProxy )
data class UnAssignVadatFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignVsmnToPss5Event(@Id val pss5Id: UUID, val assignment: PU )
data class UnAssignVsmnFromPss5Event(@Id val pss5Id: UUID? = null )
data class AssignVsmxToPss5Event(@Id val pss5Id: UUID, val assignment: PU )
data class UnAssignVsmxFromPss5Event(@Id val pss5Id: UUID? = null )

// multiple association events


// PssELIN2 Events

data class CreatePssELIN2Event(
     var pssELIN2Id: UUID? = null
)

data class UpdatePssELIN2Event(
    @Id var pssELIN2Id: UUID? = null,
    var apss: PU,
    var ks1: PU,
    var ks2: PU,
    var ppss: PU,
    var psslim: PU,
    var ts1: Seconds,
    var ts2: Seconds,
    var ts3: Seconds,
    var ts4: Seconds,
    var ts5: Seconds,
    var ts6: Seconds
)

data class DeletePssELIN2Event(@Id val pssELIN2Id: UUID? = null)

// single association events
data class AssignApssToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: PU )
data class UnAssignApssFromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignKs1ToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: PU )
data class UnAssignKs1FromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignKs2ToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: PU )
data class UnAssignKs2FromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignPpssToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: PU )
data class UnAssignPpssFromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignPsslimToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: PU )
data class UnAssignPsslimFromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignTs1ToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTs1FromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignTs2ToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTs2FromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignTs3ToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTs3FromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignTs4ToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTs4FromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignTs5ToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTs5FromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )
data class AssignTs6ToPssELIN2Event(@Id val pssELIN2Id: UUID, val assignment: Seconds )
data class UnAssignTs6FromPssELIN2Event(@Id val pssELIN2Id: UUID? = null )

// multiple association events


// PssIEEE1A Events

data class CreatePssIEEE1AEvent(
    @Id var pssIEEE1AId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignalType: InputSignalKind
)

data class UpdatePssIEEE1AEvent(
    @Id var pssIEEE1AId: UUID? = null,
    var a1: PU,
    var a2: PU,
    @Enumerated(EnumType.STRING) var inputSignalType: InputSignalKind,
    var ks: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var vrmax: PU,
    var vrmin: PU
)

data class DeletePssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null)

// single association events
data class AssignA1ToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: PU )
data class UnAssignA1FromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignA2ToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: PU )
data class UnAssignA2FromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignKsToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: PU )
data class UnAssignKsFromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignT1ToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: Seconds )
data class UnAssignT1FromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignT2ToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: Seconds )
data class UnAssignT2FromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignT3ToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: Seconds )
data class UnAssignT3FromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignT4ToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: Seconds )
data class UnAssignT4FromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignT5ToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: Seconds )
data class UnAssignT5FromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignT6ToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: Seconds )
data class UnAssignT6FromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignVrmaxToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: PU )
data class UnAssignVrmaxFromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )
data class AssignVrminToPssIEEE1AEvent(@Id val pssIEEE1AId: UUID, val assignment: PU )
data class UnAssignVrminFromPssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null )

// multiple association events


// PssIEEE2B Events

data class CreatePssIEEE2BEvent(
    @Id var pssIEEE2BId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind
)

data class UpdatePssIEEE2BEvent(
    @Id var pssIEEE2BId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind,
    var ks1: PU,
    var ks2: PU,
    var ks3: PU,
    var m: IntegerProxy,
    var n: IntegerProxy,
    var t1: Seconds,
    var t10: Seconds,
    var t11: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t6: Seconds,
    var t7: Seconds,
    var t8: Seconds,
    var t9: Seconds,
    var tw1: Seconds,
    var tw2: Seconds,
    var tw3: Seconds,
    var tw4: Seconds,
    var vsi1max: PU,
    var vsi1min: PU,
    var vsi2max: PU,
    var vsi2min: PU,
    var vstmax: PU,
    var vstmin: PU
)

data class DeletePssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null)

// single association events
data class AssignKs1ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignKs1FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignKs2ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignKs2FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignKs3ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignKs3FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignMToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: IntegerProxy )
data class UnAssignMFromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignNToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: IntegerProxy )
data class UnAssignNFromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT1ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT1FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT10ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT10FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT11ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT11FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT2ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT2FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT3ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT3FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT4ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT4FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT6ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT6FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT7ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT7FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT8ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT8FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignT9ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignT9FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignTw1ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignTw1FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignTw2ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignTw2FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignTw3ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignTw3FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignTw4ToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: Seconds )
data class UnAssignTw4FromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignVsi1maxToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignVsi1maxFromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignVsi1minToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignVsi1minFromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignVsi2maxToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignVsi2maxFromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignVsi2minToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignVsi2minFromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignVstmaxToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignVstmaxFromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )
data class AssignVstminToPssIEEE2BEvent(@Id val pssIEEE2BId: UUID, val assignment: PU )
data class UnAssignVstminFromPssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null )

// multiple association events


// PssIEEE3B Events

data class CreatePssIEEE3BEvent(
    @Id var pssIEEE3BId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind
)

data class UpdatePssIEEE3BEvent(
    @Id var pssIEEE3BId: UUID? = null,
    var a1: PU,
    var a2: PU,
    var a3: PU,
    var a4: PU,
    var a5: PU,
    var a6: PU,
    var a7: PU,
    var a8: PU,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind,
    var ks1: PU,
    var ks2: PU,
    var t1: Seconds,
    var t2: Seconds,
    var tw1: Seconds,
    var tw2: Seconds,
    var tw3: Seconds,
    var vstmax: PU,
    var vstmin: PU
)

data class DeletePssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null)

// single association events
data class AssignA1ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignA1FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignA2ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignA2FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignA3ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignA3FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignA4ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignA4FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignA5ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignA5FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignA6ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignA6FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignA7ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignA7FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignA8ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignA8FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignKs1ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignKs1FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignKs2ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignKs2FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignT1ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: Seconds )
data class UnAssignT1FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignT2ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: Seconds )
data class UnAssignT2FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignTw1ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: Seconds )
data class UnAssignTw1FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignTw2ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: Seconds )
data class UnAssignTw2FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignTw3ToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: Seconds )
data class UnAssignTw3FromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignVstmaxToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignVstmaxFromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )
data class AssignVstminToPssIEEE3BEvent(@Id val pssIEEE3BId: UUID, val assignment: PU )
data class UnAssignVstminFromPssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null )

// multiple association events


// PssIEEE4B Events

data class CreatePssIEEE4BEvent(
     var pssIEEE4BId: UUID? = null
)

data class UpdatePssIEEE4BEvent(
    @Id var pssIEEE4BId: UUID? = null,
    var bwh1: Simple_Float,
    var bwh2: Simple_Float,
    var bwl1: Simple_Float,
    var bwl2: Simple_Float,
    var kh: PU,
    var kh1: PU,
    var kh11: PU,
    var kh17: PU,
    var kh2: PU,
    var ki: PU,
    var ki1: PU,
    var ki11: PU,
    var ki17: PU,
    var ki2: PU,
    var kl: PU,
    var kl1: PU,
    var kl11: PU,
    var kl17: PU,
    var kl2: PU,
    var omeganh1: Simple_Float,
    var omeganh2: Simple_Float,
    var omeganl1: Simple_Float,
    var omeganl2: Simple_Float,
    var th1: Seconds,
    var th10: Seconds,
    var th11: Seconds,
    var th12: Seconds,
    var th2: Seconds,
    var th3: Seconds,
    var th4: Seconds,
    var th5: Seconds,
    var th6: Seconds,
    var th7: Seconds,
    var th8: Seconds,
    var th9: Seconds,
    var ti1: Seconds,
    var ti10: Seconds,
    var ti11: Seconds,
    var ti12: Seconds,
    var ti2: Seconds,
    var ti3: Seconds,
    var ti4: Seconds,
    var ti5: Seconds,
    var ti6: Seconds,
    var ti7: Seconds,
    var ti8: Seconds,
    var ti9: Seconds,
    var tl1: Seconds,
    var tl10: Seconds,
    var tl11: Seconds,
    var tl12: Seconds,
    var tl2: Seconds,
    var tl3: Seconds,
    var tl4: Seconds,
    var tl5: Seconds,
    var tl6: Seconds,
    var tl7: Seconds,
    var tl8: Seconds,
    var tl9: Seconds,
    var vhmax: PU,
    var vhmin: PU,
    var vimax: PU,
    var vimin: PU,
    var vlmax: PU,
    var vlmin: PU,
    var vstmax: PU,
    var vstmin: PU
)

data class DeletePssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null)

// single association events
data class AssignBwh1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Simple_Float )
data class UnAssignBwh1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignBwh2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Simple_Float )
data class UnAssignBwh2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignBwl1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Simple_Float )
data class UnAssignBwl1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignBwl2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Simple_Float )
data class UnAssignBwl2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKhToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKhFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKh1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKh1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKh11ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKh11FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKh17ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKh17FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKh2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKh2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKiToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKiFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKi1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKi1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKi11ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKi11FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKi17ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKi17FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKi2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKi2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKlToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKlFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKl1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKl1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKl11ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKl11FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKl17ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKl17FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignKl2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignKl2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignOmeganh1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Simple_Float )
data class UnAssignOmeganh1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignOmeganh2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Simple_Float )
data class UnAssignOmeganh2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignOmeganl1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Simple_Float )
data class UnAssignOmeganl1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignOmeganl2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Simple_Float )
data class UnAssignOmeganl2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh10ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh10FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh11ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh11FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh12ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh12FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh3ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh3FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh4ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh4FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh5ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh5FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh6ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh6FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh7ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh7FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh8ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh8FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTh9ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTh9FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi10ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi10FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi11ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi11FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi12ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi12FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi3ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi3FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi4ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi4FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi5ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi5FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi6ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi6FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi7ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi7FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi8ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi8FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTi9ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTi9FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl1ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl1FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl10ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl10FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl11ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl11FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl12ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl12FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl2ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl2FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl3ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl3FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl4ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl4FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl5ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl5FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl6ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl6FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl7ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl7FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl8ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl8FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignTl9ToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: Seconds )
data class UnAssignTl9FromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignVhmaxToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignVhmaxFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignVhminToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignVhminFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignVimaxToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignVimaxFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignViminToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignViminFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignVlmaxToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignVlmaxFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignVlminToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignVlminFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignVstmaxToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignVstmaxFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )
data class AssignVstminToPssIEEE4BEvent(@Id val pssIEEE4BId: UUID, val assignment: PU )
data class UnAssignVstminFromPssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null )

// multiple association events


// PssPTIST1 Events

data class CreatePssPTIST1Event(
     var pssPTIST1Id: UUID? = null
)

data class UpdatePssPTIST1Event(
    @Id var pssPTIST1Id: UUID? = null,
    var dtc: Seconds,
    var dtf: Seconds,
    var dtp: Seconds,
    var k: PU,
    var m: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var tf: Seconds,
    var tp: Seconds
)

data class DeletePssPTIST1Event(@Id val pssPTIST1Id: UUID? = null)

// single association events
data class AssignDtcToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignDtcFromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignDtfToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignDtfFromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignDtpToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignDtpFromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignKToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: PU )
data class UnAssignKFromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignMToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: PU )
data class UnAssignMFromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignT1ToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignT1FromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignT2ToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignT2FromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignT3ToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignT3FromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignT4ToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignT4FromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignTfToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignTfFromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )
data class AssignTpToPssPTIST1Event(@Id val pssPTIST1Id: UUID, val assignment: Seconds )
data class UnAssignTpFromPssPTIST1Event(@Id val pssPTIST1Id: UUID? = null )

// multiple association events


// PssPTIST3 Events

data class CreatePssPTIST3Event(
     var pssPTIST3Id: UUID? = null
)

data class UpdatePssPTIST3Event(
    @Id var pssPTIST3Id: UUID? = null,
    var a0: PU,
    var a1: PU,
    var a2: PU,
    var a3: PU,
    var a4: PU,
    var a5: PU,
    var al: PU,
    var athres: PU,
    var b0: PU,
    var b1: PU,
    var b2: PU,
    var b3: PU,
    var b4: PU,
    var b5: PU,
    var dl: PU,
    var dtc: Seconds,
    var dtf: Seconds,
    var dtp: Seconds,
    var isw: BooleanProxy,
    var k: PU,
    var lthres: PU,
    var m: PU,
    var nav: Simple_Float,
    var ncl: Simple_Float,
    var ncr: Simple_Float,
    var pmin: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var tf: Seconds,
    var tp: Seconds
)

data class DeletePssPTIST3Event(@Id val pssPTIST3Id: UUID? = null)

// single association events
data class AssignA0ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignA0FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignA1ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignA1FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignA2ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignA2FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignA3ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignA3FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignA4ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignA4FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignA5ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignA5FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignAlToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignAlFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignAthresToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignAthresFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignB0ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignB0FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignB1ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignB1FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignB2ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignB2FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignB3ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignB3FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignB4ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignB4FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignB5ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignB5FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignDlToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignDlFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignDtcToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignDtcFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignDtfToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignDtfFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignDtpToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignDtpFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignIswToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: BooleanProxy )
data class UnAssignIswFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignKToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignKFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignLthresToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignLthresFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignMToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignMFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignNavToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Simple_Float )
data class UnAssignNavFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignNclToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Simple_Float )
data class UnAssignNclFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignNcrToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Simple_Float )
data class UnAssignNcrFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignPminToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: PU )
data class UnAssignPminFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignT1ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignT1FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignT2ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignT2FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignT3ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignT3FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignT4ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignT4FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignT5ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignT5FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignT6ToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignT6FromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignTfToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignTfFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )
data class AssignTpToPssPTIST3Event(@Id val pssPTIST3Id: UUID, val assignment: Seconds )
data class UnAssignTpFromPssPTIST3Event(@Id val pssPTIST3Id: UUID? = null )

// multiple association events


// PssSB4 Events

data class CreatePssSB4Event(
     var pssSB4Id: UUID? = null
)

data class UpdatePssSB4Event(
    @Id var pssSB4Id: UUID? = null,
    var kx: PU,
    var ta: Seconds,
    var tb: Seconds,
    var tc: Seconds,
    var td: Seconds,
    var te: Seconds,
    var tt: Seconds,
    var tx1: Seconds,
    var tx2: Seconds,
    var vsmax: PU,
    var vsmin: PU
)

data class DeletePssSB4Event(@Id val pssSB4Id: UUID? = null)

// single association events
data class AssignKxToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: PU )
data class UnAssignKxFromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignTaToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: Seconds )
data class UnAssignTaFromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignTbToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: Seconds )
data class UnAssignTbFromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignTcToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: Seconds )
data class UnAssignTcFromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignTdToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: Seconds )
data class UnAssignTdFromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignTeToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: Seconds )
data class UnAssignTeFromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignTtToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: Seconds )
data class UnAssignTtFromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignTx1ToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: Seconds )
data class UnAssignTx1FromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignTx2ToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: Seconds )
data class UnAssignTx2FromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignVsmaxToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: PU )
data class UnAssignVsmaxFromPssSB4Event(@Id val pssSB4Id: UUID? = null )
data class AssignVsminToPssSB4Event(@Id val pssSB4Id: UUID, val assignment: PU )
data class UnAssignVsminFromPssSB4Event(@Id val pssSB4Id: UUID? = null )

// multiple association events


// PssSH Events

data class CreatePssSHEvent(
     var pssSHId: UUID? = null
)

data class UpdatePssSHEvent(
    @Id var pssSHId: UUID? = null,
    var k: PU,
    var k0: PU,
    var k1: PU,
    var k2: PU,
    var k3: PU,
    var k4: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var td: Seconds,
    var vsmax: PU,
    var vsmin: PU
)

data class DeletePssSHEvent(@Id val pssSHId: UUID? = null)

// single association events
data class AssignKToPssSHEvent(@Id val pssSHId: UUID, val assignment: PU )
data class UnAssignKFromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignK0ToPssSHEvent(@Id val pssSHId: UUID, val assignment: PU )
data class UnAssignK0FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignK1ToPssSHEvent(@Id val pssSHId: UUID, val assignment: PU )
data class UnAssignK1FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignK2ToPssSHEvent(@Id val pssSHId: UUID, val assignment: PU )
data class UnAssignK2FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignK3ToPssSHEvent(@Id val pssSHId: UUID, val assignment: PU )
data class UnAssignK3FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignK4ToPssSHEvent(@Id val pssSHId: UUID, val assignment: PU )
data class UnAssignK4FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignT1ToPssSHEvent(@Id val pssSHId: UUID, val assignment: Seconds )
data class UnAssignT1FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignT2ToPssSHEvent(@Id val pssSHId: UUID, val assignment: Seconds )
data class UnAssignT2FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignT3ToPssSHEvent(@Id val pssSHId: UUID, val assignment: Seconds )
data class UnAssignT3FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignT4ToPssSHEvent(@Id val pssSHId: UUID, val assignment: Seconds )
data class UnAssignT4FromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignTdToPssSHEvent(@Id val pssSHId: UUID, val assignment: Seconds )
data class UnAssignTdFromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignVsmaxToPssSHEvent(@Id val pssSHId: UUID, val assignment: PU )
data class UnAssignVsmaxFromPssSHEvent(@Id val pssSHId: UUID? = null )
data class AssignVsminToPssSHEvent(@Id val pssSHId: UUID, val assignment: PU )
data class UnAssignVsminFromPssSHEvent(@Id val pssSHId: UUID? = null )

// multiple association events


// PssSK Events

data class CreatePssSKEvent(
     var pssSKId: UUID? = null
)

data class UpdatePssSKEvent(
    @Id var pssSKId: UUID? = null,
    var k1: PU,
    var k2: PU,
    var k3: PU,
    var t1: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var vsmax: PU,
    var vsmin: PU
)

data class DeletePssSKEvent(@Id val pssSKId: UUID? = null)

// single association events
data class AssignK1ToPssSKEvent(@Id val pssSKId: UUID, val assignment: PU )
data class UnAssignK1FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignK2ToPssSKEvent(@Id val pssSKId: UUID, val assignment: PU )
data class UnAssignK2FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignK3ToPssSKEvent(@Id val pssSKId: UUID, val assignment: PU )
data class UnAssignK3FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignT1ToPssSKEvent(@Id val pssSKId: UUID, val assignment: Seconds )
data class UnAssignT1FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignT2ToPssSKEvent(@Id val pssSKId: UUID, val assignment: Seconds )
data class UnAssignT2FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignT3ToPssSKEvent(@Id val pssSKId: UUID, val assignment: Seconds )
data class UnAssignT3FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignT4ToPssSKEvent(@Id val pssSKId: UUID, val assignment: Seconds )
data class UnAssignT4FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignT5ToPssSKEvent(@Id val pssSKId: UUID, val assignment: Seconds )
data class UnAssignT5FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignT6ToPssSKEvent(@Id val pssSKId: UUID, val assignment: Seconds )
data class UnAssignT6FromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignVsmaxToPssSKEvent(@Id val pssSKId: UUID, val assignment: PU )
data class UnAssignVsmaxFromPssSKEvent(@Id val pssSKId: UUID? = null )
data class AssignVsminToPssSKEvent(@Id val pssSKId: UUID, val assignment: PU )
data class UnAssignVsminFromPssSKEvent(@Id val pssSKId: UUID? = null )

// multiple association events


// PssWECC Events

data class CreatePssWECCEvent(
    @Id var pssWECCId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind
)

data class UpdatePssWECCEvent(
    @Id var pssWECCId: UUID? = null,
    @Enumerated(EnumType.STRING) var inputSignal1Type: InputSignalKind,
    @Enumerated(EnumType.STRING) var inputSignal2Type: InputSignalKind,
    var k1: PU,
    var k2: PU,
    var t1: Seconds,
    var t10: Seconds,
    var t2: Seconds,
    var t3: Seconds,
    var t4: Seconds,
    var t5: Seconds,
    var t6: Seconds,
    var t7: Seconds,
    var t8: Seconds,
    var t9: Seconds,
    var vcl: PU,
    var vcu: PU,
    var vsmax: PU,
    var vsmin: PU
)

data class DeletePssWECCEvent(@Id val pssWECCId: UUID? = null)

// single association events
data class AssignK1ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: PU )
data class UnAssignK1FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignK2ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: PU )
data class UnAssignK2FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT1ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT1FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT10ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT10FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT2ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT2FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT3ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT3FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT4ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT4FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT5ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT5FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT6ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT6FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT7ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT7FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT8ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT8FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignT9ToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: Seconds )
data class UnAssignT9FromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignVclToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: PU )
data class UnAssignVclFromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignVcuToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: PU )
data class UnAssignVcuFromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignVsmaxToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: PU )
data class UnAssignVsmaxFromPssWECCEvent(@Id val pssWECCId: UUID? = null )
data class AssignVsminToPssWECCEvent(@Id val pssWECCId: UUID, val assignment: PU )
data class UnAssignVsminFromPssWECCEvent(@Id val pssWECCId: UUID? = null )

// multiple association events


// Quality61850 Events

data class CreateQuality61850Event(
    @Id var quality61850Id: UUID? = null,
    @Enumerated(EnumType.STRING) var source: Source,
    @Enumerated(EnumType.STRING) var validity: Validity
)

data class UpdateQuality61850Event(
    @Id var quality61850Id: UUID? = null,
    var badReference: BooleanProxy,
    var estimatorReplaced: BooleanProxy,
    var failure: BooleanProxy,
    var oldData: BooleanProxy,
    var operatorBlocked: BooleanProxy,
    var oscillatory: BooleanProxy,
    var outOfRange: BooleanProxy,
    var overFlow: BooleanProxy,
    @Enumerated(EnumType.STRING) var source: Source,
    var suspect: BooleanProxy,
    var test: BooleanProxy,
    @Enumerated(EnumType.STRING) var validity: Validity
)

data class DeleteQuality61850Event(@Id val quality61850Id: UUID? = null)

// single association events
data class AssignBadReferenceToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignBadReferenceFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignEstimatorReplacedToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignEstimatorReplacedFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignFailureToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignFailureFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignOldDataToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignOldDataFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignOperatorBlockedToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignOperatorBlockedFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignOscillatoryToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignOscillatoryFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignOutOfRangeToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignOutOfRangeFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignOverFlowToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignOverFlowFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignSuspectToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignSuspectFromQuality61850Event(@Id val quality61850Id: UUID? = null )
data class AssignTestToQuality61850Event(@Id val quality61850Id: UUID, val assignment: BooleanProxy )
data class UnAssignTestFromQuality61850Event(@Id val quality61850Id: UUID? = null )

// multiple association events


// RaiseLowerCommand Events

data class CreateRaiseLowerCommandEvent(
     var raiseLowerCommandId: UUID? = null
)

data class UpdateRaiseLowerCommandEvent(
    @Id var raiseLowerCommandId: UUID? = null,
    var raiseLowerCommands:  Set<RaiseLowerCommand>
)

data class DeleteRaiseLowerCommandEvent(@Id val raiseLowerCommandId: UUID? = null)

// single association events

// multiple association events
data class AssignRaiseLowerCommandsToRaiseLowerCommandEvent(@Id val raiseLowerCommandId: UUID, val addTo: RaiseLowerCommand )
data class RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent(@Id val raiseLowerCommandId: UUID, val removeFrom: RaiseLowerCommand )


// RatioTapChanger Events

data class CreateRatioTapChangerEvent(
    @Id var ratioTapChangerId: UUID? = null,
    @Enumerated(EnumType.STRING) var tculControlMode: TransformerControlMode
)

data class UpdateRatioTapChangerEvent(
    @Id var ratioTapChangerId: UUID? = null,
    var stepVoltageIncrement: PerCent,
    @Enumerated(EnumType.STRING) var tculControlMode: TransformerControlMode,
    var ratioTapChanger: RatioTapChanger
)

data class DeleteRatioTapChangerEvent(@Id val ratioTapChangerId: UUID? = null)

// single association events
data class AssignStepVoltageIncrementToRatioTapChangerEvent(@Id val ratioTapChangerId: UUID, val assignment: PerCent )
data class UnAssignStepVoltageIncrementFromRatioTapChangerEvent(@Id val ratioTapChangerId: UUID? = null )
data class AssignRatioTapChangerToRatioTapChangerEvent(@Id val ratioTapChangerId: UUID, val assignment: RatioTapChanger )
data class UnAssignRatioTapChangerFromRatioTapChangerEvent(@Id val ratioTapChangerId: UUID? = null )

// multiple association events


// RatioTapChangerTable Events

data class CreateRatioTapChangerTableEvent(
     var ratioTapChangerTableId: UUID? = null
)

data class UpdateRatioTapChangerTableEvent(
     var ratioTapChangerTableId: UUID? = null
)

data class DeleteRatioTapChangerTableEvent(@Id val ratioTapChangerTableId: UUID? = null)

// single association events

// multiple association events


// RatioTapChangerTablePoint Events

data class CreateRatioTapChangerTablePointEvent(
     var ratioTapChangerTablePointId: UUID? = null
)

data class UpdateRatioTapChangerTablePointEvent(
    @Id var ratioTapChangerTablePointId: UUID? = null,
    var ratioTapChangerTablePoint:  Set<RatioTapChangerTablePoint>
)

data class DeleteRatioTapChangerTablePointEvent(@Id val ratioTapChangerTablePointId: UUID? = null)

// single association events

// multiple association events
data class AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent(@Id val ratioTapChangerTablePointId: UUID, val addTo: RatioTapChangerTablePoint )
data class RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent(@Id val ratioTapChangerTablePointId: UUID, val removeFrom: RatioTapChangerTablePoint )


// Reactance Events

data class CreateReactanceEvent(
    @Id var reactanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateReactanceEvent(
    @Id var reactanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteReactanceEvent(@Id val reactanceId: UUID? = null)

// single association events
data class AssignValueToReactanceEvent(@Id val reactanceId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromReactanceEvent(@Id val reactanceId: UUID? = null )

// multiple association events


// ReactiveCapabilityCurve Events

data class CreateReactiveCapabilityCurveEvent(
     var reactiveCapabilityCurveId: UUID? = null
)

data class UpdateReactiveCapabilityCurveEvent(
     var reactiveCapabilityCurveId: UUID? = null
)

data class DeleteReactiveCapabilityCurveEvent(@Id val reactiveCapabilityCurveId: UUID? = null)

// single association events

// multiple association events


// ReactivePower Events

data class CreateReactivePowerEvent(
    @Id var reactivePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateReactivePowerEvent(
    @Id var reactivePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteReactivePowerEvent(@Id val reactivePowerId: UUID? = null)

// single association events
data class AssignValueToReactivePowerEvent(@Id val reactivePowerId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromReactivePowerEvent(@Id val reactivePowerId: UUID? = null )

// multiple association events


// RegularIntervalSchedule Events

data class CreateRegularIntervalScheduleEvent(
     var regularIntervalScheduleId: UUID? = null
)

data class UpdateRegularIntervalScheduleEvent(
    @Id var regularIntervalScheduleId: UUID? = null,
    var endTime: DateTime,
    var timeStep: Seconds
)

data class DeleteRegularIntervalScheduleEvent(@Id val regularIntervalScheduleId: UUID? = null)

// single association events
data class AssignEndTimeToRegularIntervalScheduleEvent(@Id val regularIntervalScheduleId: UUID, val assignment: DateTime )
data class UnAssignEndTimeFromRegularIntervalScheduleEvent(@Id val regularIntervalScheduleId: UUID? = null )
data class AssignTimeStepToRegularIntervalScheduleEvent(@Id val regularIntervalScheduleId: UUID, val assignment: Seconds )
data class UnAssignTimeStepFromRegularIntervalScheduleEvent(@Id val regularIntervalScheduleId: UUID? = null )

// multiple association events


// RegularTimePoint Events

data class CreateRegularTimePointEvent(
     var regularTimePointId: UUID? = null
)

data class UpdateRegularTimePointEvent(
    @Id var regularTimePointId: UUID? = null,
    var sequenceNumber: IntegerProxy,
    var value1: Simple_Float,
    var value2: Simple_Float,
    var timePoints:  Set<RegularTimePoint>
)

data class DeleteRegularTimePointEvent(@Id val regularTimePointId: UUID? = null)

// single association events
data class AssignSequenceNumberToRegularTimePointEvent(@Id val regularTimePointId: UUID, val assignment: IntegerProxy )
data class UnAssignSequenceNumberFromRegularTimePointEvent(@Id val regularTimePointId: UUID? = null )
data class AssignValue1ToRegularTimePointEvent(@Id val regularTimePointId: UUID, val assignment: Simple_Float )
data class UnAssignValue1FromRegularTimePointEvent(@Id val regularTimePointId: UUID? = null )
data class AssignValue2ToRegularTimePointEvent(@Id val regularTimePointId: UUID, val assignment: Simple_Float )
data class UnAssignValue2FromRegularTimePointEvent(@Id val regularTimePointId: UUID? = null )

// multiple association events
data class AssignTimePointsToRegularTimePointEvent(@Id val regularTimePointId: UUID, val addTo: RegularTimePoint )
data class RemoveTimePointsFromRegularTimePointEvent(@Id val regularTimePointId: UUID, val removeFrom: RegularTimePoint )


// RegulatingCondEq Events

data class CreateRegulatingCondEqEvent(
     var regulatingCondEqId: UUID? = null
)

data class UpdateRegulatingCondEqEvent(
    @Id var regulatingCondEqId: UUID? = null,
    var regulatingCondEq:  Set<RegulatingCondEq>
)

data class DeleteRegulatingCondEqEvent(@Id val regulatingCondEqId: UUID? = null)

// single association events

// multiple association events
data class AssignRegulatingCondEqToRegulatingCondEqEvent(@Id val regulatingCondEqId: UUID, val addTo: RegulatingCondEq )
data class RemoveRegulatingCondEqFromRegulatingCondEqEvent(@Id val regulatingCondEqId: UUID, val removeFrom: RegulatingCondEq )


// RegulatingControl Events

data class CreateRegulatingControlEvent(
    @Id var regulatingControlId: UUID? = null,
    @Enumerated(EnumType.STRING) var mode: RegulatingControlModeKind
)

data class UpdateRegulatingControlEvent(
    @Id var regulatingControlId: UUID? = null,
    @Enumerated(EnumType.STRING) var mode: RegulatingControlModeKind,
    var regulatingControl: RegulatingControl
)

data class DeleteRegulatingControlEvent(@Id val regulatingControlId: UUID? = null)

// single association events
data class AssignRegulatingControlToRegulatingControlEvent(@Id val regulatingControlId: UUID, val assignment: RegulatingControl )
data class UnAssignRegulatingControlFromRegulatingControlEvent(@Id val regulatingControlId: UUID? = null )

// multiple association events


// RegulationSchedule Events

data class CreateRegulationScheduleEvent(
     var regulationScheduleId: UUID? = null
)

data class UpdateRegulationScheduleEvent(
    @Id var regulationScheduleId: UUID? = null,
    var regulationSchedule:  Set<RegulationSchedule>
)

data class DeleteRegulationScheduleEvent(@Id val regulationScheduleId: UUID? = null)

// single association events

// multiple association events
data class AssignRegulationScheduleToRegulationScheduleEvent(@Id val regulationScheduleId: UUID, val addTo: RegulationSchedule )
data class RemoveRegulationScheduleFromRegulationScheduleEvent(@Id val regulationScheduleId: UUID, val removeFrom: RegulationSchedule )


// RemoteInputSignal Events

data class CreateRemoteInputSignalEvent(
    @Id var remoteInputSignalId: UUID? = null,
    @Enumerated(EnumType.STRING) var remoteSignalType: RemoteSignalKind
)

data class UpdateRemoteInputSignalEvent(
    @Id var remoteInputSignalId: UUID? = null,
    @Enumerated(EnumType.STRING) var remoteSignalType: RemoteSignalKind,
    var remoteInputSignal:  Set<RemoteInputSignal>
)

data class DeleteRemoteInputSignalEvent(@Id val remoteInputSignalId: UUID? = null)

// single association events

// multiple association events
data class AssignRemoteInputSignalToRemoteInputSignalEvent(@Id val remoteInputSignalId: UUID, val addTo: RemoteInputSignal )
data class RemoveRemoteInputSignalFromRemoteInputSignalEvent(@Id val remoteInputSignalId: UUID, val removeFrom: RemoteInputSignal )


// ReportingGroup Events

data class CreateReportingGroupEvent(
     var reportingGroupId: UUID? = null
)

data class UpdateReportingGroupEvent(
     var reportingGroupId: UUID? = null
)

data class DeleteReportingGroupEvent(@Id val reportingGroupId: UUID? = null)

// single association events

// multiple association events


// Resistance Events

data class CreateResistanceEvent(
    @Id var resistanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateResistanceEvent(
    @Id var resistanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteResistanceEvent(@Id val resistanceId: UUID? = null)

// single association events
data class AssignValueToResistanceEvent(@Id val resistanceId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromResistanceEvent(@Id val resistanceId: UUID? = null )

// multiple association events


// ResistancePerLength Events

data class CreateResistancePerLengthEvent(
    @Id var resistancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateResistancePerLengthEvent(
    @Id var resistancePerLengthId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteResistancePerLengthEvent(@Id val resistancePerLengthId: UUID? = null)

// single association events
data class AssignValueToResistancePerLengthEvent(@Id val resistancePerLengthId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromResistancePerLengthEvent(@Id val resistancePerLengthId: UUID? = null )

// multiple association events


// RotatingMachine Events

data class CreateRotatingMachineEvent(
     var rotatingMachineId: UUID? = null
)

data class UpdateRotatingMachineEvent(
    @Id var rotatingMachineId: UUID? = null,
    var ratedPowerFactor: Simple_Float,
    var ratedS: ApparentPower,
    var ratedU: Voltage,
    var rotatingMachine:  Set<RotatingMachine>
)

data class DeleteRotatingMachineEvent(@Id val rotatingMachineId: UUID? = null)

// single association events
data class AssignRatedPowerFactorToRotatingMachineEvent(@Id val rotatingMachineId: UUID, val assignment: Simple_Float )
data class UnAssignRatedPowerFactorFromRotatingMachineEvent(@Id val rotatingMachineId: UUID? = null )
data class AssignRatedSToRotatingMachineEvent(@Id val rotatingMachineId: UUID, val assignment: ApparentPower )
data class UnAssignRatedSFromRotatingMachineEvent(@Id val rotatingMachineId: UUID? = null )
data class AssignRatedUToRotatingMachineEvent(@Id val rotatingMachineId: UUID, val assignment: Voltage )
data class UnAssignRatedUFromRotatingMachineEvent(@Id val rotatingMachineId: UUID? = null )

// multiple association events
data class AssignRotatingMachineToRotatingMachineEvent(@Id val rotatingMachineId: UUID, val addTo: RotatingMachine )
data class RemoveRotatingMachineFromRotatingMachineEvent(@Id val rotatingMachineId: UUID, val removeFrom: RotatingMachine )


// RotatingMachineDynamics Events

data class CreateRotatingMachineDynamicsEvent(
     var rotatingMachineDynamicsId: UUID? = null
)

data class UpdateRotatingMachineDynamicsEvent(
    @Id var rotatingMachineDynamicsId: UUID? = null,
    var damping: Simple_Float,
    var inertia: Seconds,
    var saturationFactor: Simple_Float,
    var saturationFactor120: Simple_Float,
    var statorLeakageReactance: PU,
    var statorResistance: PU
)

data class DeleteRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID? = null)

// single association events
data class AssignDampingToRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID, val assignment: Simple_Float )
data class UnAssignDampingFromRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID? = null )
data class AssignInertiaToRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID, val assignment: Seconds )
data class UnAssignInertiaFromRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID? = null )
data class AssignSaturationFactorToRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID, val assignment: Simple_Float )
data class UnAssignSaturationFactorFromRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID? = null )
data class AssignSaturationFactor120ToRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID, val assignment: Simple_Float )
data class UnAssignSaturationFactor120FromRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID? = null )
data class AssignStatorLeakageReactanceToRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID, val assignment: PU )
data class UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID? = null )
data class AssignStatorResistanceToRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID, val assignment: PU )
data class UnAssignStatorResistanceFromRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID? = null )

// multiple association events


// RotationSpeed Events

data class CreateRotationSpeedEvent(
    @Id var rotationSpeedId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateRotationSpeedEvent(
    @Id var rotationSpeedId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteRotationSpeedEvent(@Id val rotationSpeedId: UUID? = null)

// single association events
data class AssignValueToRotationSpeedEvent(@Id val rotationSpeedId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromRotationSpeedEvent(@Id val rotationSpeedId: UUID? = null )

// multiple association events


// Season Events

data class CreateSeasonEvent(
     var seasonId: UUID? = null
)

data class UpdateSeasonEvent(
    @Id var seasonId: UUID? = null,
    var endDate: MonthDay,
    var startDate: MonthDay
)

data class DeleteSeasonEvent(@Id val seasonId: UUID? = null)

// single association events
data class AssignEndDateToSeasonEvent(@Id val seasonId: UUID, val assignment: MonthDay )
data class UnAssignEndDateFromSeasonEvent(@Id val seasonId: UUID? = null )
data class AssignStartDateToSeasonEvent(@Id val seasonId: UUID, val assignment: MonthDay )
data class UnAssignStartDateFromSeasonEvent(@Id val seasonId: UUID? = null )

// multiple association events


// SeasonDayTypeSchedule Events

data class CreateSeasonDayTypeScheduleEvent(
     var seasonDayTypeScheduleId: UUID? = null
)

data class UpdateSeasonDayTypeScheduleEvent(
    @Id var seasonDayTypeScheduleId: UUID? = null,
    var seasonDayTypeSchedules:  Set<SeasonDayTypeSchedule>
)

data class DeleteSeasonDayTypeScheduleEvent(@Id val seasonDayTypeScheduleId: UUID? = null)

// single association events

// multiple association events
data class AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent(@Id val seasonDayTypeScheduleId: UUID, val addTo: SeasonDayTypeSchedule )
data class RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent(@Id val seasonDayTypeScheduleId: UUID, val removeFrom: SeasonDayTypeSchedule )


// Seconds Events

data class CreateSecondsEvent(
    @Id var secondsId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateSecondsEvent(
    @Id var secondsId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteSecondsEvent(@Id val secondsId: UUID? = null)

// single association events
data class AssignValueToSecondsEvent(@Id val secondsId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromSecondsEvent(@Id val secondsId: UUID? = null )

// multiple association events


// SeriesCompensator Events

data class CreateSeriesCompensatorEvent(
     var seriesCompensatorId: UUID? = null
)

data class UpdateSeriesCompensatorEvent(
    @Id var seriesCompensatorId: UUID? = null,
    var r: Resistance,
    var r0: Resistance,
    var varistorPresent: BooleanProxy,
    var varistorRatedCurrent: CurrentFlow,
    var varistorVoltageThreshold: Voltage,
    var x: Reactance,
    var x0: Reactance
)

data class DeleteSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null)

// single association events
data class AssignRToSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID, val assignment: Resistance )
data class UnAssignRFromSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null )
data class AssignR0ToSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID, val assignment: Resistance )
data class UnAssignR0FromSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null )
data class AssignVaristorPresentToSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID, val assignment: BooleanProxy )
data class UnAssignVaristorPresentFromSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null )
data class AssignVaristorRatedCurrentToSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID, val assignment: CurrentFlow )
data class UnAssignVaristorRatedCurrentFromSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null )
data class AssignVaristorVoltageThresholdToSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID, val assignment: Voltage )
data class UnAssignVaristorVoltageThresholdFromSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null )
data class AssignXToSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID, val assignment: Reactance )
data class UnAssignXFromSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null )
data class AssignX0ToSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID, val assignment: Reactance )
data class UnAssignX0FromSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null )

// multiple association events


// SetPoint Events

data class CreateSetPointEvent(
     var setPointId: UUID? = null
)

data class UpdateSetPointEvent(
    @Id var setPointId: UUID? = null,
    var normalValue: Simple_Float,
    var value: Simple_Float
)

data class DeleteSetPointEvent(@Id val setPointId: UUID? = null)

// single association events
data class AssignNormalValueToSetPointEvent(@Id val setPointId: UUID, val assignment: Simple_Float )
data class UnAssignNormalValueFromSetPointEvent(@Id val setPointId: UUID? = null )
data class AssignValueToSetPointEvent(@Id val setPointId: UUID, val assignment: Simple_Float )
data class UnAssignValueFromSetPointEvent(@Id val setPointId: UUID? = null )

// multiple association events


// ShuntCompensator Events

data class CreateShuntCompensatorEvent(
     var shuntCompensatorId: UUID? = null
)

data class UpdateShuntCompensatorEvent(
    @Id var shuntCompensatorId: UUID? = null,
    var aVRDelay: Seconds,
    var grounded: BooleanProxy,
    var maximumSections: IntegerProxy,
    var nomU: Voltage,
    var normalSections: IntegerProxy,
    var switchOnCount: IntegerProxy,
    var switchOnDate: DateTime,
    var voltageSensitivity: VoltagePerReactivePower
)

data class DeleteShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null)

// single association events
data class AssignAVRDelayToShuntCompensatorEvent(@Id val shuntCompensatorId: UUID, val assignment: Seconds )
data class UnAssignAVRDelayFromShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null )
data class AssignGroundedToShuntCompensatorEvent(@Id val shuntCompensatorId: UUID, val assignment: BooleanProxy )
data class UnAssignGroundedFromShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null )
data class AssignMaximumSectionsToShuntCompensatorEvent(@Id val shuntCompensatorId: UUID, val assignment: IntegerProxy )
data class UnAssignMaximumSectionsFromShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null )
data class AssignNomUToShuntCompensatorEvent(@Id val shuntCompensatorId: UUID, val assignment: Voltage )
data class UnAssignNomUFromShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null )
data class AssignNormalSectionsToShuntCompensatorEvent(@Id val shuntCompensatorId: UUID, val assignment: IntegerProxy )
data class UnAssignNormalSectionsFromShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null )
data class AssignSwitchOnCountToShuntCompensatorEvent(@Id val shuntCompensatorId: UUID, val assignment: IntegerProxy )
data class UnAssignSwitchOnCountFromShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null )
data class AssignSwitchOnDateToShuntCompensatorEvent(@Id val shuntCompensatorId: UUID, val assignment: DateTime )
data class UnAssignSwitchOnDateFromShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null )
data class AssignVoltageSensitivityToShuntCompensatorEvent(@Id val shuntCompensatorId: UUID, val assignment: VoltagePerReactivePower )
data class UnAssignVoltageSensitivityFromShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null )

// multiple association events


// Simple_Float Events

data class CreateSimple_FloatEvent(
     var simple_FloatId: UUID? = null
)

data class UpdateSimple_FloatEvent(
    @Id var simple_FloatId: UUID? = null,
    var value: FloatProxy
)

data class DeleteSimple_FloatEvent(@Id val simple_FloatId: UUID? = null)

// single association events
data class AssignValueToSimple_FloatEvent(@Id val simple_FloatId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromSimple_FloatEvent(@Id val simple_FloatId: UUID? = null )

// multiple association events


// SolarGeneratingUnit Events

data class CreateSolarGeneratingUnitEvent(
     var solarGeneratingUnitId: UUID? = null
)

data class UpdateSolarGeneratingUnitEvent(
     var solarGeneratingUnitId: UUID? = null
)

data class DeleteSolarGeneratingUnitEvent(@Id val solarGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// StateVariablesVersion Events

data class CreateStateVariablesVersionEvent(
     var stateVariablesVersionId: UUID? = null
)

data class UpdateStateVariablesVersionEvent(
    @Id var stateVariablesVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURI: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURI: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignBaseURIToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignDateToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignDifferenceModelURIToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignEntsoeUMLToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignEntsoeURIToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignModelDescriptionURIToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignNamespaceRDFToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignNamespaceUMLToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )
data class AssignShortNameToStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null )

// multiple association events


// StaticVarCompensator Events

data class CreateStaticVarCompensatorEvent(
    @Id var staticVarCompensatorId: UUID? = null,
    @Enumerated(EnumType.STRING) var sVCControlMode: SVCControlMode
)

data class UpdateStaticVarCompensatorEvent(
    @Id var staticVarCompensatorId: UUID? = null,
    var capacitiveRating: Reactance,
    var inductiveRating: Reactance,
    var slope: VoltagePerReactivePower,
    @Enumerated(EnumType.STRING) var sVCControlMode: SVCControlMode,
    var voltageSetPoint: Voltage
)

data class DeleteStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID? = null)

// single association events
data class AssignCapacitiveRatingToStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID, val assignment: Reactance )
data class UnAssignCapacitiveRatingFromStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID? = null )
data class AssignInductiveRatingToStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID, val assignment: Reactance )
data class UnAssignInductiveRatingFromStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID? = null )
data class AssignSlopeToStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID, val assignment: VoltagePerReactivePower )
data class UnAssignSlopeFromStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID? = null )
data class AssignVoltageSetPointToStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID, val assignment: Voltage )
data class UnAssignVoltageSetPointFromStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID? = null )

// multiple association events


// Staticpowersystemmodel Events

data class CreateStaticpowersystemmodelEvent(
     var staticpowersystemmodelId: UUID? = null
)

data class UpdateStaticpowersystemmodelEvent(
     var staticpowersystemmodelId: UUID? = null
)

data class DeleteStaticpowersystemmodelEvent(@Id val staticpowersystemmodelId: UUID? = null)

// single association events

// multiple association events


// StationSupply Events

data class CreateStationSupplyEvent(
     var stationSupplyId: UUID? = null
)

data class UpdateStationSupplyEvent(
     var stationSupplyId: UUID? = null
)

data class DeleteStationSupplyEvent(@Id val stationSupplyId: UUID? = null)

// single association events

// multiple association events


// SteadyStateHypothesisVersion Events

data class CreateSteadyStateHypothesisVersionEvent(
     var steadyStateHypothesisVersionId: UUID? = null
)

data class UpdateSteadyStateHypothesisVersionEvent(
    @Id var steadyStateHypothesisVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURI: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURI: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignBaseURIToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignDateToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignDifferenceModelURIToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignEntsoeUMLToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignEntsoeURIToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignModelDescriptionURIToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignNamespaceRDFToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignNamespaceUMLToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )
data class AssignShortNameToSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null )

// multiple association events


// StringMeasurement Events

data class CreateStringMeasurementEvent(
     var stringMeasurementId: UUID? = null
)

data class UpdateStringMeasurementEvent(
     var stringMeasurementId: UUID? = null
)

data class DeleteStringMeasurementEvent(@Id val stringMeasurementId: UUID? = null)

// single association events

// multiple association events


// StringMeasurementValue Events

data class CreateStringMeasurementValueEvent(
     var stringMeasurementValueId: UUID? = null
)

data class UpdateStringMeasurementValueEvent(
    @Id var stringMeasurementValueId: UUID? = null,
    var value: StringProxy,
    var stringMeasurementValues:  Set<StringMeasurementValue>
)

data class DeleteStringMeasurementValueEvent(@Id val stringMeasurementValueId: UUID? = null)

// single association events
data class AssignValueToStringMeasurementValueEvent(@Id val stringMeasurementValueId: UUID, val assignment: StringProxy )
data class UnAssignValueFromStringMeasurementValueEvent(@Id val stringMeasurementValueId: UUID? = null )

// multiple association events
data class AssignStringMeasurementValuesToStringMeasurementValueEvent(@Id val stringMeasurementValueId: UUID, val addTo: StringMeasurementValue )
data class RemoveStringMeasurementValuesFromStringMeasurementValueEvent(@Id val stringMeasurementValueId: UUID, val removeFrom: StringMeasurementValue )


// StringProxy Events

data class CreateStringProxyEvent(
     var stringProxyId: UUID? = null
)

data class UpdateStringProxyEvent(
     var stringProxyId: UUID? = null
)

data class DeleteStringProxyEvent(@Id val stringProxyId: UUID? = null)

// single association events

// multiple association events


// SubGeographicalRegion Events

data class CreateSubGeographicalRegionEvent(
     var subGeographicalRegionId: UUID? = null
)

data class UpdateSubGeographicalRegionEvent(
    @Id var subGeographicalRegionId: UUID? = null,
    var regions:  Set<SubGeographicalRegion>
)

data class DeleteSubGeographicalRegionEvent(@Id val subGeographicalRegionId: UUID? = null)

// single association events

// multiple association events
data class AssignRegionsToSubGeographicalRegionEvent(@Id val subGeographicalRegionId: UUID, val addTo: SubGeographicalRegion )
data class RemoveRegionsFromSubGeographicalRegionEvent(@Id val subGeographicalRegionId: UUID, val removeFrom: SubGeographicalRegion )


// SubLoadArea Events

data class CreateSubLoadAreaEvent(
     var subLoadAreaId: UUID? = null
)

data class UpdateSubLoadAreaEvent(
    @Id var subLoadAreaId: UUID? = null,
    var subLoadAreas:  Set<SubLoadArea>
)

data class DeleteSubLoadAreaEvent(@Id val subLoadAreaId: UUID? = null)

// single association events

// multiple association events
data class AssignSubLoadAreasToSubLoadAreaEvent(@Id val subLoadAreaId: UUID, val addTo: SubLoadArea )
data class RemoveSubLoadAreasFromSubLoadAreaEvent(@Id val subLoadAreaId: UUID, val removeFrom: SubLoadArea )


// Substation Events

data class CreateSubstationEvent(
     var substationId: UUID? = null
)

data class UpdateSubstationEvent(
    @Id var substationId: UUID? = null,
    var substations:  Set<Substation>
)

data class DeleteSubstationEvent(@Id val substationId: UUID? = null)

// single association events

// multiple association events
data class AssignSubstationsToSubstationEvent(@Id val substationId: UUID, val addTo: Substation )
data class RemoveSubstationsFromSubstationEvent(@Id val substationId: UUID, val removeFrom: Substation )


// Susceptance Events

data class CreateSusceptanceEvent(
    @Id var susceptanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateSusceptanceEvent(
    @Id var susceptanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteSusceptanceEvent(@Id val susceptanceId: UUID? = null)

// single association events
data class AssignValueToSusceptanceEvent(@Id val susceptanceId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromSusceptanceEvent(@Id val susceptanceId: UUID? = null )

// multiple association events


// SvInjection Events

data class CreateSvInjectionEvent(
     var svInjectionId: UUID? = null
)

data class UpdateSvInjectionEvent(
    @Id var svInjectionId: UUID? = null,
    var pInjection: ActivePower,
    var qInjection: ReactivePower,
    var svInjection: SvInjection
)

data class DeleteSvInjectionEvent(@Id val svInjectionId: UUID? = null)

// single association events
data class AssignPInjectionToSvInjectionEvent(@Id val svInjectionId: UUID, val assignment: ActivePower )
data class UnAssignPInjectionFromSvInjectionEvent(@Id val svInjectionId: UUID? = null )
data class AssignQInjectionToSvInjectionEvent(@Id val svInjectionId: UUID, val assignment: ReactivePower )
data class UnAssignQInjectionFromSvInjectionEvent(@Id val svInjectionId: UUID? = null )
data class AssignSvInjectionToSvInjectionEvent(@Id val svInjectionId: UUID, val assignment: SvInjection )
data class UnAssignSvInjectionFromSvInjectionEvent(@Id val svInjectionId: UUID? = null )

// multiple association events


// SvPowerFlow Events

data class CreateSvPowerFlowEvent(
     var svPowerFlowId: UUID? = null
)

data class UpdateSvPowerFlowEvent(
    @Id var svPowerFlowId: UUID? = null,
    var p: ActivePower,
    var q: ReactivePower,
    var svPowerFlow: SvPowerFlow
)

data class DeleteSvPowerFlowEvent(@Id val svPowerFlowId: UUID? = null)

// single association events
data class AssignPToSvPowerFlowEvent(@Id val svPowerFlowId: UUID, val assignment: ActivePower )
data class UnAssignPFromSvPowerFlowEvent(@Id val svPowerFlowId: UUID? = null )
data class AssignQToSvPowerFlowEvent(@Id val svPowerFlowId: UUID, val assignment: ReactivePower )
data class UnAssignQFromSvPowerFlowEvent(@Id val svPowerFlowId: UUID? = null )
data class AssignSvPowerFlowToSvPowerFlowEvent(@Id val svPowerFlowId: UUID, val assignment: SvPowerFlow )
data class UnAssignSvPowerFlowFromSvPowerFlowEvent(@Id val svPowerFlowId: UUID? = null )

// multiple association events


// SvShuntCompensatorSections Events

data class CreateSvShuntCompensatorSectionsEvent(
     var svShuntCompensatorSectionsId: UUID? = null
)

data class UpdateSvShuntCompensatorSectionsEvent(
    @Id var svShuntCompensatorSectionsId: UUID? = null,
    var sections: Simple_Float,
    var svShuntCompensatorSections: SvShuntCompensatorSections
)

data class DeleteSvShuntCompensatorSectionsEvent(@Id val svShuntCompensatorSectionsId: UUID? = null)

// single association events
data class AssignSectionsToSvShuntCompensatorSectionsEvent(@Id val svShuntCompensatorSectionsId: UUID, val assignment: Simple_Float )
data class UnAssignSectionsFromSvShuntCompensatorSectionsEvent(@Id val svShuntCompensatorSectionsId: UUID? = null )
data class AssignSvShuntCompensatorSectionsToSvShuntCompensatorSectionsEvent(@Id val svShuntCompensatorSectionsId: UUID, val assignment: SvShuntCompensatorSections )
data class UnAssignSvShuntCompensatorSectionsFromSvShuntCompensatorSectionsEvent(@Id val svShuntCompensatorSectionsId: UUID? = null )

// multiple association events


// SvStatus Events

data class CreateSvStatusEvent(
     var svStatusId: UUID? = null
)

data class UpdateSvStatusEvent(
    @Id var svStatusId: UUID? = null,
    var inService: BooleanProxy,
    var svStatus: SvStatus
)

data class DeleteSvStatusEvent(@Id val svStatusId: UUID? = null)

// single association events
data class AssignInServiceToSvStatusEvent(@Id val svStatusId: UUID, val assignment: BooleanProxy )
data class UnAssignInServiceFromSvStatusEvent(@Id val svStatusId: UUID? = null )
data class AssignSvStatusToSvStatusEvent(@Id val svStatusId: UUID, val assignment: SvStatus )
data class UnAssignSvStatusFromSvStatusEvent(@Id val svStatusId: UUID? = null )

// multiple association events


// SvTapStep Events

data class CreateSvTapStepEvent(
     var svTapStepId: UUID? = null
)

data class UpdateSvTapStepEvent(
    @Id var svTapStepId: UUID? = null,
    var position: Simple_Float,
    var svTapStep: SvTapStep
)

data class DeleteSvTapStepEvent(@Id val svTapStepId: UUID? = null)

// single association events
data class AssignPositionToSvTapStepEvent(@Id val svTapStepId: UUID, val assignment: Simple_Float )
data class UnAssignPositionFromSvTapStepEvent(@Id val svTapStepId: UUID? = null )
data class AssignSvTapStepToSvTapStepEvent(@Id val svTapStepId: UUID, val assignment: SvTapStep )
data class UnAssignSvTapStepFromSvTapStepEvent(@Id val svTapStepId: UUID? = null )

// multiple association events


// SvVoltage Events

data class CreateSvVoltageEvent(
     var svVoltageId: UUID? = null
)

data class UpdateSvVoltageEvent(
    @Id var svVoltageId: UUID? = null,
    var angle: AngleDegrees,
    var v: Voltage,
    var svVoltage: SvVoltage
)

data class DeleteSvVoltageEvent(@Id val svVoltageId: UUID? = null)

// single association events
data class AssignAngleToSvVoltageEvent(@Id val svVoltageId: UUID, val assignment: AngleDegrees )
data class UnAssignAngleFromSvVoltageEvent(@Id val svVoltageId: UUID? = null )
data class AssignVToSvVoltageEvent(@Id val svVoltageId: UUID, val assignment: Voltage )
data class UnAssignVFromSvVoltageEvent(@Id val svVoltageId: UUID? = null )
data class AssignSvVoltageToSvVoltageEvent(@Id val svVoltageId: UUID, val assignment: SvVoltage )
data class UnAssignSvVoltageFromSvVoltageEvent(@Id val svVoltageId: UUID? = null )

// multiple association events


// SwitchIt Events

data class CreateSwitchItEvent(
     var switchItId: UUID? = null
)

data class UpdateSwitchItEvent(
    @Id var switchItId: UUID? = null,
    var open: BooleanProxy
)

data class DeleteSwitchItEvent(@Id val switchItId: UUID? = null)

// single association events
data class AssignOpenToSwitchItEvent(@Id val switchItId: UUID, val assignment: BooleanProxy )
data class UnAssignOpenFromSwitchItEvent(@Id val switchItId: UUID? = null )

// multiple association events


// SwitchProxy Events

data class CreateSwitchProxyEvent(
     var switchProxyId: UUID? = null
)

data class UpdateSwitchProxyEvent(
    @Id var switchProxyId: UUID? = null,
    var normalOpen: BooleanProxy,
    var ratedCurrent: CurrentFlow,
    var retained: BooleanProxy
)

data class DeleteSwitchProxyEvent(@Id val switchProxyId: UUID? = null)

// single association events
data class AssignNormalOpenToSwitchProxyEvent(@Id val switchProxyId: UUID, val assignment: BooleanProxy )
data class UnAssignNormalOpenFromSwitchProxyEvent(@Id val switchProxyId: UUID? = null )
data class AssignRatedCurrentToSwitchProxyEvent(@Id val switchProxyId: UUID, val assignment: CurrentFlow )
data class UnAssignRatedCurrentFromSwitchProxyEvent(@Id val switchProxyId: UUID? = null )
data class AssignRetainedToSwitchProxyEvent(@Id val switchProxyId: UUID, val assignment: BooleanProxy )
data class UnAssignRetainedFromSwitchProxyEvent(@Id val switchProxyId: UUID? = null )

// multiple association events


// SwitchSchedule Events

data class CreateSwitchScheduleEvent(
     var switchScheduleId: UUID? = null
)

data class UpdateSwitchScheduleEvent(
    @Id var switchScheduleId: UUID? = null,
    var switchSchedules:  Set<SwitchSchedule>
)

data class DeleteSwitchScheduleEvent(@Id val switchScheduleId: UUID? = null)

// single association events

// multiple association events
data class AssignSwitchSchedulesToSwitchScheduleEvent(@Id val switchScheduleId: UUID, val addTo: SwitchSchedule )
data class RemoveSwitchSchedulesFromSwitchScheduleEvent(@Id val switchScheduleId: UUID, val removeFrom: SwitchSchedule )


// SynchronousMachine Events

data class CreateSynchronousMachineEvent(
    @Id var synchronousMachineId: UUID? = null,
    @Enumerated(EnumType.STRING) var shortCircuitRotorType: ShortCircuitRotorKind,
    @Enumerated(EnumType.STRING) var type: SynchronousMachineKind
)

data class UpdateSynchronousMachineEvent(
    @Id var synchronousMachineId: UUID? = null,
    var earthing: BooleanProxy,
    var earthingStarPointR: Resistance,
    var earthingStarPointX: Reactance,
    var ikk: CurrentFlow,
    var maxQ: ReactivePower,
    var minQ: ReactivePower,
    var mu: Simple_Float,
    var qPercent: PerCent,
    var r: Resistance,
    var r0: PU,
    var r2: PU,
    var satDirectSubtransX: PU,
    var satDirectSyncX: PU,
    var satDirectTransX: PU,
    @Enumerated(EnumType.STRING) var shortCircuitRotorType: ShortCircuitRotorKind,
    @Enumerated(EnumType.STRING) var type: SynchronousMachineKind,
    var voltageRegulationRange: PerCent,
    var x0: PU,
    var x2: PU,
    var initiallyUsedBySynchronousMachines:  Set<SynchronousMachine>
)

data class DeleteSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null)

// single association events
data class AssignEarthingToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: BooleanProxy )
data class UnAssignEarthingFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignEarthingStarPointRToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: Resistance )
data class UnAssignEarthingStarPointRFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignEarthingStarPointXToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: Reactance )
data class UnAssignEarthingStarPointXFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignIkkToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: CurrentFlow )
data class UnAssignIkkFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignMaxQToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: ReactivePower )
data class UnAssignMaxQFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignMinQToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: ReactivePower )
data class UnAssignMinQFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignMuToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: Simple_Float )
data class UnAssignMuFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignQPercentToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PerCent )
data class UnAssignQPercentFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignRToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: Resistance )
data class UnAssignRFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignR0ToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PU )
data class UnAssignR0FromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignR2ToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PU )
data class UnAssignR2FromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignSatDirectSubtransXToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PU )
data class UnAssignSatDirectSubtransXFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignSatDirectSyncXToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PU )
data class UnAssignSatDirectSyncXFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignSatDirectTransXToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PU )
data class UnAssignSatDirectTransXFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignVoltageRegulationRangeToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PerCent )
data class UnAssignVoltageRegulationRangeFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignX0ToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PU )
data class UnAssignX0FromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )
data class AssignX2ToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val assignment: PU )
data class UnAssignX2FromSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null )

// multiple association events
data class AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val addTo: SynchronousMachine )
data class RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent(@Id val synchronousMachineId: UUID, val removeFrom: SynchronousMachine )


// SynchronousMachineDetailed Events

data class CreateSynchronousMachineDetailedEvent(
    @Id var synchronousMachineDetailedId: UUID? = null,
    @Enumerated(EnumType.STRING) var ifdBaseType: IfdBaseKind
)

data class UpdateSynchronousMachineDetailedEvent(
    @Id var synchronousMachineDetailedId: UUID? = null,
    var efdBaseRatio: Simple_Float,
    @Enumerated(EnumType.STRING) var ifdBaseType: IfdBaseKind,
    var ifdBaseValue: CurrentFlow,
    var saturationFactor120QAxis: Simple_Float,
    var saturationFactorQAxis: Simple_Float
)

data class DeleteSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID? = null)

// single association events
data class AssignEfdBaseRatioToSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID, val assignment: Simple_Float )
data class UnAssignEfdBaseRatioFromSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID? = null )
data class AssignIfdBaseValueToSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID, val assignment: CurrentFlow )
data class UnAssignIfdBaseValueFromSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID? = null )
data class AssignSaturationFactor120QAxisToSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID, val assignment: Simple_Float )
data class UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID? = null )
data class AssignSaturationFactorQAxisToSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID, val assignment: Simple_Float )
data class UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID? = null )

// multiple association events


// SynchronousMachineDynamics Events

data class CreateSynchronousMachineDynamicsEvent(
     var synchronousMachineDynamicsId: UUID? = null
)

data class UpdateSynchronousMachineDynamicsEvent(
    @Id var synchronousMachineDynamicsId: UUID? = null,
    var synchronousMachineDynamics: SynchronousMachineDynamics
)

data class DeleteSynchronousMachineDynamicsEvent(@Id val synchronousMachineDynamicsId: UUID? = null)

// single association events
data class AssignSynchronousMachineDynamicsToSynchronousMachineDynamicsEvent(@Id val synchronousMachineDynamicsId: UUID, val assignment: SynchronousMachineDynamics )
data class UnAssignSynchronousMachineDynamicsFromSynchronousMachineDynamicsEvent(@Id val synchronousMachineDynamicsId: UUID? = null )

// multiple association events


// SynchronousMachineEquivalentCircuit Events

data class CreateSynchronousMachineEquivalentCircuitEvent(
     var synchronousMachineEquivalentCircuitId: UUID? = null
)

data class UpdateSynchronousMachineEquivalentCircuitEvent(
    @Id var synchronousMachineEquivalentCircuitId: UUID? = null,
    var r1d: PU,
    var r1q: PU,
    var r2q: PU,
    var rfd: PU,
    var x1d: PU,
    var x1q: PU,
    var x2q: PU,
    var xad: PU,
    var xaq: PU,
    var xf1d: PU,
    var xfd: PU
)

data class DeleteSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null)

// single association events
data class AssignR1dToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignR1dFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignR1qToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignR1qFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignR2qToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignR2qFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignRfdToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignRfdFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignX1dToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignX1dFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignX1qToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignX1qFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignX2qToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignX2qFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignXadToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignXadFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignXaqToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignXaqFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignXf1dToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignXf1dFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )
data class AssignXfdToSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID, val assignment: PU )
data class UnAssignXfdFromSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null )

// multiple association events


// SynchronousMachineSimplified Events

data class CreateSynchronousMachineSimplifiedEvent(
     var synchronousMachineSimplifiedId: UUID? = null
)

data class UpdateSynchronousMachineSimplifiedEvent(
     var synchronousMachineSimplifiedId: UUID? = null
)

data class DeleteSynchronousMachineSimplifiedEvent(@Id val synchronousMachineSimplifiedId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineTimeConstantReactance Events

data class CreateSynchronousMachineTimeConstantReactanceEvent(
    @Id var synchronousMachineTimeConstantReactanceId: UUID? = null,
    @Enumerated(EnumType.STRING) var modelType: SynchronousMachineModelKind,
    @Enumerated(EnumType.STRING) var rotorType: RotorKind
)

data class UpdateSynchronousMachineTimeConstantReactanceEvent(
    @Id var synchronousMachineTimeConstantReactanceId: UUID? = null,
    var ks: Simple_Float,
    @Enumerated(EnumType.STRING) var modelType: SynchronousMachineModelKind,
    @Enumerated(EnumType.STRING) var rotorType: RotorKind,
    var tc: Seconds,
    var tpdo: Seconds,
    var tppdo: Seconds,
    var tppqo: Seconds,
    var tpqo: Seconds,
    var xDirectSubtrans: PU,
    var xDirectSync: PU,
    var xDirectTrans: PU,
    var xQuadSubtrans: PU,
    var xQuadSync: PU,
    var xQuadTrans: PU
)

data class DeleteSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null)

// single association events
data class AssignKsToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: Simple_Float )
data class UnAssignKsFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignTcToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: Seconds )
data class UnAssignTcFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignTpdoToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: Seconds )
data class UnAssignTpdoFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignTppdoToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: Seconds )
data class UnAssignTppdoFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignTppqoToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: Seconds )
data class UnAssignTppqoFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignTpqoToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: Seconds )
data class UnAssignTpqoFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXDirectSyncToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXDirectTransToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXQuadSyncToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )
data class AssignXQuadTransToSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID, val assignment: PU )
data class UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null )

// multiple association events


// SynchronousMachineUserDefined Events

data class CreateSynchronousMachineUserDefinedEvent(
     var synchronousMachineUserDefinedId: UUID? = null
)

data class UpdateSynchronousMachineUserDefinedEvent(
    @Id var synchronousMachineUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteSynchronousMachineUserDefinedEvent(@Id val synchronousMachineUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToSynchronousMachineUserDefinedEvent(@Id val synchronousMachineUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromSynchronousMachineUserDefinedEvent(@Id val synchronousMachineUserDefinedId: UUID? = null )

// multiple association events


// TapChanger Events

data class CreateTapChangerEvent(
     var tapChangerId: UUID? = null
)

data class UpdateTapChangerEvent(
    @Id var tapChangerId: UUID? = null,
    var highStep: IntegerProxy,
    var lowStep: IntegerProxy,
    var ltcFlag: BooleanProxy,
    var neutralStep: IntegerProxy,
    var neutralU: Voltage,
    var normalStep: IntegerProxy,
    var tapChanger:  Set<TapChanger>
)

data class DeleteTapChangerEvent(@Id val tapChangerId: UUID? = null)

// single association events
data class AssignHighStepToTapChangerEvent(@Id val tapChangerId: UUID, val assignment: IntegerProxy )
data class UnAssignHighStepFromTapChangerEvent(@Id val tapChangerId: UUID? = null )
data class AssignLowStepToTapChangerEvent(@Id val tapChangerId: UUID, val assignment: IntegerProxy )
data class UnAssignLowStepFromTapChangerEvent(@Id val tapChangerId: UUID? = null )
data class AssignLtcFlagToTapChangerEvent(@Id val tapChangerId: UUID, val assignment: BooleanProxy )
data class UnAssignLtcFlagFromTapChangerEvent(@Id val tapChangerId: UUID? = null )
data class AssignNeutralStepToTapChangerEvent(@Id val tapChangerId: UUID, val assignment: IntegerProxy )
data class UnAssignNeutralStepFromTapChangerEvent(@Id val tapChangerId: UUID? = null )
data class AssignNeutralUToTapChangerEvent(@Id val tapChangerId: UUID, val assignment: Voltage )
data class UnAssignNeutralUFromTapChangerEvent(@Id val tapChangerId: UUID? = null )
data class AssignNormalStepToTapChangerEvent(@Id val tapChangerId: UUID, val assignment: IntegerProxy )
data class UnAssignNormalStepFromTapChangerEvent(@Id val tapChangerId: UUID? = null )

// multiple association events
data class AssignTapChangerToTapChangerEvent(@Id val tapChangerId: UUID, val addTo: TapChanger )
data class RemoveTapChangerFromTapChangerEvent(@Id val tapChangerId: UUID, val removeFrom: TapChanger )


// TapChangerControl Events

data class CreateTapChangerControlEvent(
     var tapChangerControlId: UUID? = null
)

data class UpdateTapChangerControlEvent(
     var tapChangerControlId: UUID? = null
)

data class DeleteTapChangerControlEvent(@Id val tapChangerControlId: UUID? = null)

// single association events

// multiple association events


// TapChangerTablePoint Events

data class CreateTapChangerTablePointEvent(
     var tapChangerTablePointId: UUID? = null
)

data class UpdateTapChangerTablePointEvent(
    @Id var tapChangerTablePointId: UUID? = null,
    var b: PerCent,
    var g: PerCent,
    var r: PerCent,
    var ratio: Simple_Float,
    var step: IntegerProxy,
    var x: PerCent
)

data class DeleteTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID? = null)

// single association events
data class AssignBToTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID, val assignment: PerCent )
data class UnAssignBFromTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID? = null )
data class AssignGToTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID, val assignment: PerCent )
data class UnAssignGFromTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID? = null )
data class AssignRToTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID, val assignment: PerCent )
data class UnAssignRFromTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID? = null )
data class AssignRatioToTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID, val assignment: Simple_Float )
data class UnAssignRatioFromTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID? = null )
data class AssignStepToTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID, val assignment: IntegerProxy )
data class UnAssignStepFromTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID? = null )
data class AssignXToTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID, val assignment: PerCent )
data class UnAssignXFromTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID? = null )

// multiple association events


// TapSchedule Events

data class CreateTapScheduleEvent(
     var tapScheduleId: UUID? = null
)

data class UpdateTapScheduleEvent(
    @Id var tapScheduleId: UUID? = null,
    var tapSchedules:  Set<TapSchedule>
)

data class DeleteTapScheduleEvent(@Id val tapScheduleId: UUID? = null)

// single association events

// multiple association events
data class AssignTapSchedulesToTapScheduleEvent(@Id val tapScheduleId: UUID, val addTo: TapSchedule )
data class RemoveTapSchedulesFromTapScheduleEvent(@Id val tapScheduleId: UUID, val removeFrom: TapSchedule )


// Temperature Events

data class CreateTemperatureEvent(
    @Id var temperatureId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateTemperatureEvent(
    @Id var temperatureId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteTemperatureEvent(@Id val temperatureId: UUID? = null)

// single association events
data class AssignValueToTemperatureEvent(@Id val temperatureId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromTemperatureEvent(@Id val temperatureId: UUID? = null )

// multiple association events


// Terminal Events

data class CreateTerminalEvent(
     var terminalId: UUID? = null
)

data class UpdateTerminalEvent(
    @Id var terminalId: UUID? = null,
    var terminals:  Set<Terminal>
)

data class DeleteTerminalEvent(@Id val terminalId: UUID? = null)

// single association events

// multiple association events
data class AssignTerminalsToTerminalEvent(@Id val terminalId: UUID, val addTo: Terminal )
data class RemoveTerminalsFromTerminalEvent(@Id val terminalId: UUID, val removeFrom: Terminal )


// TextDiagramObject Events

data class CreateTextDiagramObjectEvent(
     var textDiagramObjectId: UUID? = null
)

data class UpdateTextDiagramObjectEvent(
    @Id var textDiagramObjectId: UUID? = null,
    var text: StringProxy
)

data class DeleteTextDiagramObjectEvent(@Id val textDiagramObjectId: UUID? = null)

// single association events
data class AssignTextToTextDiagramObjectEvent(@Id val textDiagramObjectId: UUID, val assignment: StringProxy )
data class UnAssignTextFromTextDiagramObjectEvent(@Id val textDiagramObjectId: UUID? = null )

// multiple association events


// ThermalGeneratingUnit Events

data class CreateThermalGeneratingUnitEvent(
     var thermalGeneratingUnitId: UUID? = null
)

data class UpdateThermalGeneratingUnitEvent(
     var thermalGeneratingUnitId: UUID? = null
)

data class DeleteThermalGeneratingUnitEvent(@Id val thermalGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// TieFlow Events

data class CreateTieFlowEvent(
     var tieFlowId: UUID? = null
)

data class UpdateTieFlowEvent(
    @Id var tieFlowId: UUID? = null,
    var positiveFlowIn: BooleanProxy,
    var tieFlow:  Set<TieFlow>
)

data class DeleteTieFlowEvent(@Id val tieFlowId: UUID? = null)

// single association events
data class AssignPositiveFlowInToTieFlowEvent(@Id val tieFlowId: UUID, val assignment: BooleanProxy )
data class UnAssignPositiveFlowInFromTieFlowEvent(@Id val tieFlowId: UUID? = null )

// multiple association events
data class AssignTieFlowToTieFlowEvent(@Id val tieFlowId: UUID, val addTo: TieFlow )
data class RemoveTieFlowFromTieFlowEvent(@Id val tieFlowId: UUID, val removeFrom: TieFlow )


// TopologicalIsland Events

data class CreateTopologicalIslandEvent(
     var topologicalIslandId: UUID? = null
)

data class UpdateTopologicalIslandEvent(
    @Id var topologicalIslandId: UUID? = null,
    var topologicalIsland: TopologicalIsland,
    var angleRefTopologicalIsland: TopologicalIsland
)

data class DeleteTopologicalIslandEvent(@Id val topologicalIslandId: UUID? = null)

// single association events
data class AssignTopologicalIslandToTopologicalIslandEvent(@Id val topologicalIslandId: UUID, val assignment: TopologicalIsland )
data class UnAssignTopologicalIslandFromTopologicalIslandEvent(@Id val topologicalIslandId: UUID? = null )
data class AssignAngleRefTopologicalIslandToTopologicalIslandEvent(@Id val topologicalIslandId: UUID, val assignment: TopologicalIsland )
data class UnAssignAngleRefTopologicalIslandFromTopologicalIslandEvent(@Id val topologicalIslandId: UUID? = null )

// multiple association events


// TopologicalNode Events

data class CreateTopologicalNodeEvent(
     var topologicalNodeId: UUID? = null
)

data class UpdateTopologicalNodeEvent(
    @Id var topologicalNodeId: UUID? = null,
    var boundaryPoint: BooleanProxy,
    var fromEndIsoCode: StringProxy,
    var fromEndName: StringProxy,
    var fromEndNameTso: StringProxy,
    var toEndIsoCode: StringProxy,
    var toEndName: StringProxy,
    var toEndNameTso: StringProxy,
    var topologicalNode:  Set<TopologicalNode>
)

data class DeleteTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null)

// single association events
data class AssignBoundaryPointToTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val assignment: BooleanProxy )
data class UnAssignBoundaryPointFromTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null )
data class AssignFromEndIsoCodeToTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val assignment: StringProxy )
data class UnAssignFromEndIsoCodeFromTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null )
data class AssignFromEndNameToTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val assignment: StringProxy )
data class UnAssignFromEndNameFromTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null )
data class AssignFromEndNameTsoToTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val assignment: StringProxy )
data class UnAssignFromEndNameTsoFromTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null )
data class AssignToEndIsoCodeToTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val assignment: StringProxy )
data class UnAssignToEndIsoCodeFromTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null )
data class AssignToEndNameToTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val assignment: StringProxy )
data class UnAssignToEndNameFromTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null )
data class AssignToEndNameTsoToTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val assignment: StringProxy )
data class UnAssignToEndNameTsoFromTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null )

// multiple association events
data class AssignTopologicalNodeToTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val addTo: TopologicalNode )
data class RemoveTopologicalNodeFromTopologicalNodeEvent(@Id val topologicalNodeId: UUID, val removeFrom: TopologicalNode )


// TopologyBoundaryVersion Events

data class CreateTopologyBoundaryVersionEvent(
     var topologyBoundaryVersionId: UUID? = null
)

data class UpdateTopologyBoundaryVersionEvent(
    @Id var topologyBoundaryVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURI: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURI: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignBaseURIToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignDateToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignDifferenceModelURIToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignEntsoeUMLToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignEntsoeURIToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignModelDescriptionURIToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignNamespaceRDFToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignNamespaceUMLToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )
data class AssignShortNameToTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null )

// multiple association events


// TopologyVersion Events

data class CreateTopologyVersionEvent(
     var topologyVersionId: UUID? = null
)

data class UpdateTopologyVersionEvent(
    @Id var topologyVersionId: UUID? = null,
    var baseUML: StringProxy,
    var baseURI: StringProxy,
    var date: DateProxy,
    var differenceModelURI: StringProxy,
    var entsoeUML: StringProxy,
    var entsoeURI: StringProxy,
    var modelDescriptionURI: StringProxy,
    var namespaceRDF: StringProxy,
    var namespaceUML: StringProxy,
    var shortName: StringProxy
)

data class DeleteTopologyVersionEvent(@Id val topologyVersionId: UUID? = null)

// single association events
data class AssignBaseUMLToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseUMLFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignBaseURIToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignBaseURIFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignDateToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: DateProxy )
data class UnAssignDateFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignDifferenceModelURIToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignDifferenceModelURIFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignEntsoeUMLToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeUMLFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignEntsoeURIToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignEntsoeURIFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignModelDescriptionURIToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignModelDescriptionURIFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignNamespaceRDFToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceRDFFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignNamespaceUMLToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignNamespaceUMLFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )
data class AssignShortNameToTopologyVersionEvent(@Id val topologyVersionId: UUID, val assignment: StringProxy )
data class UnAssignShortNameFromTopologyVersionEvent(@Id val topologyVersionId: UUID? = null )

// multiple association events


// TransformerEnd Events

data class CreateTransformerEndEvent(
     var transformerEndId: UUID? = null
)

data class UpdateTransformerEndEvent(
    @Id var transformerEndId: UUID? = null,
    var endNumber: IntegerProxy,
    var grounded: BooleanProxy,
    var rground: Resistance,
    var xground: Reactance,
    var transformerEnds:  Set<TransformerEnd>,
    var transformerEnd:  Set<TransformerEnd>
)

data class DeleteTransformerEndEvent(@Id val transformerEndId: UUID? = null)

// single association events
data class AssignEndNumberToTransformerEndEvent(@Id val transformerEndId: UUID, val assignment: IntegerProxy )
data class UnAssignEndNumberFromTransformerEndEvent(@Id val transformerEndId: UUID? = null )
data class AssignGroundedToTransformerEndEvent(@Id val transformerEndId: UUID, val assignment: BooleanProxy )
data class UnAssignGroundedFromTransformerEndEvent(@Id val transformerEndId: UUID? = null )
data class AssignRgroundToTransformerEndEvent(@Id val transformerEndId: UUID, val assignment: Resistance )
data class UnAssignRgroundFromTransformerEndEvent(@Id val transformerEndId: UUID? = null )
data class AssignXgroundToTransformerEndEvent(@Id val transformerEndId: UUID, val assignment: Reactance )
data class UnAssignXgroundFromTransformerEndEvent(@Id val transformerEndId: UUID? = null )

// multiple association events
data class AssignTransformerEndsToTransformerEndEvent(@Id val transformerEndId: UUID, val addTo: TransformerEnd )
data class RemoveTransformerEndsFromTransformerEndEvent(@Id val transformerEndId: UUID, val removeFrom: TransformerEnd )
data class AssignTransformerEndToTransformerEndEvent(@Id val transformerEndId: UUID, val addTo: TransformerEnd )
data class RemoveTransformerEndFromTransformerEndEvent(@Id val transformerEndId: UUID, val removeFrom: TransformerEnd )


// TurbLCFB1 Events

data class CreateTurbLCFB1Event(
     var turbLCFB1Id: UUID? = null
)

data class UpdateTurbLCFB1Event(
    @Id var turbLCFB1Id: UUID? = null,
    var db: PU,
    var emax: PU,
    var fb: PU,
    var fbf: BooleanProxy,
    var irmax: PU,
    var ki: PU,
    var kp: PU,
    var mwbase: ActivePower,
    var pbf: BooleanProxy,
    var pmwset: ActivePower,
    var speedReferenceGovernor: BooleanProxy,
    var tpelec: Seconds
)

data class DeleteTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null)

// single association events
data class AssignDbToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: PU )
data class UnAssignDbFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignEmaxToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: PU )
data class UnAssignEmaxFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignFbToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: PU )
data class UnAssignFbFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignFbfToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: BooleanProxy )
data class UnAssignFbfFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignIrmaxToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: PU )
data class UnAssignIrmaxFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignKiToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: PU )
data class UnAssignKiFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignKpToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: PU )
data class UnAssignKpFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignMwbaseToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: ActivePower )
data class UnAssignMwbaseFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignPbfToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: BooleanProxy )
data class UnAssignPbfFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignPmwsetToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: ActivePower )
data class UnAssignPmwsetFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignSpeedReferenceGovernorToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: BooleanProxy )
data class UnAssignSpeedReferenceGovernorFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )
data class AssignTpelecToTurbLCFB1Event(@Id val turbLCFB1Id: UUID, val assignment: Seconds )
data class UnAssignTpelecFromTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null )

// multiple association events


// TurbineGovernorDynamics Events

data class CreateTurbineGovernorDynamicsEvent(
     var turbineGovernorDynamicsId: UUID? = null
)

data class UpdateTurbineGovernorDynamicsEvent(
    @Id var turbineGovernorDynamicsId: UUID? = null,
    var turbineGovernorDynamics: TurbineGovernorDynamics
)

data class DeleteTurbineGovernorDynamicsEvent(@Id val turbineGovernorDynamicsId: UUID? = null)

// single association events
data class AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsEvent(@Id val turbineGovernorDynamicsId: UUID, val assignment: TurbineGovernorDynamics )
data class UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsEvent(@Id val turbineGovernorDynamicsId: UUID? = null )

// multiple association events


// TurbineGovernorUserDefined Events

data class CreateTurbineGovernorUserDefinedEvent(
     var turbineGovernorUserDefinedId: UUID? = null
)

data class UpdateTurbineGovernorUserDefinedEvent(
    @Id var turbineGovernorUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteTurbineGovernorUserDefinedEvent(@Id val turbineGovernorUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToTurbineGovernorUserDefinedEvent(@Id val turbineGovernorUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromTurbineGovernorUserDefinedEvent(@Id val turbineGovernorUserDefinedId: UUID? = null )

// multiple association events


// TurbineLoadControllerDynamics Events

data class CreateTurbineLoadControllerDynamicsEvent(
     var turbineLoadControllerDynamicsId: UUID? = null
)

data class UpdateTurbineLoadControllerDynamicsEvent(
    @Id var turbineLoadControllerDynamicsId: UUID? = null,
    var turbineLoadControllerDynamics: TurbineLoadControllerDynamics
)

data class DeleteTurbineLoadControllerDynamicsEvent(@Id val turbineLoadControllerDynamicsId: UUID? = null)

// single association events
data class AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsEvent(@Id val turbineLoadControllerDynamicsId: UUID, val assignment: TurbineLoadControllerDynamics )
data class UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsEvent(@Id val turbineLoadControllerDynamicsId: UUID? = null )

// multiple association events


// TurbineLoadControllerUserDefined Events

data class CreateTurbineLoadControllerUserDefinedEvent(
     var turbineLoadControllerUserDefinedId: UUID? = null
)

data class UpdateTurbineLoadControllerUserDefinedEvent(
    @Id var turbineLoadControllerUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteTurbineLoadControllerUserDefinedEvent(@Id val turbineLoadControllerUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToTurbineLoadControllerUserDefinedEvent(@Id val turbineLoadControllerUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromTurbineLoadControllerUserDefinedEvent(@Id val turbineLoadControllerUserDefinedId: UUID? = null )

// multiple association events


// UnderexcLim2Simplified Events

data class CreateUnderexcLim2SimplifiedEvent(
     var underexcLim2SimplifiedId: UUID? = null
)

data class UpdateUnderexcLim2SimplifiedEvent(
    @Id var underexcLim2SimplifiedId: UUID? = null,
    var kui: PU,
    var p0: PU,
    var p1: PU,
    var q0: PU,
    var q1: PU,
    var vuimax: PU,
    var vuimin: PU
)

data class DeleteUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null)

// single association events
data class AssignKuiToUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID, val assignment: PU )
data class UnAssignKuiFromUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null )
data class AssignP0ToUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID, val assignment: PU )
data class UnAssignP0FromUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null )
data class AssignP1ToUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID, val assignment: PU )
data class UnAssignP1FromUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null )
data class AssignQ0ToUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID, val assignment: PU )
data class UnAssignQ0FromUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null )
data class AssignQ1ToUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID, val assignment: PU )
data class UnAssignQ1FromUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null )
data class AssignVuimaxToUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID, val assignment: PU )
data class UnAssignVuimaxFromUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null )
data class AssignVuiminToUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID, val assignment: PU )
data class UnAssignVuiminFromUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null )

// multiple association events


// UnderexcLimIEEE1 Events

data class CreateUnderexcLimIEEE1Event(
     var underexcLimIEEE1Id: UUID? = null
)

data class UpdateUnderexcLimIEEE1Event(
    @Id var underexcLimIEEE1Id: UUID? = null,
    var kuc: PU,
    var kuf: PU,
    var kui: PU,
    var kul: PU,
    var kur: PU,
    var tu1: Seconds,
    var tu2: Seconds,
    var tu3: Seconds,
    var tu4: Seconds,
    var vucmax: PU,
    var vuimax: PU,
    var vuimin: PU,
    var vulmax: PU,
    var vulmin: PU,
    var vurmax: PU
)

data class DeleteUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null)

// single association events
data class AssignKucToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignKucFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignKufToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignKufFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignKuiToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignKuiFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignKulToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignKulFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignKurToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignKurFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignTu1ToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignTu1FromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignTu2ToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignTu2FromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignTu3ToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignTu3FromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignTu4ToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: Seconds )
data class UnAssignTu4FromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignVucmaxToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignVucmaxFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignVuimaxToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignVuimaxFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignVuiminToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignVuiminFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignVulmaxToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignVulmaxFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignVulminToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignVulminFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )
data class AssignVurmaxToUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID, val assignment: PU )
data class UnAssignVurmaxFromUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null )

// multiple association events


// UnderexcLimIEEE2 Events

data class CreateUnderexcLimIEEE2Event(
     var underexcLimIEEE2Id: UUID? = null
)

data class UpdateUnderexcLimIEEE2Event(
    @Id var underexcLimIEEE2Id: UUID? = null,
    var k1: Simple_Float,
    var k2: Simple_Float,
    var kfb: PU,
    var kuf: PU,
    var kui: PU,
    var kul: PU,
    var p0: PU,
    var p1: PU,
    var p10: PU,
    var p2: PU,
    var p3: PU,
    var p4: PU,
    var p5: PU,
    var p6: PU,
    var p7: PU,
    var p8: PU,
    var p9: PU,
    var q0: PU,
    var q1: PU,
    var q10: PU,
    var q2: PU,
    var q3: PU,
    var q4: PU,
    var q5: PU,
    var q6: PU,
    var q7: PU,
    var q8: PU,
    var q9: PU,
    var tu1: Seconds,
    var tu2: Seconds,
    var tu3: Seconds,
    var tu4: Seconds,
    var tul: Seconds,
    var tup: Seconds,
    var tuq: Seconds,
    var tuv: Seconds,
    var vuimax: PU,
    var vuimin: PU,
    var vulmax: PU,
    var vulmin: PU
)

data class DeleteUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null)

// single association events
data class AssignK1ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Simple_Float )
data class UnAssignK1FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignK2ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Simple_Float )
data class UnAssignK2FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignKfbToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignKfbFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignKufToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignKufFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignKuiToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignKuiFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignKulToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignKulFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP0ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP0FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP1ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP1FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP10ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP10FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP2ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP2FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP3ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP3FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP4ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP4FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP5ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP5FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP6ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP6FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP7ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP7FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP8ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP8FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignP9ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignP9FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ0ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ0FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ1ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ1FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ10ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ10FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ2ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ2FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ3ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ3FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ4ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ4FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ5ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ5FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ6ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ6FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ7ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ7FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ8ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ8FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignQ9ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignQ9FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignTu1ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTu1FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignTu2ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTu2FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignTu3ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTu3FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignTu4ToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTu4FromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignTulToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTulFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignTupToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTupFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignTuqToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTuqFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignTuvToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: Seconds )
data class UnAssignTuvFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignVuimaxToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignVuimaxFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignVuiminToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignVuiminFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignVulmaxToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignVulmaxFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )
data class AssignVulminToUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID, val assignment: PU )
data class UnAssignVulminFromUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null )

// multiple association events


// UnderexcLimX1 Events

data class CreateUnderexcLimX1Event(
     var underexcLimX1Id: UUID? = null
)

data class UpdateUnderexcLimX1Event(
    @Id var underexcLimX1Id: UUID? = null,
    var k: PU,
    var kf2: PU,
    var km: PU,
    var melmax: PU,
    var tf2: Seconds,
    var tm: Seconds
)

data class DeleteUnderexcLimX1Event(@Id val underexcLimX1Id: UUID? = null)

// single association events
data class AssignKToUnderexcLimX1Event(@Id val underexcLimX1Id: UUID, val assignment: PU )
data class UnAssignKFromUnderexcLimX1Event(@Id val underexcLimX1Id: UUID? = null )
data class AssignKf2ToUnderexcLimX1Event(@Id val underexcLimX1Id: UUID, val assignment: PU )
data class UnAssignKf2FromUnderexcLimX1Event(@Id val underexcLimX1Id: UUID? = null )
data class AssignKmToUnderexcLimX1Event(@Id val underexcLimX1Id: UUID, val assignment: PU )
data class UnAssignKmFromUnderexcLimX1Event(@Id val underexcLimX1Id: UUID? = null )
data class AssignMelmaxToUnderexcLimX1Event(@Id val underexcLimX1Id: UUID, val assignment: PU )
data class UnAssignMelmaxFromUnderexcLimX1Event(@Id val underexcLimX1Id: UUID? = null )
data class AssignTf2ToUnderexcLimX1Event(@Id val underexcLimX1Id: UUID, val assignment: Seconds )
data class UnAssignTf2FromUnderexcLimX1Event(@Id val underexcLimX1Id: UUID? = null )
data class AssignTmToUnderexcLimX1Event(@Id val underexcLimX1Id: UUID, val assignment: Seconds )
data class UnAssignTmFromUnderexcLimX1Event(@Id val underexcLimX1Id: UUID? = null )

// multiple association events


// UnderexcLimX2 Events

data class CreateUnderexcLimX2Event(
     var underexcLimX2Id: UUID? = null
)

data class UpdateUnderexcLimX2Event(
    @Id var underexcLimX2Id: UUID? = null,
    var kf2: PU,
    var km: PU,
    var melmax: PU,
    var qo: PU,
    var r: PU,
    var tf2: Seconds,
    var tm: Seconds
)

data class DeleteUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null)

// single association events
data class AssignKf2ToUnderexcLimX2Event(@Id val underexcLimX2Id: UUID, val assignment: PU )
data class UnAssignKf2FromUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null )
data class AssignKmToUnderexcLimX2Event(@Id val underexcLimX2Id: UUID, val assignment: PU )
data class UnAssignKmFromUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null )
data class AssignMelmaxToUnderexcLimX2Event(@Id val underexcLimX2Id: UUID, val assignment: PU )
data class UnAssignMelmaxFromUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null )
data class AssignQoToUnderexcLimX2Event(@Id val underexcLimX2Id: UUID, val assignment: PU )
data class UnAssignQoFromUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null )
data class AssignRToUnderexcLimX2Event(@Id val underexcLimX2Id: UUID, val assignment: PU )
data class UnAssignRFromUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null )
data class AssignTf2ToUnderexcLimX2Event(@Id val underexcLimX2Id: UUID, val assignment: Seconds )
data class UnAssignTf2FromUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null )
data class AssignTmToUnderexcLimX2Event(@Id val underexcLimX2Id: UUID, val assignment: Seconds )
data class UnAssignTmFromUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null )

// multiple association events


// UnderexcitationLimiterDynamics Events

data class CreateUnderexcitationLimiterDynamicsEvent(
     var underexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateUnderexcitationLimiterDynamicsEvent(
    @Id var underexcitationLimiterDynamicsId: UUID? = null,
    var underexcitationLimiterDynamics: UnderexcitationLimiterDynamics
)

data class DeleteUnderexcitationLimiterDynamicsEvent(@Id val underexcitationLimiterDynamicsId: UUID? = null)

// single association events
data class AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsEvent(@Id val underexcitationLimiterDynamicsId: UUID, val assignment: UnderexcitationLimiterDynamics )
data class UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsEvent(@Id val underexcitationLimiterDynamicsId: UUID? = null )

// multiple association events


// UnderexcitationLimiterUserDefined Events

data class CreateUnderexcitationLimiterUserDefinedEvent(
     var underexcitationLimiterUserDefinedId: UUID? = null
)

data class UpdateUnderexcitationLimiterUserDefinedEvent(
    @Id var underexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteUnderexcitationLimiterUserDefinedEvent(@Id val underexcitationLimiterUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToUnderexcitationLimiterUserDefinedEvent(@Id val underexcitationLimiterUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromUnderexcitationLimiterUserDefinedEvent(@Id val underexcitationLimiterUserDefinedId: UUID? = null )

// multiple association events


// Unresolvedname Events

data class CreateUnresolvednameEvent(
     var unresolvednameId: UUID? = null
)

data class UpdateUnresolvednameEvent(
     var unresolvednameId: UUID? = null
)

data class DeleteUnresolvednameEvent(@Id val unresolvednameId: UUID? = null)

// single association events

// multiple association events


// VAdjIEEE Events

data class CreateVAdjIEEEEvent(
     var vAdjIEEEId: UUID? = null
)

data class UpdateVAdjIEEEEvent(
    @Id var vAdjIEEEId: UUID? = null,
    var adjslew: Simple_Float,
    var taoff: Seconds,
    var taon: Seconds,
    var vadjf: Simple_Float,
    var vadjmax: PU,
    var vadjmin: PU
)

data class DeleteVAdjIEEEEvent(@Id val vAdjIEEEId: UUID? = null)

// single association events
data class AssignAdjslewToVAdjIEEEEvent(@Id val vAdjIEEEId: UUID, val assignment: Simple_Float )
data class UnAssignAdjslewFromVAdjIEEEEvent(@Id val vAdjIEEEId: UUID? = null )
data class AssignTaoffToVAdjIEEEEvent(@Id val vAdjIEEEId: UUID, val assignment: Seconds )
data class UnAssignTaoffFromVAdjIEEEEvent(@Id val vAdjIEEEId: UUID? = null )
data class AssignTaonToVAdjIEEEEvent(@Id val vAdjIEEEId: UUID, val assignment: Seconds )
data class UnAssignTaonFromVAdjIEEEEvent(@Id val vAdjIEEEId: UUID? = null )
data class AssignVadjfToVAdjIEEEEvent(@Id val vAdjIEEEId: UUID, val assignment: Simple_Float )
data class UnAssignVadjfFromVAdjIEEEEvent(@Id val vAdjIEEEId: UUID? = null )
data class AssignVadjmaxToVAdjIEEEEvent(@Id val vAdjIEEEId: UUID, val assignment: PU )
data class UnAssignVadjmaxFromVAdjIEEEEvent(@Id val vAdjIEEEId: UUID? = null )
data class AssignVadjminToVAdjIEEEEvent(@Id val vAdjIEEEId: UUID, val assignment: PU )
data class UnAssignVadjminFromVAdjIEEEEvent(@Id val vAdjIEEEId: UUID? = null )

// multiple association events


// VCompIEEEType1 Events

data class CreateVCompIEEEType1Event(
     var vCompIEEEType1Id: UUID? = null
)

data class UpdateVCompIEEEType1Event(
    @Id var vCompIEEEType1Id: UUID? = null,
    var rc: PU,
    var tr: Seconds,
    var xc: PU
)

data class DeleteVCompIEEEType1Event(@Id val vCompIEEEType1Id: UUID? = null)

// single association events
data class AssignRcToVCompIEEEType1Event(@Id val vCompIEEEType1Id: UUID, val assignment: PU )
data class UnAssignRcFromVCompIEEEType1Event(@Id val vCompIEEEType1Id: UUID? = null )
data class AssignTrToVCompIEEEType1Event(@Id val vCompIEEEType1Id: UUID, val assignment: Seconds )
data class UnAssignTrFromVCompIEEEType1Event(@Id val vCompIEEEType1Id: UUID? = null )
data class AssignXcToVCompIEEEType1Event(@Id val vCompIEEEType1Id: UUID, val assignment: PU )
data class UnAssignXcFromVCompIEEEType1Event(@Id val vCompIEEEType1Id: UUID? = null )

// multiple association events


// VCompIEEEType2 Events

data class CreateVCompIEEEType2Event(
     var vCompIEEEType2Id: UUID? = null
)

data class UpdateVCompIEEEType2Event(
    @Id var vCompIEEEType2Id: UUID? = null,
    var tr: Seconds
)

data class DeleteVCompIEEEType2Event(@Id val vCompIEEEType2Id: UUID? = null)

// single association events
data class AssignTrToVCompIEEEType2Event(@Id val vCompIEEEType2Id: UUID, val assignment: Seconds )
data class UnAssignTrFromVCompIEEEType2Event(@Id val vCompIEEEType2Id: UUID? = null )

// multiple association events


// ValueAliasSet Events

data class CreateValueAliasSetEvent(
     var valueAliasSetId: UUID? = null
)

data class UpdateValueAliasSetEvent(
     var valueAliasSetId: UUID? = null
)

data class DeleteValueAliasSetEvent(@Id val valueAliasSetId: UUID? = null)

// single association events

// multiple association events


// ValueToAlias Events

data class CreateValueToAliasEvent(
     var valueToAliasId: UUID? = null
)

data class UpdateValueToAliasEvent(
    @Id var valueToAliasId: UUID? = null,
    var value: IntegerProxy,
    var values:  Set<ValueToAlias>
)

data class DeleteValueToAliasEvent(@Id val valueToAliasId: UUID? = null)

// single association events
data class AssignValueToValueToAliasEvent(@Id val valueToAliasId: UUID, val assignment: IntegerProxy )
data class UnAssignValueFromValueToAliasEvent(@Id val valueToAliasId: UUID? = null )

// multiple association events
data class AssignValuesToValueToAliasEvent(@Id val valueToAliasId: UUID, val addTo: ValueToAlias )
data class RemoveValuesFromValueToAliasEvent(@Id val valueToAliasId: UUID, val removeFrom: ValueToAlias )


// VisibilityLayer Events

data class CreateVisibilityLayerEvent(
     var visibilityLayerId: UUID? = null
)

data class UpdateVisibilityLayerEvent(
    @Id var visibilityLayerId: UUID? = null,
    var drawingOrder: IntegerProxy,
    var visibilityLayers:  Set<VisibilityLayer>
)

data class DeleteVisibilityLayerEvent(@Id val visibilityLayerId: UUID? = null)

// single association events
data class AssignDrawingOrderToVisibilityLayerEvent(@Id val visibilityLayerId: UUID, val assignment: IntegerProxy )
data class UnAssignDrawingOrderFromVisibilityLayerEvent(@Id val visibilityLayerId: UUID? = null )

// multiple association events
data class AssignVisibilityLayersToVisibilityLayerEvent(@Id val visibilityLayerId: UUID, val addTo: VisibilityLayer )
data class RemoveVisibilityLayersFromVisibilityLayerEvent(@Id val visibilityLayerId: UUID, val removeFrom: VisibilityLayer )


// Voltage Events

data class CreateVoltageEvent(
    @Id var voltageId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateVoltageEvent(
    @Id var voltageId: UUID? = null,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteVoltageEvent(@Id val voltageId: UUID? = null)

// single association events
data class AssignValueToVoltageEvent(@Id val voltageId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromVoltageEvent(@Id val voltageId: UUID? = null )

// multiple association events


// VoltageAdjusterDynamics Events

data class CreateVoltageAdjusterDynamicsEvent(
     var voltageAdjusterDynamicsId: UUID? = null
)

data class UpdateVoltageAdjusterDynamicsEvent(
    @Id var voltageAdjusterDynamicsId: UUID? = null,
    var voltageAdjusterDynamics: VoltageAdjusterDynamics
)

data class DeleteVoltageAdjusterDynamicsEvent(@Id val voltageAdjusterDynamicsId: UUID? = null)

// single association events
data class AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsEvent(@Id val voltageAdjusterDynamicsId: UUID, val assignment: VoltageAdjusterDynamics )
data class UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsEvent(@Id val voltageAdjusterDynamicsId: UUID? = null )

// multiple association events


// VoltageAdjusterUserDefined Events

data class CreateVoltageAdjusterUserDefinedEvent(
     var voltageAdjusterUserDefinedId: UUID? = null
)

data class UpdateVoltageAdjusterUserDefinedEvent(
    @Id var voltageAdjusterUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteVoltageAdjusterUserDefinedEvent(@Id val voltageAdjusterUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToVoltageAdjusterUserDefinedEvent(@Id val voltageAdjusterUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromVoltageAdjusterUserDefinedEvent(@Id val voltageAdjusterUserDefinedId: UUID? = null )

// multiple association events


// VoltageCompensatorDynamics Events

data class CreateVoltageCompensatorDynamicsEvent(
     var voltageCompensatorDynamicsId: UUID? = null
)

data class UpdateVoltageCompensatorDynamicsEvent(
    @Id var voltageCompensatorDynamicsId: UUID? = null,
    var voltageCompensatorDynamics: VoltageCompensatorDynamics
)

data class DeleteVoltageCompensatorDynamicsEvent(@Id val voltageCompensatorDynamicsId: UUID? = null)

// single association events
data class AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsEvent(@Id val voltageCompensatorDynamicsId: UUID, val assignment: VoltageCompensatorDynamics )
data class UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsEvent(@Id val voltageCompensatorDynamicsId: UUID? = null )

// multiple association events


// VoltageCompensatorUserDefined Events

data class CreateVoltageCompensatorUserDefinedEvent(
     var voltageCompensatorUserDefinedId: UUID? = null
)

data class UpdateVoltageCompensatorUserDefinedEvent(
    @Id var voltageCompensatorUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteVoltageCompensatorUserDefinedEvent(@Id val voltageCompensatorUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToVoltageCompensatorUserDefinedEvent(@Id val voltageCompensatorUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromVoltageCompensatorUserDefinedEvent(@Id val voltageCompensatorUserDefinedId: UUID? = null )

// multiple association events


// VoltageLevel Events

data class CreateVoltageLevelEvent(
     var voltageLevelId: UUID? = null
)

data class UpdateVoltageLevelEvent(
    @Id var voltageLevelId: UUID? = null,
    var highVoltageLimit: Voltage,
    var lowVoltageLimit: Voltage,
    var voltageLevel:  Set<VoltageLevel>,
    var voltageLevels:  Set<VoltageLevel>
)

data class DeleteVoltageLevelEvent(@Id val voltageLevelId: UUID? = null)

// single association events
data class AssignHighVoltageLimitToVoltageLevelEvent(@Id val voltageLevelId: UUID, val assignment: Voltage )
data class UnAssignHighVoltageLimitFromVoltageLevelEvent(@Id val voltageLevelId: UUID? = null )
data class AssignLowVoltageLimitToVoltageLevelEvent(@Id val voltageLevelId: UUID, val assignment: Voltage )
data class UnAssignLowVoltageLimitFromVoltageLevelEvent(@Id val voltageLevelId: UUID? = null )

// multiple association events
data class AssignVoltageLevelToVoltageLevelEvent(@Id val voltageLevelId: UUID, val addTo: VoltageLevel )
data class RemoveVoltageLevelFromVoltageLevelEvent(@Id val voltageLevelId: UUID, val removeFrom: VoltageLevel )
data class AssignVoltageLevelsToVoltageLevelEvent(@Id val voltageLevelId: UUID, val addTo: VoltageLevel )
data class RemoveVoltageLevelsFromVoltageLevelEvent(@Id val voltageLevelId: UUID, val removeFrom: VoltageLevel )


// VoltageLimit Events

data class CreateVoltageLimitEvent(
     var voltageLimitId: UUID? = null
)

data class UpdateVoltageLimitEvent(
    @Id var voltageLimitId: UUID? = null,
    var value: Voltage
)

data class DeleteVoltageLimitEvent(@Id val voltageLimitId: UUID? = null)

// single association events
data class AssignValueToVoltageLimitEvent(@Id val voltageLimitId: UUID, val assignment: Voltage )
data class UnAssignValueFromVoltageLimitEvent(@Id val voltageLimitId: UUID? = null )

// multiple association events


// VoltagePerReactivePower Events

data class CreateVoltagePerReactivePowerEvent(
    @Id var voltagePerReactivePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateVoltagePerReactivePowerEvent(
    @Id var voltagePerReactivePowerId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteVoltagePerReactivePowerEvent(@Id val voltagePerReactivePowerId: UUID? = null)

// single association events
data class AssignValueToVoltagePerReactivePowerEvent(@Id val voltagePerReactivePowerId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromVoltagePerReactivePowerEvent(@Id val voltagePerReactivePowerId: UUID? = null )

// multiple association events


// VolumeFlowRate Events

data class CreateVolumeFlowRateEvent(
    @Id var volumeFlowRateId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol
)

data class UpdateVolumeFlowRateEvent(
    @Id var volumeFlowRateId: UUID? = null,
    @Enumerated(EnumType.STRING) var denominatorMultiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var denominatorUnit: UnitSymbol,
    @Enumerated(EnumType.STRING) var multiplier: UnitMultiplier,
    @Enumerated(EnumType.STRING) var unit: UnitSymbol,
    var value: FloatProxy
)

data class DeleteVolumeFlowRateEvent(@Id val volumeFlowRateId: UUID? = null)

// single association events
data class AssignValueToVolumeFlowRateEvent(@Id val volumeFlowRateId: UUID, val assignment: FloatProxy )
data class UnAssignValueFromVolumeFlowRateEvent(@Id val volumeFlowRateId: UUID? = null )

// multiple association events


// VsCapabilityCurve Events

data class CreateVsCapabilityCurveEvent(
     var vsCapabilityCurveId: UUID? = null
)

data class UpdateVsCapabilityCurveEvent(
     var vsCapabilityCurveId: UUID? = null
)

data class DeleteVsCapabilityCurveEvent(@Id val vsCapabilityCurveId: UUID? = null)

// single association events

// multiple association events


// VsConverter Events

data class CreateVsConverterEvent(
     var vsConverterId: UUID? = null
)

data class UpdateVsConverterEvent(
    @Id var vsConverterId: UUID? = null,
    var maxModulationIndex: Simple_Float,
    var maxValveCurrent: CurrentFlow,
    var vsConverterDCSides:  Set<VsConverter>
)

data class DeleteVsConverterEvent(@Id val vsConverterId: UUID? = null)

// single association events
data class AssignMaxModulationIndexToVsConverterEvent(@Id val vsConverterId: UUID, val assignment: Simple_Float )
data class UnAssignMaxModulationIndexFromVsConverterEvent(@Id val vsConverterId: UUID? = null )
data class AssignMaxValveCurrentToVsConverterEvent(@Id val vsConverterId: UUID, val assignment: CurrentFlow )
data class UnAssignMaxValveCurrentFromVsConverterEvent(@Id val vsConverterId: UUID? = null )

// multiple association events
data class AssignVsConverterDCSidesToVsConverterEvent(@Id val vsConverterId: UUID, val addTo: VsConverter )
data class RemoveVsConverterDCSidesFromVsConverterEvent(@Id val vsConverterId: UUID, val removeFrom: VsConverter )


// WindAeroConstIEC Events

data class CreateWindAeroConstIECEvent(
     var windAeroConstIECId: UUID? = null
)

data class UpdateWindAeroConstIECEvent(
     var windAeroConstIECId: UUID? = null
)

data class DeleteWindAeroConstIECEvent(@Id val windAeroConstIECId: UUID? = null)

// single association events

// multiple association events


// WindAeroLinearIEC Events

data class CreateWindAeroLinearIECEvent(
     var windAeroLinearIECId: UUID? = null
)

data class UpdateWindAeroLinearIECEvent(
    @Id var windAeroLinearIECId: UUID? = null,
    var dpomega: PU,
    var dptheta: PU,
    var omegazero: PU,
    var pavail: PU,
    var thetazero: AngleDegrees
)

data class DeleteWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID? = null)

// single association events
data class AssignDpomegaToWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID, val assignment: PU )
data class UnAssignDpomegaFromWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID? = null )
data class AssignDpthetaToWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID, val assignment: PU )
data class UnAssignDpthetaFromWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID? = null )
data class AssignOmegazeroToWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID, val assignment: PU )
data class UnAssignOmegazeroFromWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID? = null )
data class AssignPavailToWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID, val assignment: PU )
data class UnAssignPavailFromWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID? = null )
data class AssignThetazeroToWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID, val assignment: AngleDegrees )
data class UnAssignThetazeroFromWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID? = null )

// multiple association events


// WindContCurrLimIEC Events

data class CreateWindContCurrLimIECEvent(
     var windContCurrLimIECId: UUID? = null
)

data class UpdateWindContCurrLimIECEvent(
    @Id var windContCurrLimIECId: UUID? = null,
    var imax: PU,
    var imaxdip: PU,
    var mdfslim: BooleanProxy,
    var mqpri: BooleanProxy,
    var tufilt: Seconds
)

data class DeleteWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID? = null)

// single association events
data class AssignImaxToWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID, val assignment: PU )
data class UnAssignImaxFromWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID? = null )
data class AssignImaxdipToWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID, val assignment: PU )
data class UnAssignImaxdipFromWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID? = null )
data class AssignMdfslimToWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID, val assignment: BooleanProxy )
data class UnAssignMdfslimFromWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID? = null )
data class AssignMqpriToWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID, val assignment: BooleanProxy )
data class UnAssignMqpriFromWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID? = null )
data class AssignTufiltToWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID, val assignment: Seconds )
data class UnAssignTufiltFromWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID? = null )

// multiple association events


// WindContPType3IEC Events

data class CreateWindContPType3IECEvent(
     var windContPType3IECId: UUID? = null
)

data class UpdateWindContPType3IECEvent(
    @Id var windContPType3IECId: UUID? = null,
    var dpmax: PU,
    var dtrisemaxlvrt: PU,
    var kdtd: PU,
    var kip: PU,
    var kpp: PU,
    var mplvrt: BooleanProxy,
    var omegaoffset: PU,
    var pdtdmax: PU,
    var rramp: PU,
    var tdvs: Seconds,
    var temin: PU,
    var tomegafilt: Seconds,
    var tpfilt: Seconds,
    var tpord: PU,
    var tufilt: Seconds,
    var tuscale: PU,
    var twref: Seconds,
    var udvs: PU,
    var updip: PU,
    var wdtd: PU,
    var zeta: Simple_Float
)

data class DeleteWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null)

// single association events
data class AssignDpmaxToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignDpmaxFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignDtrisemaxlvrtToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignDtrisemaxlvrtFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignKdtdToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignKdtdFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignKipToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignKipFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignKppToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignKppFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignMplvrtToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: BooleanProxy )
data class UnAssignMplvrtFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignOmegaoffsetToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignOmegaoffsetFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignPdtdmaxToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignPdtdmaxFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignRrampToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignRrampFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignTdvsToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: Seconds )
data class UnAssignTdvsFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignTeminToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignTeminFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignTomegafiltToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: Seconds )
data class UnAssignTomegafiltFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignTpfiltToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: Seconds )
data class UnAssignTpfiltFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignTpordToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignTpordFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignTufiltToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: Seconds )
data class UnAssignTufiltFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignTuscaleToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignTuscaleFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignTwrefToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: Seconds )
data class UnAssignTwrefFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignUdvsToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignUdvsFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignUpdipToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignUpdipFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignWdtdToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: PU )
data class UnAssignWdtdFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )
data class AssignZetaToWindContPType3IECEvent(@Id val windContPType3IECId: UUID, val assignment: Simple_Float )
data class UnAssignZetaFromWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null )

// multiple association events


// WindContPType4aIEC Events

data class CreateWindContPType4aIECEvent(
     var windContPType4aIECId: UUID? = null
)

data class UpdateWindContPType4aIECEvent(
    @Id var windContPType4aIECId: UUID? = null,
    var dpmax: PU,
    var tpord: Seconds,
    var tufilt: Seconds
)

data class DeleteWindContPType4aIECEvent(@Id val windContPType4aIECId: UUID? = null)

// single association events
data class AssignDpmaxToWindContPType4aIECEvent(@Id val windContPType4aIECId: UUID, val assignment: PU )
data class UnAssignDpmaxFromWindContPType4aIECEvent(@Id val windContPType4aIECId: UUID? = null )
data class AssignTpordToWindContPType4aIECEvent(@Id val windContPType4aIECId: UUID, val assignment: Seconds )
data class UnAssignTpordFromWindContPType4aIECEvent(@Id val windContPType4aIECId: UUID? = null )
data class AssignTufiltToWindContPType4aIECEvent(@Id val windContPType4aIECId: UUID, val assignment: Seconds )
data class UnAssignTufiltFromWindContPType4aIECEvent(@Id val windContPType4aIECId: UUID? = null )

// multiple association events


// WindContPType4bIEC Events

data class CreateWindContPType4bIECEvent(
     var windContPType4bIECId: UUID? = null
)

data class UpdateWindContPType4bIECEvent(
    @Id var windContPType4bIECId: UUID? = null,
    var dpmax: PU,
    var tpaero: Seconds,
    var tpord: Seconds,
    var tufilt: Seconds
)

data class DeleteWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID? = null)

// single association events
data class AssignDpmaxToWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID, val assignment: PU )
data class UnAssignDpmaxFromWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID? = null )
data class AssignTpaeroToWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID, val assignment: Seconds )
data class UnAssignTpaeroFromWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID? = null )
data class AssignTpordToWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID, val assignment: Seconds )
data class UnAssignTpordFromWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID? = null )
data class AssignTufiltToWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID, val assignment: Seconds )
data class UnAssignTufiltFromWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID? = null )

// multiple association events


// WindContPitchAngleIEC Events

data class CreateWindContPitchAngleIECEvent(
     var windContPitchAngleIECId: UUID? = null
)

data class UpdateWindContPitchAngleIECEvent(
    @Id var windContPitchAngleIECId: UUID? = null,
    var dthetamax: Simple_Float,
    var dthetamin: Simple_Float,
    var kic: PU,
    var kiomega: PU,
    var kpc: PU,
    var kpomega: PU,
    var kpx: PU,
    var thetamax: AngleDegrees,
    var thetamin: AngleDegrees,
    var ttheta: Seconds
)

data class DeleteWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null)

// single association events
data class AssignDthetamaxToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: Simple_Float )
data class UnAssignDthetamaxFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignDthetaminToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: Simple_Float )
data class UnAssignDthetaminFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignKicToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: PU )
data class UnAssignKicFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignKiomegaToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: PU )
data class UnAssignKiomegaFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignKpcToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: PU )
data class UnAssignKpcFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignKpomegaToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: PU )
data class UnAssignKpomegaFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignKpxToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: PU )
data class UnAssignKpxFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignThetamaxToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: AngleDegrees )
data class UnAssignThetamaxFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignThetaminToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: AngleDegrees )
data class UnAssignThetaminFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )
data class AssignTthetaToWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID, val assignment: Seconds )
data class UnAssignTthetaFromWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null )

// multiple association events


// WindContQIEC Events

data class CreateWindContQIECEvent(
    @Id var windContQIECId: UUID? = null,
    @Enumerated(EnumType.STRING) var windLVRTQcontrolModesType: WindLVRTQcontrolModesKind,
    @Enumerated(EnumType.STRING) var windQcontrolModesType: WindQcontrolModesKind
)

data class UpdateWindContQIECEvent(
    @Id var windContQIECId: UUID? = null,
    var iqh1: PU,
    var iqmax: PU,
    var iqmin: PU,
    var iqpost: PU,
    var kiq: PU,
    var kiu: PU,
    var kpq: PU,
    var kpu: PU,
    var kqv: PU,
    var qmax: PU,
    var qmin: PU,
    var rdroop: PU,
    var tiq: Seconds,
    var tpfilt: Seconds,
    var tpost: Seconds,
    var tqord: Seconds,
    var tufilt: Seconds,
    var udb1: PU,
    var udb2: PU,
    var umax: PU,
    var umin: PU,
    var uqdip: PU,
    var uref0: PU,
    @Enumerated(EnumType.STRING) var windLVRTQcontrolModesType: WindLVRTQcontrolModesKind,
    @Enumerated(EnumType.STRING) var windQcontrolModesType: WindQcontrolModesKind,
    var xdroop: PU
)

data class DeleteWindContQIECEvent(@Id val windContQIECId: UUID? = null)

// single association events
data class AssignIqh1ToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignIqh1FromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignIqmaxToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignIqmaxFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignIqminToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignIqminFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignIqpostToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignIqpostFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignKiqToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignKiqFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignKiuToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignKiuFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignKpqToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignKpqFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignKpuToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignKpuFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignKqvToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignKqvFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignQmaxToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignQmaxFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignQminToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignQminFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignRdroopToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignRdroopFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignTiqToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: Seconds )
data class UnAssignTiqFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignTpfiltToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: Seconds )
data class UnAssignTpfiltFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignTpostToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: Seconds )
data class UnAssignTpostFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignTqordToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: Seconds )
data class UnAssignTqordFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignTufiltToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: Seconds )
data class UnAssignTufiltFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignUdb1ToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignUdb1FromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignUdb2ToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignUdb2FromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignUmaxToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignUmaxFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignUminToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignUminFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignUqdipToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignUqdipFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignUref0ToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignUref0FromWindContQIECEvent(@Id val windContQIECId: UUID? = null )
data class AssignXdroopToWindContQIECEvent(@Id val windContQIECId: UUID, val assignment: PU )
data class UnAssignXdroopFromWindContQIECEvent(@Id val windContQIECId: UUID? = null )

// multiple association events


// WindContRotorRIEC Events

data class CreateWindContRotorRIECEvent(
     var windContRotorRIECId: UUID? = null
)

data class UpdateWindContRotorRIECEvent(
    @Id var windContRotorRIECId: UUID? = null,
    var kirr: PU,
    var komegafilt: Simple_Float,
    var kpfilt: Simple_Float,
    var kprr: PU,
    var rmax: PU,
    var rmin: PU,
    var tomegafilt: Seconds,
    var tpfilt: Seconds
)

data class DeleteWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null)

// single association events
data class AssignKirrToWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID, val assignment: PU )
data class UnAssignKirrFromWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null )
data class AssignKomegafiltToWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID, val assignment: Simple_Float )
data class UnAssignKomegafiltFromWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null )
data class AssignKpfiltToWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID, val assignment: Simple_Float )
data class UnAssignKpfiltFromWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null )
data class AssignKprrToWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID, val assignment: PU )
data class UnAssignKprrFromWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null )
data class AssignRmaxToWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID, val assignment: PU )
data class UnAssignRmaxFromWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null )
data class AssignRminToWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID, val assignment: PU )
data class UnAssignRminFromWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null )
data class AssignTomegafiltToWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID, val assignment: Seconds )
data class UnAssignTomegafiltFromWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null )
data class AssignTpfiltToWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID, val assignment: Seconds )
data class UnAssignTpfiltFromWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null )

// multiple association events


// WindDynamicsLookupTable Events

data class CreateWindDynamicsLookupTableEvent(
    @Id var windDynamicsLookupTableId: UUID? = null,
    @Enumerated(EnumType.STRING) var lookupTableFunctionType: WindLookupTableFunctionKind
)

data class UpdateWindDynamicsLookupTableEvent(
    @Id var windDynamicsLookupTableId: UUID? = null,
    var input: Simple_Float,
    @Enumerated(EnumType.STRING) var lookupTableFunctionType: WindLookupTableFunctionKind,
    var output: Simple_Float,
    var sequence: IntegerProxy,
    var windDynamicsLookupTable:  Set<WindDynamicsLookupTable>
)

data class DeleteWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID? = null)

// single association events
data class AssignInputToWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID, val assignment: Simple_Float )
data class UnAssignInputFromWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID? = null )
data class AssignOutputToWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID, val assignment: Simple_Float )
data class UnAssignOutputFromWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID? = null )
data class AssignSequenceToWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID, val assignment: IntegerProxy )
data class UnAssignSequenceFromWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID? = null )

// multiple association events
data class AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID, val addTo: WindDynamicsLookupTable )
data class RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID, val removeFrom: WindDynamicsLookupTable )


// WindGenTurbineType1IEC Events

data class CreateWindGenTurbineType1IECEvent(
     var windGenTurbineType1IECId: UUID? = null
)

data class UpdateWindGenTurbineType1IECEvent(
    @Id var windGenTurbineType1IECId: UUID? = null,
    var windGenTurbineType1IEC: WindGenTurbineType1IEC
)

data class DeleteWindGenTurbineType1IECEvent(@Id val windGenTurbineType1IECId: UUID? = null)

// single association events
data class AssignWindGenTurbineType1IECToWindGenTurbineType1IECEvent(@Id val windGenTurbineType1IECId: UUID, val assignment: WindGenTurbineType1IEC )
data class UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECEvent(@Id val windGenTurbineType1IECId: UUID? = null )

// multiple association events


// WindGenTurbineType2IEC Events

data class CreateWindGenTurbineType2IECEvent(
     var windGenTurbineType2IECId: UUID? = null
)

data class UpdateWindGenTurbineType2IECEvent(
    @Id var windGenTurbineType2IECId: UUID? = null,
    var windGenTurbineType2IEC: WindGenTurbineType2IEC
)

data class DeleteWindGenTurbineType2IECEvent(@Id val windGenTurbineType2IECId: UUID? = null)

// single association events
data class AssignWindGenTurbineType2IECToWindGenTurbineType2IECEvent(@Id val windGenTurbineType2IECId: UUID, val assignment: WindGenTurbineType2IEC )
data class UnAssignWindGenTurbineType2IECFromWindGenTurbineType2IECEvent(@Id val windGenTurbineType2IECId: UUID? = null )

// multiple association events


// WindGenTurbineType3IEC Events

data class CreateWindGenTurbineType3IECEvent(
     var windGenTurbineType3IECId: UUID? = null
)

data class UpdateWindGenTurbineType3IECEvent(
    @Id var windGenTurbineType3IECId: UUID? = null,
    var dipmax: PU,
    var diqmax: PU,
    var windGenTurbineType3IEC: WindGenTurbineType3IEC
)

data class DeleteWindGenTurbineType3IECEvent(@Id val windGenTurbineType3IECId: UUID? = null)

// single association events
data class AssignDipmaxToWindGenTurbineType3IECEvent(@Id val windGenTurbineType3IECId: UUID, val assignment: PU )
data class UnAssignDipmaxFromWindGenTurbineType3IECEvent(@Id val windGenTurbineType3IECId: UUID? = null )
data class AssignDiqmaxToWindGenTurbineType3IECEvent(@Id val windGenTurbineType3IECId: UUID, val assignment: PU )
data class UnAssignDiqmaxFromWindGenTurbineType3IECEvent(@Id val windGenTurbineType3IECId: UUID? = null )
data class AssignWindGenTurbineType3IECToWindGenTurbineType3IECEvent(@Id val windGenTurbineType3IECId: UUID, val assignment: WindGenTurbineType3IEC )
data class UnAssignWindGenTurbineType3IECFromWindGenTurbineType3IECEvent(@Id val windGenTurbineType3IECId: UUID? = null )

// multiple association events


// WindGenTurbineType3aIEC Events

data class CreateWindGenTurbineType3aIECEvent(
     var windGenTurbineType3aIECId: UUID? = null
)

data class UpdateWindGenTurbineType3aIECEvent(
    @Id var windGenTurbineType3aIECId: UUID? = null,
    var kpc: Simple_Float,
    var tic: Seconds,
    var xs: PU
)

data class DeleteWindGenTurbineType3aIECEvent(@Id val windGenTurbineType3aIECId: UUID? = null)

// single association events
data class AssignKpcToWindGenTurbineType3aIECEvent(@Id val windGenTurbineType3aIECId: UUID, val assignment: Simple_Float )
data class UnAssignKpcFromWindGenTurbineType3aIECEvent(@Id val windGenTurbineType3aIECId: UUID? = null )
data class AssignTicToWindGenTurbineType3aIECEvent(@Id val windGenTurbineType3aIECId: UUID, val assignment: Seconds )
data class UnAssignTicFromWindGenTurbineType3aIECEvent(@Id val windGenTurbineType3aIECId: UUID? = null )
data class AssignXsToWindGenTurbineType3aIECEvent(@Id val windGenTurbineType3aIECId: UUID, val assignment: PU )
data class UnAssignXsFromWindGenTurbineType3aIECEvent(@Id val windGenTurbineType3aIECId: UUID? = null )

// multiple association events


// WindGenTurbineType3bIEC Events

data class CreateWindGenTurbineType3bIECEvent(
     var windGenTurbineType3bIECId: UUID? = null
)

data class UpdateWindGenTurbineType3bIECEvent(
    @Id var windGenTurbineType3bIECId: UUID? = null,
    var fducw: Simple_Float,
    var mwtcwp: BooleanProxy,
    var tg: Seconds,
    var two: Seconds,
    var xs: PU
)

data class DeleteWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID? = null)

// single association events
data class AssignFducwToWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID, val assignment: Simple_Float )
data class UnAssignFducwFromWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID? = null )
data class AssignMwtcwpToWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID, val assignment: BooleanProxy )
data class UnAssignMwtcwpFromWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID? = null )
data class AssignTgToWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID, val assignment: Seconds )
data class UnAssignTgFromWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID? = null )
data class AssignTwoToWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID, val assignment: Seconds )
data class UnAssignTwoFromWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID? = null )
data class AssignXsToWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID, val assignment: PU )
data class UnAssignXsFromWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID? = null )

// multiple association events


// WindGenType4IEC Events

data class CreateWindGenType4IECEvent(
     var windGenType4IECId: UUID? = null
)

data class UpdateWindGenType4IECEvent(
    @Id var windGenType4IECId: UUID? = null,
    var dipmax: PU,
    var diqmax: PU,
    var diqmin: PU,
    var tg: Seconds
)

data class DeleteWindGenType4IECEvent(@Id val windGenType4IECId: UUID? = null)

// single association events
data class AssignDipmaxToWindGenType4IECEvent(@Id val windGenType4IECId: UUID, val assignment: PU )
data class UnAssignDipmaxFromWindGenType4IECEvent(@Id val windGenType4IECId: UUID? = null )
data class AssignDiqmaxToWindGenType4IECEvent(@Id val windGenType4IECId: UUID, val assignment: PU )
data class UnAssignDiqmaxFromWindGenType4IECEvent(@Id val windGenType4IECId: UUID? = null )
data class AssignDiqminToWindGenType4IECEvent(@Id val windGenType4IECId: UUID, val assignment: PU )
data class UnAssignDiqminFromWindGenType4IECEvent(@Id val windGenType4IECId: UUID? = null )
data class AssignTgToWindGenType4IECEvent(@Id val windGenType4IECId: UUID, val assignment: Seconds )
data class UnAssignTgFromWindGenType4IECEvent(@Id val windGenType4IECId: UUID? = null )

// multiple association events


// WindGeneratingUnit Events

data class CreateWindGeneratingUnitEvent(
    @Id var windGeneratingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var windGenUnitType: WindGenUnitKind
)

data class UpdateWindGeneratingUnitEvent(
    @Id var windGeneratingUnitId: UUID? = null,
    @Enumerated(EnumType.STRING) var windGenUnitType: WindGenUnitKind
)

data class DeleteWindGeneratingUnitEvent(@Id val windGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// WindMechIEC Events

data class CreateWindMechIECEvent(
     var windMechIECId: UUID? = null
)

data class UpdateWindMechIECEvent(
    @Id var windMechIECId: UUID? = null,
    var cdrt: PU,
    var hgen: Seconds,
    var hwtr: Seconds,
    var kdrt: PU
)

data class DeleteWindMechIECEvent(@Id val windMechIECId: UUID? = null)

// single association events
data class AssignCdrtToWindMechIECEvent(@Id val windMechIECId: UUID, val assignment: PU )
data class UnAssignCdrtFromWindMechIECEvent(@Id val windMechIECId: UUID? = null )
data class AssignHgenToWindMechIECEvent(@Id val windMechIECId: UUID, val assignment: Seconds )
data class UnAssignHgenFromWindMechIECEvent(@Id val windMechIECId: UUID? = null )
data class AssignHwtrToWindMechIECEvent(@Id val windMechIECId: UUID, val assignment: Seconds )
data class UnAssignHwtrFromWindMechIECEvent(@Id val windMechIECId: UUID? = null )
data class AssignKdrtToWindMechIECEvent(@Id val windMechIECId: UUID, val assignment: PU )
data class UnAssignKdrtFromWindMechIECEvent(@Id val windMechIECId: UUID? = null )

// multiple association events


// WindPitchContEmulIEC Events

data class CreateWindPitchContEmulIECEvent(
     var windPitchContEmulIECId: UUID? = null
)

data class UpdateWindPitchContEmulIECEvent(
    @Id var windPitchContEmulIECId: UUID? = null,
    var kdroop: Simple_Float,
    var kipce: Simple_Float,
    var komegaaero: PU,
    var kppce: Simple_Float,
    var omegaref: PU,
    var pimax: PU,
    var pimin: PU,
    var t1: Seconds,
    var t2: Seconds,
    var tpe: Seconds
)

data class DeleteWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null)

// single association events
data class AssignKdroopToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: Simple_Float )
data class UnAssignKdroopFromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignKipceToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: Simple_Float )
data class UnAssignKipceFromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignKomegaaeroToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: PU )
data class UnAssignKomegaaeroFromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignKppceToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: Simple_Float )
data class UnAssignKppceFromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignOmegarefToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: PU )
data class UnAssignOmegarefFromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignPimaxToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: PU )
data class UnAssignPimaxFromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignPiminToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: PU )
data class UnAssignPiminFromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignT1ToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: Seconds )
data class UnAssignT1FromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignT2ToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: Seconds )
data class UnAssignT2FromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )
data class AssignTpeToWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID, val assignment: Seconds )
data class UnAssignTpeFromWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null )

// multiple association events


// WindPlantDynamics Events

data class CreateWindPlantDynamicsEvent(
     var windPlantDynamicsId: UUID? = null
)

data class UpdateWindPlantDynamicsEvent(
    @Id var windPlantDynamicsId: UUID? = null,
    var windPlantDynamics: WindPlantDynamics
)

data class DeleteWindPlantDynamicsEvent(@Id val windPlantDynamicsId: UUID? = null)

// single association events
data class AssignWindPlantDynamicsToWindPlantDynamicsEvent(@Id val windPlantDynamicsId: UUID, val assignment: WindPlantDynamics )
data class UnAssignWindPlantDynamicsFromWindPlantDynamicsEvent(@Id val windPlantDynamicsId: UUID? = null )

// multiple association events


// WindPlantFreqPcontrolIEC Events

data class CreateWindPlantFreqPcontrolIECEvent(
     var windPlantFreqPcontrolIECId: UUID? = null
)

data class UpdateWindPlantFreqPcontrolIECEvent(
    @Id var windPlantFreqPcontrolIECId: UUID? = null,
    var dprefmax: PU,
    var dprefmin: PU,
    var kiwpp: Simple_Float,
    var kpwpp: Simple_Float,
    var prefmax: PU,
    var prefmin: PU,
    var tpft: Seconds,
    var tpfv: Seconds,
    var twpffilt: Seconds,
    var twppfilt: Seconds
)

data class DeleteWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null)

// single association events
data class AssignDprefmaxToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: PU )
data class UnAssignDprefmaxFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignDprefminToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: PU )
data class UnAssignDprefminFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignKiwppToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: Simple_Float )
data class UnAssignKiwppFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignKpwppToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: Simple_Float )
data class UnAssignKpwppFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignPrefmaxToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: PU )
data class UnAssignPrefmaxFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignPrefminToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: PU )
data class UnAssignPrefminFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignTpftToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: Seconds )
data class UnAssignTpftFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignTpfvToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: Seconds )
data class UnAssignTpfvFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignTwpffiltToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: Seconds )
data class UnAssignTwpffiltFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )
data class AssignTwppfiltToWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID, val assignment: Seconds )
data class UnAssignTwppfiltFromWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null )

// multiple association events


// WindPlantIEC Events

data class CreateWindPlantIECEvent(
     var windPlantIECId: UUID? = null
)

data class UpdateWindPlantIECEvent(
    @Id var windPlantIECId: UUID? = null,
    var windPlantIEC: WindPlantIEC
)

data class DeleteWindPlantIECEvent(@Id val windPlantIECId: UUID? = null)

// single association events
data class AssignWindPlantIECToWindPlantIECEvent(@Id val windPlantIECId: UUID, val assignment: WindPlantIEC )
data class UnAssignWindPlantIECFromWindPlantIECEvent(@Id val windPlantIECId: UUID? = null )

// multiple association events


// WindPlantReactiveControlIEC Events

data class CreateWindPlantReactiveControlIECEvent(
     var windPlantReactiveControlIECId: UUID? = null
)

data class UpdateWindPlantReactiveControlIECEvent(
    @Id var windPlantReactiveControlIECId: UUID? = null,
    var kiwpx: Simple_Float,
    var kpwpx: Simple_Float,
    var kwpqu: PU,
    var mwppf: BooleanProxy,
    var mwpu: BooleanProxy,
    var twppfilt: Seconds,
    var twpqfilt: Seconds,
    var twpufilt: Seconds,
    var txft: Seconds,
    var txfv: Seconds,
    var uwpqdip: PU,
    var xrefmax: PU,
    var xrefmin: PU
)

data class DeleteWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null)

// single association events
data class AssignKiwpxToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: Simple_Float )
data class UnAssignKiwpxFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignKpwpxToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: Simple_Float )
data class UnAssignKpwpxFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignKwpquToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: PU )
data class UnAssignKwpquFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignMwppfToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: BooleanProxy )
data class UnAssignMwppfFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignMwpuToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: BooleanProxy )
data class UnAssignMwpuFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignTwppfiltToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: Seconds )
data class UnAssignTwppfiltFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignTwpqfiltToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: Seconds )
data class UnAssignTwpqfiltFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignTwpufiltToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: Seconds )
data class UnAssignTwpufiltFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignTxftToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: Seconds )
data class UnAssignTxftFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignTxfvToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: Seconds )
data class UnAssignTxfvFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignUwpqdipToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: PU )
data class UnAssignUwpqdipFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignXrefmaxToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: PU )
data class UnAssignXrefmaxFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )
data class AssignXrefminToWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID, val assignment: PU )
data class UnAssignXrefminFromWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null )

// multiple association events


// WindPlantUserDefined Events

data class CreateWindPlantUserDefinedEvent(
     var windPlantUserDefinedId: UUID? = null
)

data class UpdateWindPlantUserDefinedEvent(
    @Id var windPlantUserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteWindPlantUserDefinedEvent(@Id val windPlantUserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToWindPlantUserDefinedEvent(@Id val windPlantUserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromWindPlantUserDefinedEvent(@Id val windPlantUserDefinedId: UUID? = null )

// multiple association events


// WindProtectionIEC Events

data class CreateWindProtectionIECEvent(
     var windProtectionIECId: UUID? = null
)

data class UpdateWindProtectionIECEvent(
    @Id var windProtectionIECId: UUID? = null,
    var fover: PU,
    var funder: PU,
    var tfover: Seconds,
    var tfunder: Seconds,
    var tuover: Seconds,
    var tuunder: Seconds,
    var uover: PU,
    var uunder: PU
)

data class DeleteWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null)

// single association events
data class AssignFoverToWindProtectionIECEvent(@Id val windProtectionIECId: UUID, val assignment: PU )
data class UnAssignFoverFromWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null )
data class AssignFunderToWindProtectionIECEvent(@Id val windProtectionIECId: UUID, val assignment: PU )
data class UnAssignFunderFromWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null )
data class AssignTfoverToWindProtectionIECEvent(@Id val windProtectionIECId: UUID, val assignment: Seconds )
data class UnAssignTfoverFromWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null )
data class AssignTfunderToWindProtectionIECEvent(@Id val windProtectionIECId: UUID, val assignment: Seconds )
data class UnAssignTfunderFromWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null )
data class AssignTuoverToWindProtectionIECEvent(@Id val windProtectionIECId: UUID, val assignment: Seconds )
data class UnAssignTuoverFromWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null )
data class AssignTuunderToWindProtectionIECEvent(@Id val windProtectionIECId: UUID, val assignment: Seconds )
data class UnAssignTuunderFromWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null )
data class AssignUoverToWindProtectionIECEvent(@Id val windProtectionIECId: UUID, val assignment: PU )
data class UnAssignUoverFromWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null )
data class AssignUunderToWindProtectionIECEvent(@Id val windProtectionIECId: UUID, val assignment: PU )
data class UnAssignUunderFromWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null )

// multiple association events


// WindTurbineType1or2Dynamics Events

data class CreateWindTurbineType1or2DynamicsEvent(
     var windTurbineType1or2DynamicsId: UUID? = null
)

data class UpdateWindTurbineType1or2DynamicsEvent(
    @Id var windTurbineType1or2DynamicsId: UUID? = null,
    var windTurbineType1or2Dynamics: WindTurbineType1or2Dynamics
)

data class DeleteWindTurbineType1or2DynamicsEvent(@Id val windTurbineType1or2DynamicsId: UUID? = null)

// single association events
data class AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsEvent(@Id val windTurbineType1or2DynamicsId: UUID, val assignment: WindTurbineType1or2Dynamics )
data class UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsEvent(@Id val windTurbineType1or2DynamicsId: UUID? = null )

// multiple association events


// WindTurbineType1or2IEC Events

data class CreateWindTurbineType1or2IECEvent(
     var windTurbineType1or2IECId: UUID? = null
)

data class UpdateWindTurbineType1or2IECEvent(
    @Id var windTurbineType1or2IECId: UUID? = null,
    var windTurbineType1or2IEC: WindTurbineType1or2IEC
)

data class DeleteWindTurbineType1or2IECEvent(@Id val windTurbineType1or2IECId: UUID? = null)

// single association events
data class AssignWindTurbineType1or2IECToWindTurbineType1or2IECEvent(@Id val windTurbineType1or2IECId: UUID, val assignment: WindTurbineType1or2IEC )
data class UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECEvent(@Id val windTurbineType1or2IECId: UUID? = null )

// multiple association events


// WindTurbineType3or4Dynamics Events

data class CreateWindTurbineType3or4DynamicsEvent(
     var windTurbineType3or4DynamicsId: UUID? = null
)

data class UpdateWindTurbineType3or4DynamicsEvent(
    @Id var windTurbineType3or4DynamicsId: UUID? = null,
    var windTurbineType3or4Dynamics: WindTurbineType3or4Dynamics
)

data class DeleteWindTurbineType3or4DynamicsEvent(@Id val windTurbineType3or4DynamicsId: UUID? = null)

// single association events
data class AssignWindTurbineType3or4DynamicsToWindTurbineType3or4DynamicsEvent(@Id val windTurbineType3or4DynamicsId: UUID, val assignment: WindTurbineType3or4Dynamics )
data class UnAssignWindTurbineType3or4DynamicsFromWindTurbineType3or4DynamicsEvent(@Id val windTurbineType3or4DynamicsId: UUID? = null )

// multiple association events


// WindTurbineType3or4IEC Events

data class CreateWindTurbineType3or4IECEvent(
     var windTurbineType3or4IECId: UUID? = null
)

data class UpdateWindTurbineType3or4IECEvent(
    @Id var windTurbineType3or4IECId: UUID? = null,
    var windTurbineType3or4IEC: WindTurbineType3or4IEC
)

data class DeleteWindTurbineType3or4IECEvent(@Id val windTurbineType3or4IECId: UUID? = null)

// single association events
data class AssignWindTurbineType3or4IECToWindTurbineType3or4IECEvent(@Id val windTurbineType3or4IECId: UUID, val assignment: WindTurbineType3or4IEC )
data class UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECEvent(@Id val windTurbineType3or4IECId: UUID? = null )

// multiple association events


// WindTurbineType4aIEC Events

data class CreateWindTurbineType4aIECEvent(
     var windTurbineType4aIECId: UUID? = null
)

data class UpdateWindTurbineType4aIECEvent(
    @Id var windTurbineType4aIECId: UUID? = null,
    var windTurbineType4aIEC: WindTurbineType4aIEC
)

data class DeleteWindTurbineType4aIECEvent(@Id val windTurbineType4aIECId: UUID? = null)

// single association events
data class AssignWindTurbineType4aIECToWindTurbineType4aIECEvent(@Id val windTurbineType4aIECId: UUID, val assignment: WindTurbineType4aIEC )
data class UnAssignWindTurbineType4aIECFromWindTurbineType4aIECEvent(@Id val windTurbineType4aIECId: UUID? = null )

// multiple association events


// WindTurbineType4bIEC Events

data class CreateWindTurbineType4bIECEvent(
     var windTurbineType4bIECId: UUID? = null
)

data class UpdateWindTurbineType4bIECEvent(
    @Id var windTurbineType4bIECId: UUID? = null,
    var windTurbineType4bIEC: WindTurbineType4bIEC
)

data class DeleteWindTurbineType4bIECEvent(@Id val windTurbineType4bIECId: UUID? = null)

// single association events
data class AssignWindTurbineType4bIECToWindTurbineType4bIECEvent(@Id val windTurbineType4bIECId: UUID, val assignment: WindTurbineType4bIEC )
data class UnAssignWindTurbineType4bIECFromWindTurbineType4bIECEvent(@Id val windTurbineType4bIECId: UUID? = null )

// multiple association events


// WindType1or2UserDefined Events

data class CreateWindType1or2UserDefinedEvent(
     var windType1or2UserDefinedId: UUID? = null
)

data class UpdateWindType1or2UserDefinedEvent(
    @Id var windType1or2UserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteWindType1or2UserDefinedEvent(@Id val windType1or2UserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToWindType1or2UserDefinedEvent(@Id val windType1or2UserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromWindType1or2UserDefinedEvent(@Id val windType1or2UserDefinedId: UUID? = null )

// multiple association events


// WindType3or4UserDefined Events

data class CreateWindType3or4UserDefinedEvent(
     var windType3or4UserDefinedId: UUID? = null
)

data class UpdateWindType3or4UserDefinedEvent(
    @Id var windType3or4UserDefinedId: UUID? = null,
    var proprietary: BooleanProxy
)

data class DeleteWindType3or4UserDefinedEvent(@Id val windType3or4UserDefinedId: UUID? = null)

// single association events
data class AssignProprietaryToWindType3or4UserDefinedEvent(@Id val windType3or4UserDefinedId: UUID, val assignment: BooleanProxy )
data class UnAssignProprietaryFromWindType3or4UserDefinedEvent(@Id val windType3or4UserDefinedId: UUID? = null )

// multiple association events



