/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * CsConverter business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of CsConverter related services in the case of a CsConverter
 *       business related service failing.
 *   <li>Exposes a simpler, uniform CsConverter interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill CsConverter business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class CsConverterBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public CsConverterBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * CsConverter Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return CsConverterBusinessDelegate
   */
  public static CsConverterBusinessDelegate getCsConverterInstance() {
    return (new CsConverterBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createCsConverter(CreateCsConverterCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getCsConverterId() == null) command.setCsConverterId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateCsConverterCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateCsConverterCommand of CsConverter is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create CsConverter - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateCsConverterCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateCsConverter(UpdateCsConverterCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateCsConverterCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save CsConverter - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteCsConverterCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteCsConverterCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteCsConverterCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete CsConverter using Id = " + command.getCsConverterId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the CsConverter via CsConverterFetchOneSummary
   *
   * @param summary CsConverterFetchOneSummary
   * @return CsConverterFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public CsConverter getCsConverter(CsConverterFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("CsConverterFetchOneSummary arg cannot be null");

    CsConverter entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      CsConverterValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a CsConverter
      // --------------------------------------
      CompletableFuture<CsConverter> futureEntity =
          queryGateway.query(
              new FindCsConverterQuery(new LoadCsConverterFilter(summary.getCsConverterId())),
              ResponseTypes.instanceOf(CsConverter.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate CsConverter with id " + summary.getCsConverterId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all CsConverters
   *
   * @return List<CsConverter>
   * @exception ProcessingException Thrown if any problems
   */
  public List<CsConverter> getAllCsConverter() throws ProcessingException {
    List<CsConverter> list = null;

    try {
      CompletableFuture<List<CsConverter>> futureList =
          queryGateway.query(
              new FindAllCsConverterQuery(), ResponseTypes.multipleInstancesOf(CsConverter.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all CsConverter";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign MaxAlpha on CsConverter
   *
   * @param command AssignMaxAlphaToCsConverterCommand
   * @exception ProcessingException
   */
  public void assignMaxAlpha(AssignMaxAlphaToCsConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCsConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    CsConverterBusinessDelegate parentDelegate =
        CsConverterBusinessDelegate.getCsConverterInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaxAlpha on CsConverter
   *
   * @param command UnAssignMaxAlphaFromCsConverterCommand
   * @exception ProcessingException
   */
  public void unAssignMaxAlpha(UnAssignMaxAlphaFromCsConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxAlpha on CsConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxGamma on CsConverter
   *
   * @param command AssignMaxGammaToCsConverterCommand
   * @exception ProcessingException
   */
  public void assignMaxGamma(AssignMaxGammaToCsConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCsConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    CsConverterBusinessDelegate parentDelegate =
        CsConverterBusinessDelegate.getCsConverterInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaxGamma on CsConverter
   *
   * @param command UnAssignMaxGammaFromCsConverterCommand
   * @exception ProcessingException
   */
  public void unAssignMaxGamma(UnAssignMaxGammaFromCsConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxGamma on CsConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxIdc on CsConverter
   *
   * @param command AssignMaxIdcToCsConverterCommand
   * @exception ProcessingException
   */
  public void assignMaxIdc(AssignMaxIdcToCsConverterCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCsConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    CsConverterBusinessDelegate parentDelegate =
        CsConverterBusinessDelegate.getCsConverterInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaxIdc on CsConverter
   *
   * @param command UnAssignMaxIdcFromCsConverterCommand
   * @exception ProcessingException
   */
  public void unAssignMaxIdc(UnAssignMaxIdcFromCsConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxIdc on CsConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinAlpha on CsConverter
   *
   * @param command AssignMinAlphaToCsConverterCommand
   * @exception ProcessingException
   */
  public void assignMinAlpha(AssignMinAlphaToCsConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCsConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    CsConverterBusinessDelegate parentDelegate =
        CsConverterBusinessDelegate.getCsConverterInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MinAlpha on CsConverter
   *
   * @param command UnAssignMinAlphaFromCsConverterCommand
   * @exception ProcessingException
   */
  public void unAssignMinAlpha(UnAssignMinAlphaFromCsConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinAlpha on CsConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinGamma on CsConverter
   *
   * @param command AssignMinGammaToCsConverterCommand
   * @exception ProcessingException
   */
  public void assignMinGamma(AssignMinGammaToCsConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCsConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    CsConverterBusinessDelegate parentDelegate =
        CsConverterBusinessDelegate.getCsConverterInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MinGamma on CsConverter
   *
   * @param command UnAssignMinGammaFromCsConverterCommand
   * @exception ProcessingException
   */
  public void unAssignMinGamma(UnAssignMinGammaFromCsConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinGamma on CsConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinIdc on CsConverter
   *
   * @param command AssignMinIdcToCsConverterCommand
   * @exception ProcessingException
   */
  public void assignMinIdc(AssignMinIdcToCsConverterCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCsConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    CsConverterBusinessDelegate parentDelegate =
        CsConverterBusinessDelegate.getCsConverterInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MinIdc on CsConverter
   *
   * @param command UnAssignMinIdcFromCsConverterCommand
   * @exception ProcessingException
   */
  public void unAssignMinIdc(UnAssignMinIdcFromCsConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinIdc on CsConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedIdc on CsConverter
   *
   * @param command AssignRatedIdcToCsConverterCommand
   * @exception ProcessingException
   */
  public void assignRatedIdc(AssignRatedIdcToCsConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCsConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    CsConverterBusinessDelegate parentDelegate =
        CsConverterBusinessDelegate.getCsConverterInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedIdc on CsConverter
   *
   * @param command UnAssignRatedIdcFromCsConverterCommand
   * @exception ProcessingException
   */
  public void unAssignRatedIdc(UnAssignRatedIdcFromCsConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CsConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedIdc on CsConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return CsConverter
   */
  private CsConverter load(UUID id) throws ProcessingException {
    csConverter =
        CsConverterBusinessDelegate.getCsConverterInstance()
            .getCsConverter(new CsConverterFetchOneSummary(id));
    return csConverter;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private CsConverter csConverter = null;
  private static final Logger LOGGER =
      Logger.getLogger(CsConverterBusinessDelegate.class.getName());
}
